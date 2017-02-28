package com.dkk.rxjava.samplerxjava.ui.view;

import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;

/**
 * Created by deepak on 27/2/17.
 */

public interface HomeView {

    void showUserDetails(DBUser dbUser);
    void showProgress();
    void hideProgress();
}
