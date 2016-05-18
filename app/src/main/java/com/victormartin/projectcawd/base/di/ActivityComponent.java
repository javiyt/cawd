package com.victormartin.projectcawd.base.di;

import com.victormartin.projectcawd.presentation.ui.activities.MainActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);

}
