package com.victormartin.projectcawd.data;

import com.victormartin.projectcawd.domain.model.User;
import com.victormartin.projectcawd.domain.repository.UserRepository;
import javax.inject.Inject;

public class UserDataRepository implements UserRepository {

    @Inject
    public UserDataRepository() { }

    @Override
    public void insert(Callback callback, User model) { }

    @Override
    public void update(Callback callback, User model) { }

    @Override
    public void get(Callback callback, Object id) {
            try {
                User user = new User();
                user.setEmail("jj@jj.com");
                user.setId("yomismo");
                user.setName("Juanito Jezuh");
                user.setToken("añsldjfpwoiefpo");
                callback.onSuccess(user);
            } catch (Exception e) {
                callback.onError();
            }
    }

    @Override
    public void delete(Callback callback, User model) { }
}
