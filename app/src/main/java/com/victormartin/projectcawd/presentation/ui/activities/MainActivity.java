package com.victormartin.projectcawd.presentation.ui.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.victormartin.projectcawd.AndroidApplication;
import com.victormartin.projectcawd.R;
import com.victormartin.projectcawd.base.di.HasComponent;
import com.victormartin.projectcawd.base.di.component.ApplicationComponent;
import com.victormartin.projectcawd.base.di.component.DaggerUserComponent;
import com.victormartin.projectcawd.base.di.component.UserComponent;
import com.victormartin.projectcawd.base.di.module.ActivityModule;
import com.victormartin.projectcawd.base.di.module.UserModule;
import com.victormartin.projectcawd.presentation.ui.fragments.MainFragment;

public class MainActivity extends AppCompatActivity implements HasComponent<UserComponent> {

    private UserComponent userComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onInitializeInjection();

        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new MainFragment());
        }
    }

    public void onInitializeInjection() {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .userModule(new UserModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public UserComponent getComponent() {
        return userComponent;
    }
}
