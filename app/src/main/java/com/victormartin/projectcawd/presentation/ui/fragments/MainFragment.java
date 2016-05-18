package com.victormartin.projectcawd.presentation.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.victormartin.projectcawd.R;
import com.victormartin.projectcawd.base.di.HasComponent;
import com.victormartin.projectcawd.base.di.component.UserComponent;
import com.victormartin.projectcawd.presentation.presenters.MainPresenter;
import javax.inject.Inject;
import butterknife.ButterKnife;

public class MainFragment extends Fragment implements MainPresenter.View {

    @Inject
    MainPresenter presenter;

    public MainFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(UserComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
        presenter.resume();
    }

    /**
     * MainPresenter.View  implementation
     */

    @Override
    public void showProgress() { }

    @Override
    public void hideProgress() { }

    @Override
    public void showError(String message) { }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
