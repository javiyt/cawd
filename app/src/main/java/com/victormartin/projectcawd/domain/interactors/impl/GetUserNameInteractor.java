package com.victormartin.projectcawd.domain.interactors.impl;

import com.victormartin.projectcawd.domain.executor.Executor;
import com.victormartin.projectcawd.domain.executor.MainThread;
import com.victormartin.projectcawd.domain.interactors.GetUserNameUseCase;
import com.victormartin.projectcawd.domain.interactors.base.AbstractUseCase;
import com.victormartin.projectcawd.domain.model.User;
import com.victormartin.projectcawd.domain.repository.UserRepository;
import javax.inject.Inject;

public class GetUserNameInteractor extends AbstractUseCase
        implements GetUserNameUseCase, Runnable {

    protected Executor mThreadExecutor;
    protected MainThread mMainThread;

    private GetUserNameUseCase.Callback callback;
    private UserRepository repository;

    @Inject
    public GetUserNameInteractor(
            Executor threadExecutor,
            MainThread mainThread,
            UserRepository userRepository) {

        this.mThreadExecutor = threadExecutor;
        this.mMainThread = mainThread;
        this.repository = userRepository;
    }

    @Override
    public void run() {
        this.repository.get(new UserRepository.Callback() {
            @Override
            public void onSuccess(User user) {
                notifyOnSuccess(user);
            }

            @Override
            public void onError() {
                notifyOnError();
            }
        }, null);
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
                callback.onGetUserName(user.getName());
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
}
