package com.victormartin.projectcawd.base.di;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    public Application provideApplication() {
        return this.application;
    }

    @Provides
    public Context provideContext() {
        return this.application.getApplicationContext();
    }
}
