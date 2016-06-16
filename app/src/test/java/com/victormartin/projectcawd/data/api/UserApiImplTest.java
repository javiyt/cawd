package com.victormartin.projectcawd.data.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;

import static org.junit.Assert.*;

/**
 * Created by victo on 16/06/2016.
 */
public class UserApiImplTest {

    @Mock
    private UserRetrofitApi mockUserRetrofitApi;

    @Captor
    private ArgumentCaptor<Callback<List<UserApiImpl>>> callbackArgumentCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class);
        mainActivity = controller.get();

        // then we need to swap the retrofit api impl. with a mock one
        // I usually store my retrofit api impl as a static singleton in class RestClient, hence:
        UserRetrofitApi.setApi(mockRetrofitApiImpl);

        controller.create();
    }

    @Test
    public void shouldFillAdapter() throws Exception {
        Mockito.verify(mockRetrofitApiImpl)
                .getYourObject(callbackAgrumentCaptor.capture());

        int objectsQuantity = 10;
        List<YourObject> list = new ArrayList<YourObject>;
        for(int i = 0; i < objectsQuantity; ++i) {
            list.add(new YourObject());
        }

        callbackArgumentCaptor.getValue().success(list, null);

        YourAdapter yourAdapter = mainActivity.getAdapter(); // obtain adapter
        // simple test check if adapter has as many items as put into response
        assertThat(yourAdapter.getItemCount(), equalTo(objectsQuantity));
    }
}