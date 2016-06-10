package com.victormartin.projectcawd.base.di.module;

import com.victormartin.projectcawd.base.di.PerActivity;
import com.victormartin.projectcawd.domain.interactors.LoginUser;
import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    public UserModule() {}

    @Provides
    @PerActivity
    LoginUser provideUserInteractor(com.victormartin.projectcawd.domain.interactors.impl.LoginUser interactor) {
        return interactor;
    }
}
