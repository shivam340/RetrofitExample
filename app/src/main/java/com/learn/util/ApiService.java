package com.learn.util;

import com.learn.model.LoggedInUser;
import com.learn.model.LoginRequest;
import com.learn.model.RegionList;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by shivam on 12/9/15.
 */
public interface ApiService {

    @POST("/Login")
    public void login(@Body LoginRequest loginRequest, Callback<LoggedInUser> callback);



    @GET("/GetRegionList")
    public void getRegionList(Callback<ArrayList<RegionList>> callback);


}
