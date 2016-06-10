package com.victormartin.projectcawd.presentation.presenters;

import com.victormartin.projectcawd.presentation.presenters.base.BasePresenter;
import com.victormartin.projectcawd.presentation.ui.BaseView;

public interface MainPresenter extends BasePresenter {

    void setView(View view);

    void initialize();

    void loginUser(String identifier, String password);

    void validateEmail();

    interface View extends BaseView {

        void showFuckingError();

        void showToken(String token);

        void showErrorInvalidEmail();

        void enablePassword();

        // TODO: Add your view methods
    }
}
