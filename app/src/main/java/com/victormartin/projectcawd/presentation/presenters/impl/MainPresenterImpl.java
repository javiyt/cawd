package com.victormartin.projectcawd.presentation.presenters.impl;

import com.orhanobut.hawk.Hawk;
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
        } /*else {
            view.enablePassword();
        }*/
    }

    @Override
    public void validatePassword() {
        PasswordChecker checker = new PasswordChecker(password);
        boolean valid = checker.isValid();

        if (!valid) {
            view.showErrorInvalidPassword();
        } else {
            view.enableLoginButton();
        }

    }

    @Override
    public void validateCredentials() {
        PasswordChecker checkerPassword = new PasswordChecker(password);
        EmailChecker checkerEmail = new EmailChecker(identifier);
        boolean validPassword = checkerPassword.isValid();
        boolean validEmail = checkerEmail.isValid();

        if(validEmail && validPassword){
            view.enableLoginButton();
        }else{
            view.authError();
            view.disableLoginButton();
        }
    }

    @Override
    public void loginUser(String identifier, String password) {
        this.identifier = identifier;
        this.password = password;

        loginUser.setIdentifier(this.identifier);
        loginUser.setPassword(this.password);

        //execution of use case
        loginUser.execute(new LoginUser.Callback() {

            @Override
            public void onLoginUser(User user) {

                Hawk.put("USER", user);
                view.authSuccessful(user);
                //the result of execute use case
            }

            @Override
            public void onError() {
                view.authError();
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
