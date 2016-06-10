package com.victormartin.projectcawd.presentation.presenters.impl;

import com.victormartin.projectcawd.domain.interactors.LoginUser;
import com.victormartin.projectcawd.domain.model.User;
import com.victormartin.projectcawd.presentation.presenters.MainPresenter;
import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter {

    private LoginUser loginUser;
    private MainPresenter.View view;
    private String identifier;
    private String password;

    @Inject
    public MainPresenterImpl(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void initialize() { }

    @Override
    public void validateEmail(){
        EmailChecker checker = new EmailChecker(identifier);
        boolean valid = checker.isValid();

        if (!valid) {
            view.showErrorInvalidEmail();
        } else {
            view.enablePassword();

        }
    }

    @Override
    public void loginUser(String identifier, String password) {
        this.identifier = identifier;
        this.password = password;

        //TODO: validate data

        EmailChecker checker = new EmailChecker(identifier);
        boolean valid = checker.isValid();

        if (!valid) {
            view.showErrorInvalidEmail();
        } else {
            //TODO: VALIDATE PASS

        }

        loginUser.setIdentifier(this.identifier);
        loginUser.setPassword(this.password);

        //execution of use case
        loginUser.execute(new LoginUser.Callback() {

            @Override
            public void onLoginUser(User name) {

                view.showToken(name.getToken());
                //the result of execute use case
            }

            @Override
            public void onError() {
                view.showFuckingError();
            }
        });
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
