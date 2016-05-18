package com.victormartin.projectcawd.base.di.module;

import com.victormartin.projectcawd.base.di.PerActivity;
import com.victormartin.projectcawd.domain.interactors.GetUserNameUseCase;
import com.victormartin.projectcawd.domain.interactors.impl.GetUserNameInteractor;
import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    public UserModule() {}

    @Provides
    @PerActivity
    GetUserNameUseCase provideUserInteractor(GetUserNameInteractor interactor) {
        return interactor;
    }
}
