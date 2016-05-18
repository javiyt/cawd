package com.victormartin.projectcawd.presentation.presenters.impl;

import com.victormartin.projectcawd.domain.interactors.GetUserNameUseCase;
import com.victormartin.projectcawd.presentation.presenters.MainPresenter;
import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter {

    private final GetUserNameUseCase getUserNameUseCase;
    private MainPresenter.View view;

    @Inject
    public MainPresenterImpl(GetUserNameUseCase getUserNameUseCase) {
        this.getUserNameUseCase = getUserNameUseCase;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void resume() {
        //execution of use case
        getUserNameUseCase.execute(new GetUserNameUseCase.Callback() {

            @Override
            public void onGetUserName(String name) {
                //the result of execute use case
            }

            @Override
            public void onError() { }
        });
    }

    @Override
    public void pause() { }

    @Override
    public void stop() { }

    @Override
    public void destroy() { }

    @Override
    public void onError(String message) { }
}
