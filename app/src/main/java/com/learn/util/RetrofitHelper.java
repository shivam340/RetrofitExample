package com.learn.util;

import android.content.Context;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.util.Date;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by shivam on 12/9/15.
 */
public class RetrofitHelper {

    public static final String BASE_URL_FOR_DEBUG = "http://apidev.netsurfnetwork.com/Service1.svc";

    private static final String TAG = RetrofitHelper.class.getName();
    private static ApiService apiService;
    
    public static ApiService getApiClient() {

            if (apiService == null) {

                Retrofit builder = new Retrofit.Builder()
                        .baseUrl(BASE_URL_FOR_DEBUG)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                apiService = builder.create(ApiService.class);
            }
            return apiService;

    }
    
    
    
}
