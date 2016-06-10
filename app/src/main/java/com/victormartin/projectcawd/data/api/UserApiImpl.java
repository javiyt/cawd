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
import retrofit2.http.Body;
import retrofit2.http.POST;

public class UserApiImpl implements UserApi {

    private static final String BASE_URL = "www.google.com";

    //TODO: THIS COULD BE EXTRACT TO AN OUTER IFACE
    public interface UserEndpoint {
        @POST("/auth/local")
        Call<User> loginUser(@Body LoginRequestEntity userId);
    }

    @Inject
    public UserApiImpl() { }

    @Override
    public User loginUser() {
        Retrofit retrofitBuilder = getRetrofitBuilder();
        UserEndpoint userRetrofitApi = retrofitBuilder.create(UserEndpoint.class);

        LoginRequestEntity loginRequestEntity = new LoginRequestEntity();


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
