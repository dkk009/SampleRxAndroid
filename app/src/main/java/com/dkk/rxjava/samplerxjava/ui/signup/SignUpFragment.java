package com.dkk.rxjava.samplerxjava.ui.signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.dkk.rxjava.samplerxjava.R;
import com.dkk.rxjava.samplerxjava.ui.fragments.BaseFragment;

/**
 * Created by deepak on 8/3/17.
 *
 * Sign up fragment- Using for rendering sign up screen
 */

public class SignUpFragment extends BaseFragment implements SignUpView {

    private EditText editTextFirstName;
    private EditText editTextSecondName;
    private EditText editTextEmail;
    private TextView txtSignUp;
    private SignUpPresenter signUpPresenter;
    private EditText editTextPassword;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up,container);
        signUpPresenter = new SignUpPresenter(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        editTextFirstName = (EditText) view.findViewById(R.id.txt_fisrt_name);
        editTextSecondName = (EditText) view.findViewById(R.id.txt_second_name);
        editTextEmail = (EditText) view.findViewById(R.id.txt_email);
        txtSignUp = (TextView) view.findViewById(R.id.txt_sign_up);
        editTextPassword = (EditText) view.findViewById(R.id.txt_password);
    }


    /**
     * When user click sign up button , this method will invoke
     * @param view - SignUp Button
     */
    public void signUpClick(View view) {
        String firstName = editTextFirstName.getText().toString();
        String secondName = editTextSecondName.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        signUpPresenter.handleSignUp(firstName,secondName,email,password);
    }


    @Override
    public void showError(int title, int message) {

    }

    @Override
    public void errorInFirstName(int id) {

    }

    @Override
    public void errorInSecondName(int id) {

    }

    @Override
    public void errorInEmail(int id) {

    }

    @Override
    public void errorInPassword(int id) {

    }
}
