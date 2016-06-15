package com.victormartin.projectcawd.presentation.presenters;

import com.victormartin.projectcawd.domain.model.User;
import com.victormartin.projectcawd.presentation.presenters.base.BasePresenter;
import com.victormartin.projectcawd.presentation.ui.BaseView;

public interface MainPresenter extends BasePresenter {

    void setView(View view);

    void initialize();

    void loginUser(String identifier, String password);

    void validateEmail(String identifier);

    void validatePassword(String password);

    void validateCredentials(String identifier, String password);

    interface View extends BaseView {

        void showErrorInvalidEmail();

        void showErrorInvalidPassword();

        void enableIdentifier();

        void disableIdentifier();

        void enablePassword();

        void disablePassword();

        void enableLoginButton();

        void disableLoginButton();

        void authSuccessful(User user);

        void authError();

        void loginUserAction();

        void loginButtonType(int type);

        // TODO: Add your view methods
    }
}
