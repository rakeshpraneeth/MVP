package com.krp.mvp.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.krp.mvp.R;
import com.krp.mvp.adapters.PostsCustomAdapter;
import com.krp.mvp.databinding.ActivityUserPostsBinding;
import com.krp.mvp.interfaces.UserPostsContract;
import com.krp.mvp.model.Post;
import com.krp.mvp.presenters.UserPostsPresenterImpl;

import java.util.List;

public class UserPostsActivity extends AppCompatActivity implements UserPostsContract.View{

    public static final String USER_ID = "USER_ID";
    public static final String USER_NAME = "USER_NAME";

    ActivityUserPostsBinding binding;
    PostsCustomAdapter postsCustomAdapter;

    UserPostsContract.Presenter presenter;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_user_posts);

        userId = getIntent().getIntExtra(USER_ID,-1);
        if(userId != -1) {
            presenter = new UserPostsPresenterImpl(this);
            presenter.makeCallToGetPosts(userId);
        }
    }

    @Override
    public void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showNoPostsMessage() {
        binding.noPostsMessageTv.setVisibility(View.VISIBLE);
    }

    @Override
    public void showFailedMessage() {
        binding.failedMessageTv.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPosts(List<Post> postsList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.listOfPostsRV.setLayoutManager(layoutManager);

        binding.listOfPostsRV.setHasFixedSize(true);

        postsCustomAdapter = new PostsCustomAdapter(postsList);
        binding.listOfPostsRV.setAdapter(postsCustomAdapter);


    }
}
