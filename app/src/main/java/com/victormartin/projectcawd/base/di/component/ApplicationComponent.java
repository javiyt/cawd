package com.victormartin.projectcawd.base.di.component;

import android.app.Application;
import android.content.Context;
import com.victormartin.projectcawd.base.di.module.ApplicationModule;
import com.victormartin.projectcawd.domain.executor.Executor;
import com.victormartin.projectcawd.domain.executor.MainThread;
import com.victormartin.projectcawd.presentation.ui.activities.MainActivity;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainActivity activity);

    Application getApplication();

    Context context();

    Executor executor();

    MainThread mainThread();
}
