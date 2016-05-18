package com.victormartin.projectcawd.domain.interactors;

public interface GetUserNameUseCase {

    void execute(final Callback callback);

    interface Callback {
        void onGetUserName(String name);
        void onError();
    }
}
