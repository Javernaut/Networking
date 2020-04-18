package com.javernaut.networking.networking.retrofit;

import com.javernaut.networking.model.Githuber;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkingWithRetrofit {

    public static List<Githuber> makeRequest() {
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl("https://api.github.com")

                .addConverterFactory(GsonConverterFactory.create())

                .build();

        GithubApi githubApi = retrofit.create(GithubApi.class);

        Call<List<Githuber>> getUsersCall = githubApi.getUsers();

        try {

            return getUsersCall.execute().body();

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
