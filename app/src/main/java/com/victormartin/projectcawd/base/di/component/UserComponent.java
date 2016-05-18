package com.victormartin.projectcawd.base.di.component;

import com.victormartin.projectcawd.base.di.PerActivity;
import com.victormartin.projectcawd.base.di.module.ActivityModule;
import com.victormartin.projectcawd.base.di.module.UserModule;
import com.victormartin.projectcawd.presentation.ui.fragments.MainFragment;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = { ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent{
    void inject(MainFragment mainFragment);

}
