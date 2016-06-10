package com.victormartin.projectcawd.domain.interactors;

import com.victormartin.projectcawd.domain.model.User;

public interface LoginUser {

    void setIdentifier(String identifier);

    void setPassword(String password);

    void execute(final Callback callback);

    interface Callback {
        void onLoginUser(User name);
        void onError();
    }
}
