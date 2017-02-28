package com.dkk.rxjava.samplerxjava.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.dkk.rxjava.samplerxjava.R;
import com.dkk.rxjava.samplerxjava.ui.presenter.LoginPresenter;
import com.dkk.rxjava.samplerxjava.ui.view.LoginView;
import com.dkk.rxjava.samplerxjava.ui.view.MainActivityView;
import com.dkk.rxjava.samplerxjava.utils.UIUtils;

/**
 * Created by deepak on 23/2/17.
 */

public class LoginFragment extends BaseFragment implements LoginView{

    private LoginPresenter loginPresenter;
    private EditText editTextUserName;
    private EditText editTextPassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_layout,container,false);
        loginPresenter = new LoginPresenter(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    private void initView(View view) {
        TextView txtLogin = (TextView) view.findViewById(R.id.txt_submit);
        txtLogin.setText("Login");
        txtLogin.setOnClickListener(mOnClickListener);

        editTextUserName = (EditText) view.findViewById(R.id.edit_txt_user_name);
        editTextPassword = (EditText) view.findViewById(R.id.edit_txt_password);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.txt_submit :
                    handleTextSubmit();
                    break;
            }
        }
    };

    private void handleTextSubmit() {
        String userName = editTextUserName.getText().toString();
        String password = editTextPassword.getText().toString();
        loginPresenter.login(userName,password);
    }

    @Override
    public void showProgress() {
        UIUtils.showProgress(getActivity());
    }

    @Override
    public void hideProgress() {
        UIUtils.hideProgress();
    }

    @Override
    public void errorInUserName() {

    }

    @Override
    public void errorInPassword() {

    }

    @Override
    public void loginSuccess() {

        if(getActivity() instanceof MainActivityView) {
            ((MainActivityView)getActivity()).loadHomeFragment(new Bundle(),false);
        }
    }

    @Override
    public void loginError() {

    }
}
