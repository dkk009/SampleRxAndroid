package com.dkk.rxjava.samplerxjava.ui.activities;

import android.os.Bundle;

import com.dkk.rxjava.samplerxjava.R;
import com.dkk.rxjava.samplerxjava.manager.DBManager;
import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;
import com.dkk.rxjava.samplerxjava.ui.fragments.BaseFragment;
import com.dkk.rxjava.samplerxjava.ui.fragments.HomeFragment;
import com.dkk.rxjava.samplerxjava.ui.fragments.LoginFragment;
import com.dkk.rxjava.samplerxjava.ui.view.MainActivityView;



public class MainActivity extends BaseActivity implements MainActivityView{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        DBUser dbUser = (DBUser) DBManager.getRealmObject(DBUser.class);
        if(null != dbUser) {
            loadHomeFragment(new Bundle(),false);
        }else {
            loadLoginFragment(new Bundle(),false);
        }
    }

    @Override
    public void loadFragment(BaseFragment fragment, String tagName) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_container,fragment,tagName)
                .commit();
        super.loadFragment(fragment, tagName);
    }

    @Override
    public void loadFrgamentBackStack(BaseFragment fragment, String tagName) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_container,fragment,tagName)
                .addToBackStack(null).commit();
        super.loadFrgamentBackStack(fragment, tagName);

    }

    @Override
    public void loadLoginFragment(Bundle bundle,boolean isBackStack) {
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setArguments(bundle);
        if(isBackStack) {
            loadFrgamentBackStack(loginFragment, LoginFragment.class.getSimpleName());
        }else {
            loadFragment(loginFragment, LoginFragment.class.getSimpleName());
        }
    }

    @Override
    public void loadHomeFragment(Bundle bundle,boolean isBackStack) {
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle);
        if(isBackStack) {
            loadFrgamentBackStack(homeFragment,HomeFragment.class.getSimpleName());
        }else {
            loadFragment(homeFragment,HomeFragment.class.getSimpleName());
        }

    }
}
