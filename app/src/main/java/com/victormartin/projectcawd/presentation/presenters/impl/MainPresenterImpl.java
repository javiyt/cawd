package com.victormartin.projectcawd.presentation.presenters.impl;

import com.victormartin.projectcawd.domain.executor.Executor;
import com.victormartin.projectcawd.domain.executor.MainThread;
import com.victormartin.projectcawd.domain.interactors.UserInteractor;
import com.victormartin.projectcawd.presentation.presenters.base.AbstractPresenter;
import com.victormartin.projectcawd.presentation.presenters.MainPresenter;

/**
 * Created by dmilicic on 12/13/15.
 */
public class MainPresenterImpl extends AbstractPresenter implements MainPresenter, UserInteractor.Callback {

    private MainPresenter.View mView;

    public MainPresenterImpl(Executor executor,
                             MainThread mainThread,
                             View view) {
        super(executor, mainThread);
        mView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }
}
