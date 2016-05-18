package com.victormartin.projectcawd.base.di.module;

import android.app.Activity;
import com.victormartin.projectcawd.data.di.RepositoriesModule;
import com.victormartin.projectcawd.domain.di.UseCasesModule;
import com.victormartin.projectcawd.presentation.di.PresentationModule;
import dagger.Module;
import dagger.Provides;

@Module(
        includes = {
                PresentationModule.class,
                RepositoriesModule.class,
                UseCasesModule.class
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
