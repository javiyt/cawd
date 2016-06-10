package com.victormartin.projectcawd.domain.repository;

import com.victormartin.projectcawd.domain.model.User;

/**
 * A user repository with CRUD operations on a model.
 */
public interface UserRepository {

    void loginUser(Callback callback, String identifier, String password);

    void insert(Callback callback, User model);

    void update(Callback callback, User model);

    void delete(Callback callback, User model);

    interface Callback {
        void onSuccess(User user);
        void onError();
    }
}
