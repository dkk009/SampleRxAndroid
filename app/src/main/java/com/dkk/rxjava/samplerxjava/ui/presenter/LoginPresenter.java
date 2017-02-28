package com.dkk.rxjava.samplerxjava.ui.presenter;

import com.dkk.rxjava.samplerxjava.models.User;
import com.dkk.rxjava.samplerxjava.ui.interactor.LoginInteractor;
import com.dkk.rxjava.samplerxjava.ui.interactor.LoginInteractorImpl;
import com.dkk.rxjava.samplerxjava.ui.view.LoginView;

/**
 * Created by deepak on 23/2/17.
 */

public class LoginPresenter implements Presenter {

    private final LoginInteractor loginInteractor;
    private User user;
    private LoginView loginView;
    private LoginPresenter() {
        loginInteractor = null;
    }
    public LoginPresenter(LoginView loginView) {
        this.loginInteractor = new LoginInteractorImpl();
        this.loginView = loginView;

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

    public void login(String userName,String passWord) {
        User user = new User();
        user.setPassword(passWord);
        user.setUserName(userName);
        loginInteractor.login(user, new LoginInteractor.LoginFinishedListener() {
            @Override
            public void loginSuccess() {
                if(null != loginView) {
                    loginView.hideProgress();
                    loginView.loginSuccess();
                }
            }

            @Override
            public void errorInUserName() {
                if(null != loginView) {
                    loginView.hideProgress();
                    loginView.errorInUserName();
                }
            }

            @Override
            public void errorInPassword() {
                if(null != loginView) {
                    loginView.hideProgress();
                    loginView.errorInPassword();
                }
            }

            @Override
            public void error() {
                if(null != loginView) {
                    loginView.hideProgress();
                    loginView.loginError();
                }
            }
        });
    }


}
