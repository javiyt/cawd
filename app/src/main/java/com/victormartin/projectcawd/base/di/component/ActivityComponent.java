package com.victormartin.projectcawd.base.di.component;

import android.app.Activity;
import com.victormartin.projectcawd.base.di.PerActivity;
import com.victormartin.projectcawd.base.di.module.ActivityModule;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();
}
