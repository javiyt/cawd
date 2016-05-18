package com.victormartin.projectcawd.base.di.module;

import com.victormartin.projectcawd.base.di.PerActivity;
import com.victormartin.projectcawd.domain.interactors.UserInteractor;
import com.victormartin.projectcawd.domain.interactors.impl.UserInteractorImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    public UserModule() {}

    @Provides
    @PerActivity
    UserInteractor provideUserInteractor(UserInteractorImpl interactor) {
        return interactor;
    }
}
