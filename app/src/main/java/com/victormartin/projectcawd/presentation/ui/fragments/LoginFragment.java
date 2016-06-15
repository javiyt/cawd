package com.victormartin.projectcawd.presentation.ui.fragments;

import android.app.Fragment;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import com.victormartin.projectcawd.common.Config;
import com.victormartin.projectcawd.domain.model.User;
import com.victormartin.projectcawd.presentation.presenters.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginFragment extends Fragment implements MainPresenter.View {

    String str_identififer, str_password;

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

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showErrorInvalidEmail() {
        //TODO: TOUCH THE VIEW
    }

    @Override
    public void showErrorInvalidPassword() {

    }

    @Override
    public void enableIdentifier() {
        login_email.setEnabled(true);
        //login_email.setText("");
    }

    @Override
    public void disableIdentifier() {
        login_email.setEnabled(false);
    }

    @Override
    public void enablePassword() {
        login_password.setEnabled(true);
        login_password.setText("");
    }

    @Override
    public void disablePassword() {
        login_password.setText("");
        login_password.setEnabled(false);
    }

    @Override
    public void enableLoginButton() {
        btn_login.setEnabled(true);
        btn_login.getBackground().setColorFilter(null);
    }

    @Override
    public void disableLoginButton() {
        btn_login.setEnabled(false);
        btn_login.getBackground().setColorFilter(getResources().getColor(R.color.app_disable), PorterDuff.Mode.SRC_IN);
    }

    @Override
    public void loginUserAction() {
        Log.e("DATA", "" + login_email.getText().toString() +""+ login_password.getText().toString());
        presenter.loginUser(login_email.getText().toString(), login_password.getText().toString());
    }

    @Override
    public void loginButtonType(int type) {
        btn_login.getBackground().setColorFilter(null);
        btn_login.setProgress(type);
    }

    @Override
    public void authSuccessful(User user) {
        loginButtonType(Config.PROCESS_BUTTON_SUCCESS);
        new MaterialDialog.Builder(getActivity())
                .titleGravity(GravityEnum.START)
                .contentGravity(GravityEnum.CENTER)
                .buttonsGravity(GravityEnum.START)
                .title(getString(R.string.LGN_SUCCESS))
                .content(getString(R.string.LGN_SUCCESS))
                .positiveText(getString(R.string.ALERT_OK_TITLE_BUTTON_STRING))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        login_password.setText("");
                        loginButtonType(Config.PROCESS_BUTTON_NORMAL);
                        dialog.dismiss();
                    }
                })
                .show();
    }

    @Override
    public void authError() {
        loginButtonType(Config.PROCESS_BUTTON_ERROR);
        new MaterialDialog.Builder(getActivity())
                .titleGravity(GravityEnum.START)
                .contentGravity(GravityEnum.CENTER)
                .buttonsGravity(GravityEnum.START)
                .title(getString(R.string.ALERT_CREDENCIALES_INCORRECTAS_TITLE_STRING))
                .content(getString(R.string.ALERT_CREDENCIALES_INCORRECTAS_CONTENT_STRING))
                .positiveText(getString(R.string.ALERT_OK_TITLE_BUTTON_STRING))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        //login_password.setText("");
                        loginButtonType(Config.PROCESS_BUTTON_NORMAL);
                        dialog.dismiss();

                    }
                })
                .show();
    }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }




    public void initialize_views(){

        disableLoginButton();

        login_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.validateEmail(s.toString());
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
                presenter.validatePassword(s.toString());
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButtonType(Config.PROCESS_BUTTON_PROGRESS);
                presenter.validateCredentials(login_email.getText().toString(), login_password.getText().toString());
            }
        });
    }

}
