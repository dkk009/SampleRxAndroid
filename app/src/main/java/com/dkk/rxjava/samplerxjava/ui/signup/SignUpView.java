package com.dkk.rxjava.samplerxjava.ui.signup;

import com.dkk.rxjava.samplerxjava.ui.view.BaseView;

/**
 * Created by deepak on 8/3/17.
 *  Sign up view
 */


public interface SignUpView extends BaseView {

    /**
     * show error in first Name
     * @param id - error message
     */
    void errorInFirstName(int id);

    /**
     * show error in second name
     * @param id - error message
     */
    void errorInSecondName(int id);

    /**
     * show error in email
     * @param id -error message
     */
    void errorInEmail(int id);

    /**
     * show error in password
     * @param id - error message
     */
    void errorInPassword(int id);

}
