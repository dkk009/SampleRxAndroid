package com.dkk.rxjava.samplerxjava.ui.view;

import android.os.Bundle;

/**
 * Created by deepak on 27/2/17.
 */

public interface MainActivityView {
    void loadLoginFragment(Bundle bundle,boolean isBackStack);
    void loadHomeFragment(Bundle bundle,boolean isBackStack);
}
