package com.victormartin.projectcawd.data.di;

import com.victormartin.projectcawd.data.UserDataRepository;
import com.victormartin.projectcawd.domain.repository.UserRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {

    @Provides
    UserRepository provideUserRepository(UserDataRepository userDataRepository){
        return userDataRepository;
    }
}
