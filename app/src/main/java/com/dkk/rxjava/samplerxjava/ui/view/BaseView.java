package com.dkk.rxjava.samplerxjava.ui.view;

/**
 * Created by deepak on 8/3/17.
 *  Base view interface
 */


public interface BaseView {
    /**
     * for showing progress
     */
    void showProgress();

    /**
     * for dismissing progress
     */
    void hideProgress();

    /**
     * For showing error
     * @param title string
     * @param message string
     */
    void showError(int title,int message);
}
