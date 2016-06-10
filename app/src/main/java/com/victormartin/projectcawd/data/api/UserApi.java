package com.victormartin.projectcawd.data.api;

import com.victormartin.projectcawd.domain.model.User;

public interface UserApi {

    User loginUser(String identifier, String password);
}
