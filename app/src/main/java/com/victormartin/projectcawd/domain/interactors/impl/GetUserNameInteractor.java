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

    protected volatile boolean mIsCanceled;
    protected volatile boolean mIsRunning;

    private final Executor threadExecutor;
    private com.victormartin.projectcawd.domain.interactors.GetUserNameUseCase.Callback callback;
    private UserRepository repository;

    @Inject
    public GetUserNameInteractor(
            Executor threadExecutor,
            MainThread mainThread,
            UserRepository userRepository) {

        this.threadExecutor = threadExecutor;
        this.mMainThread = mainThread;
        this.repository = userRepository;
    }

    @Override
    public void run() {
        //TODO: add callback to repository
        User user = this.repository.get(1);
        callback.onGetUserName(user.toString());
    }

    @Override
    public void execute(Callback callback) {
        this.callback = callback;
        this.mThreadExecutor.execute(this);
    }
}
