package com.victormartin.projectcawd.base.di;

import android.app.Application;
import android.content.Context;
import com.victormartin.projectcawd.presentation.ui.activities.MainActivity;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainActivity client);

    Application getApplication();

    Context context();
}
