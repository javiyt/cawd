package com.victormartin.projectcawd.data.api;

import com.victormartin.projectcawd.data.model.LoginRequestEntity;
import com.victormartin.projectcawd.domain.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserRetrofitApi {

    @POST("auth/local")
    Call<User> loginUser(@Body LoginRequestEntity userId);
}
