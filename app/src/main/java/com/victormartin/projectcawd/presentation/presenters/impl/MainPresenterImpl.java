package com.victormartin.projectcawd.presentation.presenters.impl;

import com.victormartin.projectcawd.domain.executor.Executor;
import com.victormartin.projectcawd.domain.executor.MainThread;
import com.victormartin.projectcawd.domain.interactors.UserInteractor;
import com.victormartin.projectcawd.presentation.presenters.base.AbstractPresenter;
import com.victormartin.projectcawd.presentation.presenters.MainPresenter;
import javax.inject.Inject;

public class MainPresenterImpl extends AbstractPresenter implements MainPresenter, UserInteractor.Callback {

    private MainPresenter.View view;

    @Inject
    public MainPresenterImpl(
            Executor executor,
            MainThread mainThread) {
        super(executor, mainThread);
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void resume() { }

    @Override
    public void pause() { }

    @Override
    public void stop() { }

    @Override
    public void destroy() { }

    @Override
    public void onError(String message) { }
}
