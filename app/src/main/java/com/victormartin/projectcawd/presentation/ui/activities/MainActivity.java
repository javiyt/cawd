package com.victormartin.projectcawd.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.victormartin.projectcawd.AndroidApplication;
import com.victormartin.projectcawd.R;
import com.victormartin.projectcawd.base.di.ActivityModule;
import com.victormartin.projectcawd.base.di.ApplicationComponent;
import com.victormartin.projectcawd.base.di.DaggerActivityComponent;
import com.victormartin.projectcawd.presentation.presenters.MainPresenter.View;

public class MainActivity extends AppCompatActivity implements View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onInitializeInjection();
    }

    public void onInitializeInjection() {
        DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void showProgress() { }

    @Override
    public void hideProgress() { }

    @Override
    public void showError(String message) { }

    public ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }
}
