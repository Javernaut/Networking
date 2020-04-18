package com.javernaut.networking.networking.retrofit;

import com.javernaut.networking.model.Githuber;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApi {

    @GET("/users")
    Call<List<Githuber>> getUsers();

    @GET("/users/{user}/followers")
    Call<List<Githuber>> getFollowersOf(@Path("user") String user);
}
