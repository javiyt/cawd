package com.victormartin.projectcawd.base.di.module;

import android.app.Application;
import android.content.Context;
import com.victormartin.projectcawd.domain.executor.Executor;
import com.victormartin.projectcawd.domain.executor.MainThread;
import com.victormartin.projectcawd.domain.executor.impl.ThreadExecutor;
import com.victormartin.projectcawd.base.threading.MainThreadImpl;
import javax.inject.Singleton;
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

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return new ThreadExecutor();
    }

    @Provides
    @Singleton
    public MainThread provideMainThread(MainThreadImpl uiThread) {
        return uiThread;
    }
}
