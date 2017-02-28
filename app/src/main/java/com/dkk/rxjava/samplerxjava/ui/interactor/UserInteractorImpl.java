package com.dkk.rxjava.samplerxjava.ui.interactor;

import com.dkk.rxjava.samplerxjava.manager.DBManager;
import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;

/**
 * Created by deepak on 27/2/17.
 */

public class UserInteractorImpl implements UserInteractor {

    @Override
    public DBUser getUserDetails() {
        DBUser dbUser = (DBUser) DBManager.getRealmObject(DBUser.class);
        return dbUser;
    }

    @Override
    public void updateUserDetails(DBUser dbUser) {

    }

    @Override
    public void updateUserName(String name) {

    }

    @Override
    public void getNewUserDetails(String userName, UserDetailsFinishedListener listener) {

    }
}
