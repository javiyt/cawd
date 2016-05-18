package com.victormartin.projectcawd.presentation.di;

import com.victormartin.projectcawd.presentation.presenters.MainPresenter;
import com.victormartin.projectcawd.presentation.presenters.impl.MainPresenterImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    @Provides
    MainPresenter provideMainPresenter(MainPresenterImpl presenter) {
        return presenter;
    }
}
