package com.victormartin.projectcawd.presentation.presenters.impl;

import android.text.TextUtils;
import android.util.Log;

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
    public void validateEmail(String identifier){
        EmailChecker checker = new EmailChecker(identifier);
        boolean valid = checker.isValid();

        if (!valid) {
            //view.showErrorInvalidEmail(); // To intrusive to show warnings if I input wrong identifier, better to wait until we click on login button
        } else {
            this.identifier = identifier;
            view.enablePassword();
        }
    }

    @Override
    public void validatePassword(String password) {
        PasswordChecker checker = new PasswordChecker(password);
        boolean valid = checker.isValid();

        if (!valid) {
            view.showErrorInvalidPassword();
        } else {
            this.password = password;
            view.enableLoginButton();
        }

    }

    @Override
    public void validateCredentials(String identifier, String password) {

        if(!TextUtils.isEmpty(identifier) && !TextUtils.isEmpty(password)){
            EmailChecker checkerEmail = new EmailChecker(identifier);
            PasswordChecker checkerPassword = new PasswordChecker(password);
            boolean validEmail = checkerEmail.isValid();
            boolean validPassword = checkerPassword.isValid();

            if(validEmail && validPassword){
                Log.e("validCred", "validEmail && validPassword");
                view.loginUserAction();     //If it's ok, we login in.
            }else{
                Log.e("validCred", "!(validEmail && validPassword)");
                view.authError();
                view.disableLoginButton();
            }
        }else{
            Log.e("validCred", "identifier & password are empty");
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
                Log.e("onLoginUser", "" + user.getToken());
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
