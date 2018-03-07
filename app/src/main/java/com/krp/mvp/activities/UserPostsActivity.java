package com.krp.mvp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.krp.mvp.R;

public class UserPostsActivity extends AppCompatActivity {

    public static final String USER_ID = "USER_ID";
    public static final String USER_NAME = "USER_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_posts);


    }
}
