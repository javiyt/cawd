package com.victormartin.projectcawd.presentation.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.dd.processbutton.iml.ActionProcessButton;
import com.victormartin.projectcawd.R;
import com.victormartin.projectcawd.base.di.HasComponent;
import com.victormartin.projectcawd.base.di.component.UserComponent;
import com.victormartin.projectcawd.domain.model.User;
import com.victormartin.projectcawd.presentation.presenters.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginFragment extends Fragment implements MainPresenter.View {

    @BindView(R.id.login_email)
    EditText login_email;

    @BindView(R.id.login_password)
    EditText login_password;

    @BindView(R.id.btn_login)
    ActionProcessButton btn_login;


    @Inject
    MainPresenter presenter;

    public LoginFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(UserComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, fragmentView);
        initialize_views();

        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
        presenter.initialize();

        btn_login.setMode(ActionProcessButton.Mode.ENDLESS);
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.resume();
    }

    /**
     * UI methods
     */


    /**
     * MainPresenter.View  implementation
     */

    @Override
    public void showProgress() {
        btn_login.setProgress(1);
    }

    @Override
    public void hideProgress() {
        btn_login.setProgress(1);
    }

    @Override
    public void showError(String message) { }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

    @Override
    public void authError() {
        new MaterialDialog.Builder(getActivity())
                .titleGravity(GravityEnum.CENTER)
                .contentGravity(GravityEnum.CENTER)
                .buttonsGravity(GravityEnum.END)
                .title(getString(R.string.ALERT_CREDENCIALES_INCORRECTAS_TITLE_STRING))
                .content(getString(R.string.ALERT_CREDENCIALES_INCORRECTAS_CONTENT_STRING))
                .positiveText(getString(R.string.ALERT_OK_TITLE_BUTTON_STRING))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        login_password.setText("");
                        dialog.dismiss();
                    }
                })
                .show();
    }

    @Override
    public void showErrorInvalidEmail() {
        //TODO: TOUCH THE VIEW
    }

    @Override
    public void showErrorInvalidPassword() {

    }

    @Override
    public void enablePassword() {

    }


    @Override
    public void enableLoginButton() {
        btn_login.setEnabled(true);
    }

    @Override
    public void disableLoginButton() {
        btn_login.setEnabled(false);
    }

    @Override
    public void authSuccessful(User user) {
        new MaterialDialog.Builder(getActivity())
                .titleGravity(GravityEnum.CENTER)
                .contentGravity(GravityEnum.CENTER)
                .buttonsGravity(GravityEnum.END)
                .title(getString(R.string.ALERT_CREDENCIALES_INCORRECTAS_TITLE_STRING))
                .content("" + user.getId() + "\n" + user.getEmail() + "\n" + user.getName() + "\n" + user.getToken())
                .positiveText(getString(R.string.DETALLE_TITLE_STRING))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }


    public void initialize_views(){

        login_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.validateEmail();
            }
        });

        login_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.validateCredentials();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_email.setEnabled(false);
                login_password.setEnabled(false);
                presenter.loginUser(login_email.getText().toString(), login_password.getText().toString());
            }
        });
    }
}
