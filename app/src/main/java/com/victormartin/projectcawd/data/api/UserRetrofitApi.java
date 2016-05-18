package com.victormartin.projectcawd.data.api;

import com.victormartin.projectcawd.domain.model.User;
import java.io.IOException;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class UserRetrofitApi implements UserApi {

    private static final String BASE_URL = "www.google.com";

    //TODO: THIS COULD BE EXTRACT TO AN OUTER IFACE
    public interface UserEndpoint {
        @GET("user")
        Call<User> getUser(@Query("user") String userId);
    }

    @Inject
    public UserRetrofitApi() { }

    @Override
    public User getUser() {
        Retrofit retrofitBuilder = getRetrofitBuilder();
        UserEndpoint userEndpoint = retrofitBuilder.create(UserEndpoint.class);

        Call<User> call = userEndpoint.getUser("4");
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
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
