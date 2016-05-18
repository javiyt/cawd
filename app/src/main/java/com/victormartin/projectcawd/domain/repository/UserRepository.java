package com.victormartin.projectcawd.domain.repository;

import com.victormartin.projectcawd.domain.model.User;

/**
 * A user repository with CRUD operations on a model.
 */
public interface UserRepository {

    void insert(Callback callback, User model);

    void update(Callback callback, User model);

    void get(Callback callback, Object id);

    void delete(Callback callback, User model);

    interface Callback {
        void onSuccess(User user);
        void onError();
    }
}
