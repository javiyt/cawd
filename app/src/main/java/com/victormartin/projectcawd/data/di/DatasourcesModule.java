package com.victormartin.projectcawd.data.di;

import com.victormartin.projectcawd.data.datasource.CloudUserDataSource;
import com.victormartin.projectcawd.data.datasource.UserDataSource;
import dagger.Module;
import dagger.Provides;

@Module
public class DatasourcesModule {

    @Provides
    UserDataSource provideUserDataSource(CloudUserDataSource cloudUserDataSource) {
        return cloudUserDataSource;
    }
}
