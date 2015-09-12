package com.learn.util;

import com.learn.model.LoggedInUser;
import com.learn.model.LoginRequest;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by shivam on 12/9/15.
 */
public interface ApiService {

    @POST("/Login")
    Call<LoggedInUser> login(@Body LoginRequest loginRequest);
}
