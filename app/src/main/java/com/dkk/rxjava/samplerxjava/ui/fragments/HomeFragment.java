package com.dkk.rxjava.samplerxjava.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dkk.rxjava.samplerxjava.R;
import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;
import com.dkk.rxjava.samplerxjava.ui.presenter.HomePresenter;
import com.dkk.rxjava.samplerxjava.ui.view.HomeView;
import com.dkk.rxjava.samplerxjava.utils.UIUtils;

/**
 * Created by deepak on 27/2/17.
 */

public class HomeFragment extends BaseFragment implements HomeView{

    private TextView txtWelcome;
    private HomePresenter homePresentor;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        homePresentor = new HomePresenter(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        txtWelcome = (TextView) view.findViewById(R.id.txt_welcome);
        txtWelcome.setText("");
    }

    @Override
    public void onResume() {
        super.onResume();
        homePresentor.onResume();
    }

    @Override
    public void showUserDetails(DBUser dbUser) {
        txtWelcome.setText("UserName:" + dbUser.getName());
    }

    @Override
    public void showProgress() {
        UIUtils.showProgress(getActivity());
    }

    @Override
    public void hideProgress() {
        UIUtils.hideProgress();
    }
}
