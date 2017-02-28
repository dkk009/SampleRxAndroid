package com.dkk.rxjava.samplerxjava.network;

import android.support.annotation.NonNull;

import com.dkk.rxjava.samplerxjava.models.GitHubRepo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by deepak on 23/2/17.
 */

public class GitHubClient {

    private  static GitHubClient instance;

    private GitHubService gitHubService;
    public static GitHubClient getInstance() {
        if(null == instance) {
            instance  = new GitHubClient();
        }
        return instance;
    }
    public GitHubClient() {
        final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.readTimeout(50, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(50, TimeUnit.SECONDS);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = okHttpClient.addInterceptor(loggingInterceptor).build();
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(NetWokrUrls.GITHUB_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        gitHubService = retrofit.create(GitHubService.class);
    }

    public Observable<List<GitHubRepo>> getStarredRepos(@NonNull String userName) {
        return gitHubService.getStarredRepositories(userName);
    }
}
