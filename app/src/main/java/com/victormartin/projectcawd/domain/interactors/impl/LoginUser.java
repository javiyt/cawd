package com.victormartin.projectcawd.domain.interactors.impl;

import com.victormartin.projectcawd.domain.executor.Executor;
import com.victormartin.projectcawd.domain.executor.MainThread;
import com.victormartin.projectcawd.domain.interactors.base.AbstractUseCase;
import com.victormartin.projectcawd.domain.model.User;
import com.victormartin.projectcawd.domain.repository.UserRepository;
import javax.inject.Inject;

public class LoginUser extends AbstractUseCase
        implements com.victormartin.projectcawd.domain.interactors.LoginUser, Runnable {

    protected Executor mThreadExecutor;
    protected MainThread mMainThread;

    private com.victormartin.projectcawd.domain.interactors.LoginUser.Callback callback;
    private UserRepository repository;

    private String identifier;
    private String password;

    @Inject
    public LoginUser(
            Executor threadExecutor,
            MainThread mainThread,
            UserRepository userRepository) {

        this.mThreadExecutor = threadExecutor;
        this.mMainThread = mainThread;
        this.repository = userRepository;
    }

    @Override
    public void run() {
        this.repository.loginUser(new UserRepository.Callback() {
            @Override
            public void onSuccess(User user) {
                notifyOnSuccess(user);
            }

            @Override
            public void onError() {
                notifyOnError();
            }
        }, identifier, password);
    }

    @Override
    public void execute(Callback callback) {
        this.callback = callback;
        this.mThreadExecutor.execute(this);
    }

    private void notifyOnSuccess(final User user) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onLoginUser(user);
            }
        });
    }

    protected void notifyOnError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onError();
            }
        });
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
