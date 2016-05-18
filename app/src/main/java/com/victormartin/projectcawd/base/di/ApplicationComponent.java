package com.victormartin.projectcawd.base.di;

import android.app.Application;
import android.content.Context;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Application getApplication();

    Context context();
}
