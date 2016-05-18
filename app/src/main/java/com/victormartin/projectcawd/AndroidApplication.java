package com.victormartin.projectcawd;

import android.app.Application;
import com.victormartin.projectcawd.base.di.ApplicationComponent;
import com.victormartin.projectcawd.base.di.ApplicationModule;
import com.victormartin.projectcawd.base.di.DaggerApplicationComponent;
import timber.log.Timber;
import timber.log.Timber.DebugTree;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        setupInjector();

        // initiate Timber
        Timber.plant(new DebugTree());
    }

    private void setupInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
