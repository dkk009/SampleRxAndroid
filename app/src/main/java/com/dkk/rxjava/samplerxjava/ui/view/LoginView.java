package com.dkk.rxjava.samplerxjava.ui.view;

/**
 * Created by deepak on 24/2/17.
 * Login view
 */

public interface LoginView extends BaseView{
    /**
     * show error in userName
     */
    void errorInUserName();

    /**
     * show error in password.
     */
    void errorInPassword();

    /**
     * Call back when login success
     */
    void loginSuccess();

    /**
     * Call back when login failed.
     */
    void loginError();
}
