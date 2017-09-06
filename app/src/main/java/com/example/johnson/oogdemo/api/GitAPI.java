package com.example.johnson.oogdemo.api;

import com.example.johnson.oogdemo.model.GitModel;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by johnson on 17-9-3.
 */

public interface GitAPI {

    @GET("users/{user}")
    public void getFeed(@Path("user") String user, Callback<GitModel> response);
}
