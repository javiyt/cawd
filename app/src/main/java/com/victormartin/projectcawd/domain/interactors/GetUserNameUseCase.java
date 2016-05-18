package com.victormartin.projectcawd.domain.interactors;

import com.victormartin.projectcawd.domain.interactors.base.UseCase;

public interface GetUserNameUseCase extends UseCase {

    interface Callback {
        void onGetUserName(String name);
        void onError();
    }
}
