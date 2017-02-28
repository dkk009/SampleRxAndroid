package com.dkk.rxjava.samplerxjava.ui.activities;

import android.support.v7.app.AppCompatActivity;

import com.dkk.rxjava.samplerxjava.communicator.IntrFragmentCommunicator;
import com.dkk.rxjava.samplerxjava.ui.fragments.BaseFragment;

/**
 * Created by deepak on 23/2/17.
 */

public class BaseActivity extends AppCompatActivity implements IntrFragmentCommunicator {
    protected BaseFragment currentFragment;
    protected String fragmentTagName;

    @Override
    public void loadFragment(BaseFragment fragment, String tagName) {
        currentFragment = fragment;
        fragmentTagName  = tagName;
    }

    @Override
    public void loadFrgamentBackStack(BaseFragment fragment, String tagName) {
        currentFragment = fragment;
        fragmentTagName  = tagName;
    }
}
