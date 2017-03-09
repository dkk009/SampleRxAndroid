package com.dkk.rxjava.samplerxjava.ui.interactor;

import android.text.TextUtils;

import com.dkk.rxjava.samplerxjava.models.User;
import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;
import com.dkk.rxjava.samplerxjava.utils.StringUtils;

import io.realm.Realm;

/**
 * Created by deepak on 24/2/17.
 *
 * Login interactor implementation
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final User user, final LoginFinishedListener loginFinishedListener) {
        if(isValidData((user),loginFinishedListener)) {


            Realm realm = Realm.getDefaultInstance();
            if(null != realm) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        DBUser dbUser = realm.createObject(DBUser.class,user.getUserName());
                      //  dbUser.setUserId(user.getUserName());
                        dbUser.setName(user.getUserName());
                        dbUser.setLastLoginTime(System.currentTimeMillis());
                        loginFinishedListener.loginSuccess();
                    }
                });
            }
        }

    }

    private boolean isValidData(User user, LoginFinishedListener loginFinishedListener) {
        boolean status = false;
        if(null == user) {
            loginFinishedListener.error();
        }else if(StringUtils.isEmpty(user.getUserName())) {
            loginFinishedListener.errorInUserName();
        }else if(StringUtils.isEmpty(user.getPassword())) {
            loginFinishedListener.errorInPassword();
        }else if(user.getPassword().length()>1 && user.getUserName().length() >1) {
            status = true;
        }
        return status;
    }
}
