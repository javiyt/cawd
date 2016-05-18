package com.victormartin.projectcawd.data.di;

import com.victormartin.projectcawd.data.api.UserApi;
import com.victormartin.projectcawd.data.api.UserRetrofitApi;
import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Provides
    UserApi provideUserApi(UserRetrofitApi userRetrofitApi) {
        return userRetrofitApi;
    }
}
