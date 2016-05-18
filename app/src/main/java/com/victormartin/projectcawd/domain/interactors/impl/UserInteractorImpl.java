package com.victormartin.projectcawd.domain.interactors.impl;

import com.victormartin.projectcawd.domain.executor.Executor;
import com.victormartin.projectcawd.domain.executor.MainThread;
import com.victormartin.projectcawd.domain.interactors.UserInteractor;
import com.victormartin.projectcawd.domain.interactors.base.AbstractInteractor;
import com.victormartin.projectcawd.domain.model.User;
import com.victormartin.projectcawd.domain.repository.UserRepository;
import javax.inject.Inject;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class UserInteractorImpl extends AbstractInteractor implements UserInteractor, Runnable {

    protected Executor mThreadExecutor;
    protected MainThread mMainThread;

    protected volatile boolean mIsCanceled;
    protected volatile boolean mIsRunning;

    private final Executor threadExecutor;
    private UserInteractor.Callback callback;
    private UserRepository repository;

    @Inject
    public UserInteractorImpl(
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
