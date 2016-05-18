package com.victormartin.projectcawd.base.di.component;

import android.app.Application;
import android.content.Context;
import com.victormartin.projectcawd.base.di.module.ApplicationModule;
import com.victormartin.projectcawd.domain.executor.Executor;
import com.victormartin.projectcawd.domain.executor.MainThread;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Application getApplication();

    Context context();

    Executor executor();

    MainThread mainThread();
}
