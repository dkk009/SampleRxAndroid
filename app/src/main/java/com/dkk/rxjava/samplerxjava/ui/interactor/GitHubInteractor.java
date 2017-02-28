package com.dkk.rxjava.samplerxjava.ui.interactor;

import com.dkk.rxjava.samplerxjava.models.ErrorModel;
import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;

/**
 * Created by deepak on 27/2/17.
 */

public interface GitHubInteractor {

    interface OnFinishedListener {
        void onSuccess(DBUser dbUser);
        void onFailed(ErrorModel e,DBUser user);
    }
    void getStaredRepos(DBUser dbUser,OnFinishedListener listener);
    void onCancel();
}
