package com.dkk.rxjava.samplerxjava.ui.interactor;

import com.dkk.rxjava.samplerxjava.models.User;

/**
 * Created by deepak on 23/2/17.
 */

public interface LoginInteractor {

    interface LoginFinishedListener {
        void loginSuccess();
        void errorInUserName();
        void errorInPassword();
        void error();
    }
    void login(User user,LoginFinishedListener loginFinishedListener);
}
