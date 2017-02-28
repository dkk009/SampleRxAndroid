package com.dkk.rxjava.samplerxjava.utils;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by deepak on 24/2/17.
 */

public class UIUtils {

    private static ProgressDialog progressDialog;
    public static void showProgress(Activity activity) {
        if(null != activity) {
            if(null == progressDialog) {
                progressDialog = new ProgressDialog(activity);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setIndeterminate(true);
            }
            if(!progressDialog.isShowing()) {
                progressDialog.show();
            }
        }
    }

    public static void hideProgress() {
        if(null != progressDialog) {
            if(progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            progressDialog = null;
        }
    }
}
