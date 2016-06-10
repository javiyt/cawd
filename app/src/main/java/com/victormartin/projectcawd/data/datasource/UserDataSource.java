package com.victormartin.projectcawd.data.datasource;

import com.victormartin.projectcawd.domain.model.User;

public interface UserDataSource {

    User loginUser(String identifier, String password);
}


