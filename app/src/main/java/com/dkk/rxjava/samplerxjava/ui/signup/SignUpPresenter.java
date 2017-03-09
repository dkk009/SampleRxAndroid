package com.dkk.rxjava.samplerxjava.ui.signup;

import android.support.annotation.NonNull;

import com.dkk.rxjava.samplerxjava.models.ErrorModel;
import com.dkk.rxjava.samplerxjava.models.User;
import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;
import com.dkk.rxjava.samplerxjava.ui.presenter.Presenter;

/**
 * Created by deepak on 8/3/17.
 *
 * Sign up presenter
 */

public class SignUpPresenter implements Presenter, SignUpInteractor.OnFinishedListener{

    private final SignUpView signUpView;
    private final SignUpInteractor signUpInteractor;

    public SignUpPresenter(SignUpView signUpView) {
        this.signUpView = signUpView;
        signUpInteractor = new SignUpInteractorImpl();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    /**
     * This method will handle user sign-up action. Method will verify all inputs data,
     * if its valid it will proceed sign-up api, otherwise it will throw respective error.
     * @param firstName - user first name
     * @param secondName - user second name
     * @param email - user email
     * @param password - user password
     */
    public void handleSignUp(@NonNull String firstName, String secondName, @NonNull String email, @NonNull String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setEmail(email);
        user.setPassword(password);
        boolean status = validateUserData(user);
    }

    private boolean validateUserData(User user) {
        return false;
    }

    @Override
    public void signUpSuccess(DBUser user) {

    }

    @Override
    public void signUpFailed(ErrorModel errorModel) {

    }
}
