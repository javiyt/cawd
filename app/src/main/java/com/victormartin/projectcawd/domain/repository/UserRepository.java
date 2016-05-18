package com.victormartin.projectcawd.domain.repository;

import com.victormartin.projectcawd.domain.model.User;

/**
 * A user repository with CRUD operations on a model.
 */
public interface UserRepository {

    boolean insert(User model);

    boolean update(User model);

    User get(Object id);

    boolean delete(User model);
}
