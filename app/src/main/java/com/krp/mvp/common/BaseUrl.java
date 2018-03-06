package com.krp.mvp.common;

import com.krp.mvp.interfaces.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rakeshpraneeth on 3/5/18.
 * This class contains the base url for the Api.
 * It contains a method to build the Retrofit and get the APi service.
 */

public final class BaseUrl {

    private BaseUrl(){

    }

    // Base path of the API
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    // Creates a builder for Retrofit.
    private static Retrofit getBaseUrl(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    // Creates an ApiService.
    public static ApiService getApiService(){
        return BaseUrl.getBaseUrl().create(ApiService.class);
    }
}