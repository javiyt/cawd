package com.victormartin.projectcawd.presentation.presenters;

import com.victormartin.projectcawd.domain.model.User;
import com.victormartin.projectcawd.presentation.presenters.base.BasePresenter;
import com.victormartin.projectcawd.presentation.ui.BaseView;

public interface MainPresenter extends BasePresenter {

    void setView(View view);

    void initialize();

    void loginUser(String identifier, String password);

    void validateEmail();

    void validatePassword();

    void validateCredentials();

    interface View extends BaseView {

        void showErrorInvalidEmail();

        void showErrorInvalidPassword();

        void enablePassword();

        void enableLoginButton();

        void disableLoginButton();

        void authSuccessful(User user);

        void authError();

        // TODO: Add your view methods
    }
}
