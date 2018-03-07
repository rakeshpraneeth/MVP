package com.krp.mvp.interfaces;

import com.krp.mvp.model.Post;
import com.krp.mvp.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rakeshpraneeth on 3/5/18.
 * This interface is used to handle all the API calls using Retrofit.
 * It contains methods such as GET,POST,...
 * Each operation will have a method and some parameters depending on the type of operation we perform.
 */

public interface ApiService {

    @GET("/users")
    Call<List<Users>> getAllUsers();

    @GET("/posts")
    Call<List<Post>> getUserPosts(@Query("userId") int userId);
}
