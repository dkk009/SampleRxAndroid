package com.dkk.rxjava.samplerxjava.ui.view;

/**
 * Created by deepak on 24/2/17.
 */

public interface LoginView {

    void showProgress();
    void hideProgress();
    void errorInUserName();
    void errorInPassword();
    void loginSuccess();
    void loginError();
}
