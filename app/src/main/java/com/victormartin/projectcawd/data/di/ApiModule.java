package com.victormartin.projectcawd.data.di;

import com.victormartin.projectcawd.data.api.UserApi;
import com.victormartin.projectcawd.data.api.UserApiImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Provides
    UserApi provideUserApi(UserApiImpl userApiImpl) {
        return userApiImpl;
    }
}
