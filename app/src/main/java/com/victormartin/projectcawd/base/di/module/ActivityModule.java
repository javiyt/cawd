package com.victormartin.projectcawd.base.di.module;

import android.app.Activity;
import com.victormartin.projectcawd.data.di.ApiModule;
import com.victormartin.projectcawd.data.di.DatasourcesModule;
import com.victormartin.projectcawd.data.di.RepositoriesModule;
import com.victormartin.projectcawd.presentation.di.PresentationModule;
import dagger.Module;
import dagger.Provides;

@Module(
        includes = {
                PresentationModule.class,
                RepositoriesModule.class,
                ApiModule.class,
                DatasourcesModule.class
        }
)
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity provideActivity() {
        return this.activity;
    }
}
