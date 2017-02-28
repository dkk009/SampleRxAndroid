package com.dkk.rxjava.samplerxjava.network;

import com.dkk.rxjava.samplerxjava.models.GitHubRepo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by deepak on 23/2/17.
 */

public interface GitHubService {

    @GET("users/{user}/starred")
    Observable<List<GitHubRepo>>getStarredRepositories(@Path("user")String username);
}
