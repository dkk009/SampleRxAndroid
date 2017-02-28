package com.dkk.rxjava.samplerxjava.communicator;

import com.dkk.rxjava.samplerxjava.ui.fragments.BaseFragment;

/**
 * Created by deepak on 23/2/17.
 */

public interface IntrFragmentCommunicator {

    void loadFragment(BaseFragment fragment,String tagName);
    void loadFrgamentBackStack(BaseFragment fragment,String tagName);
}
