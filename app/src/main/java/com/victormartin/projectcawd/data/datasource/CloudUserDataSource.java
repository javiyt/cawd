package com.victormartin.projectcawd.data.datasource;

import com.victormartin.projectcawd.data.api.UserApi;
import com.victormartin.projectcawd.domain.model.User;
import javax.inject.Inject;

public class CloudUserDataSource implements UserDataSource {

    private UserApi api;

    @Inject
    public CloudUserDataSource(UserApi api) {
        this.api = api;
    }

    @Override
    public User loginUser(String identifier, String password) {
        return api.loginUser(identifier, password);
    }
}
