package com.dkk.rxjava.samplerxjava.ui.interactor;

import com.dkk.rxjava.samplerxjava.models.ErrorModel;
import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;

/**
 * Created by deepak on 27/2/17.
 */

public interface UserInteractor {

    interface UserDetailsFinishedListener {
        void success(DBUser dbUser);
        void failed(ErrorModel errorModel);
    }

    DBUser getUserDetails();
    void updateUserDetails(DBUser dbUser);
    void updateUserName(String name);
    void getNewUserDetails(String userName,UserDetailsFinishedListener listener);
}
