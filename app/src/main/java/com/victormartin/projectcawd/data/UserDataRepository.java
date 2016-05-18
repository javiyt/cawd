package com.victormartin.projectcawd.data;

import com.victormartin.projectcawd.domain.model.User;
import com.victormartin.projectcawd.domain.repository.UserRepository;
import javax.inject.Inject;

public class UserDataRepository implements UserRepository {

    @Inject
    public UserDataRepository() { }

    @Override
    public boolean insert(User model) {
        return false;
    }

    @Override
    public boolean update(User model) {
        return false;
    }

    @Override
    public User get(Object id) {
        return null;
    }

    @Override
    public boolean delete(User model) {
        return false;
    }
}
