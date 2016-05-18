package com.victormartin.projectcawd.data;

import com.victormartin.projectcawd.data.datasource.CloudUserDataSource;
import com.victormartin.projectcawd.domain.model.User;
import com.victormartin.projectcawd.domain.repository.UserRepository;
import javax.inject.Inject;

public class UserDataRepository implements UserRepository {

    CloudUserDataSource userDataSource;

    @Inject
    public UserDataRepository(CloudUserDataSource userDataSource) {
        this.userDataSource = userDataSource;
    }

    @Override
    public void insert(Callback callback, User model) { }

    @Override
    public void update(Callback callback, User model) { }

    @Override
    public void get(Callback callback, Object id) {
        try {
            User user = userDataSource.getUser();
            callback.onSuccess(user);
        } catch (Exception e) {
            callback.onError();
        }
    }

    @Override
    public void delete(Callback callback, User model) { }
}
