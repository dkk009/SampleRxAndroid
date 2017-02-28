package com.dkk.rxjava.samplerxjava.ui.interactor;

import android.text.TextUtils;
import android.util.Log;

import com.dkk.rxjava.samplerxjava.models.ErrorModel;
import com.dkk.rxjava.samplerxjava.models.GitHubRepo;
import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;
import com.dkk.rxjava.samplerxjava.network.GitHubClient;
import com.dkk.rxjava.samplerxjava.network.GitHubService;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by deepak on 27/2/17.
 */

public class GitHubInteractorImpl implements GitHubInteractor {

    public static final String TAG = GitHubInteractorImpl.class.getSimpleName();
    private Subscription subscription;
    @Override
    public void getStaredRepos(final DBUser dbUser, final OnFinishedListener listener) {
        if(null != dbUser && !TextUtils.isEmpty(dbUser.getUserId())) {
           subscription =  GitHubClient.getInstance().getStarredRepos(dbUser.getUserId())
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .doOnNext(new Action1<List<GitHubRepo>>() {
                       @Override
                       public void call(List<GitHubRepo> gitHubRepos) {
                            updateDataIntoDb(gitHubRepos);
                       }
                   })
                   .subscribe(new Subscriber<List<GitHubRepo>>() {
                       @Override
                       public void onCompleted() {
                           Log.d(TAG,"onCompleted");
                           listener.onSuccess(dbUser);
                       }

                       @Override
                       public void onError(Throwable e) {
                           Log.d(TAG,"onError:" +e);
                           listener.onFailed(new ErrorModel(e),dbUser);
                       }

                       @Override
                       public void onNext(List<GitHubRepo> gitHubRepos) {
                           handleOnNext(gitHubRepos);
                       }


                   });
        }
    }

    private void handleOnNext(List<GitHubRepo> gitHubRepos) {
        Log.d(TAG,"handleOnNext");

    }

    private void updateDataIntoDb(List<GitHubRepo> gitHubRepos) {
        Log.d(TAG,"updateDataIntoDb:" + gitHubRepos.size());
    }

    @Override
    public void onCancel() {
        if(null != subscription && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
