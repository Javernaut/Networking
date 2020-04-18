package com.javernaut.networking.networking.okhttp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javernaut.networking.model.Githuber;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkingWithOkHttp {

    public static List<Githuber> makeRequest() {

        OkHttpClient httpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/users")
                .build();

        String responseBody = null;

        try {
            Response response = httpClient.newCall(request).execute();
            responseBody = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Type type = new TypeToken<List<Githuber>>() {}.getType();
        List<Githuber> result = new Gson().fromJson(responseBody, type);

        return result;

    }

}
