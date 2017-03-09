package com.dkk.rxjava.samplerxjava.ui.view;

import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;

/**
 * Created by deepak on 27/2/17.
 * Home view
 */

public interface HomeView extends BaseView{
    void showUserDetails(DBUser dbUser);
}
