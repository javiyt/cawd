package com.victormartin.projectcawd.data.api;

import com.victormartin.projectcawd.BuildConfig;
import com.victormartin.projectcawd.data.model.LoginRequestEntity;
import com.victormartin.projectcawd.domain.model.User;
import java.io.IOException;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserApiImpl implements UserApi {

    @Inject
    public UserApiImpl() { }

    @Override
    public User loginUser(String identifier, String password) {
        Retrofit retrofitBuilder = getRetrofitBuilder();
        UserRetrofitApi userRetrofitApi = retrofitBuilder.create(UserRetrofitApi.class);

        LoginRequestEntity loginRequestEntity = new LoginRequestEntity();
        loginRequestEntity.setIdentifier(identifier);
        loginRequestEntity.setPassword(password);

        Call<User> call = userRetrofitApi.loginUser(loginRequestEntity);
        Response<User> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        User body = null;
        if (response != null) {
            body = response.body();
        }
        return body;
    }

    private Retrofit getRetrofitBuilder() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
