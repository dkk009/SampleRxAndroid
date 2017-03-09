package com.dkk.rxjava.samplerxjava.ui.signup;

import com.dkk.rxjava.samplerxjava.models.ErrorModel;
import com.dkk.rxjava.samplerxjava.models.User;
import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;

/**
 * Created by deepak on 8/3/17.
 * SignUp interactor
 */

public interface SignUpInteractor {


    /**
     * SignUp finished call back listener
     */
    interface OnFinishedListener {
        /**
         * Callback method once sign up success
         * @param user -User info
         */
        void signUpSuccess(DBUser user);

        /**
         * Call back method once sign up failed
         * @param errorModel error info
         */
        void signUpFailed(ErrorModel errorModel);
    }

    /**
     * sign up api call
     * @param user - user info
     * @param listener - call back listener
     */
    void callSignUp(User user,OnFinishedListener listener);


}
