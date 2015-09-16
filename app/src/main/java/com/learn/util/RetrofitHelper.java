package com.learn.util;

import android.content.Context;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.squareup.okhttp.OkHttpClient;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;

import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by shivam on 12/9/15.
 */
public class RetrofitHelper {

    public static final String BASE_URL_FOR_DEBUG = "http://apidev.netsurfnetwork.com/Service1.svc";

    private static final String TAG = RetrofitHelper.class.getName();
    private static ApiService apiService;
    
    public static ApiService getApiClient() {

            if (apiService == null) {

                OkHttpClient okHttpClient = new OkHttpClient();
                okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);
                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                        .registerTypeAdapter(Date.class, new DateTypeAdapter())
                        .create();

                RestAdapter.Builder builder = new RestAdapter.Builder()
                        .setConverter(new GsonConverter(gson))
                        .setClient(new OkClient(okHttpClient));

                RestAdapter restAdapter;

                    builder.setEndpoint(BASE_URL_FOR_DEBUG);
                    restAdapter = builder.build();
                    restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);

               apiService = restAdapter.create(ApiService.class);
            }
            return apiService;

    }
    
    
    
}
