package com.victormartin.projectcawd.data.api;

import com.victormartin.projectcawd.domain.model.User;
import javax.inject.Inject;

public class UserRetrofitApi implements UserApi {

    @Inject
    public UserRetrofitApi() { }

    @Override
    public User getUser() {
        //TODO: FIRST ITERATION, THE API CALL SHOULD BE DONE HERE
        User user = new User();
        user.setEmail("jj@jj.com");
        user.setId("yomismo");
        user.setName("Juanito Jezuh");
        user.setToken("añsldjfpwoiefpo");
        return user;
    }
}
