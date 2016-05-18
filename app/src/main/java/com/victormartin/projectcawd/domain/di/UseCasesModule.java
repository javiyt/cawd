package com.victormartin.projectcawd.domain.di;

import com.victormartin.projectcawd.domain.interactors.UserInteractor;
import com.victormartin.projectcawd.domain.interactors.impl.UserInteractorImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class UseCasesModule {

    @Provides
    UserInteractor provideUserInteractor(UserInteractorImpl interactor) {
        return interactor;
    }
}
