package com.victormartin.projectcawd.base.di.component;

import com.victormartin.projectcawd.base.di.PerActivity;
import com.victormartin.projectcawd.base.di.module.ActivityModule;
import com.victormartin.projectcawd.presentation.ui.activities.MainActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
}
