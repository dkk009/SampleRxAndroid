package com.dkk.rxjava.samplerxjava.ui.presenter;

import com.dkk.rxjava.samplerxjava.models.ErrorModel;
import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;
import com.dkk.rxjava.samplerxjava.ui.interactor.GitHubInteractor;
import com.dkk.rxjava.samplerxjava.ui.interactor.GitHubInteractorImpl;
import com.dkk.rxjava.samplerxjava.ui.interactor.UserInteractor;
import com.dkk.rxjava.samplerxjava.ui.interactor.UserInteractorImpl;
import com.dkk.rxjava.samplerxjava.ui.view.HomeView;

/**
 * Created by deepak on 27/2/17.
 */

public class HomePresenter implements Presenter,GitHubInteractor.OnFinishedListener {

    private final HomeView homeView;
    private final UserInteractor userInteractor;
    private final GitHubInteractor gitHubInteractor;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
        this.userInteractor = new UserInteractorImpl();
        gitHubInteractor = new GitHubInteractorImpl();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {
        updateUserDetails();
    }

    private void updateUserDetails() {
        DBUser dbUser = userInteractor.getUserDetails();
        if(null != dbUser) {
            homeView.showUserDetails(dbUser);
            homeView.showProgress();
            gitHubInteractor.getStaredRepos(dbUser,this);
        }
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {
        gitHubInteractor.onCancel();
    }

    @Override
    public void onDestroy() {

    }


    @Override
    public void onSuccess(DBUser dbUser) {
        homeView.hideProgress();
    }

    @Override
    public void onFailed(ErrorModel e, DBUser user) {
        homeView.hideProgress();
    }
}
