package com.krp.mvp.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.krp.mvp.R;
import com.krp.mvp.adapters.UsersCustomAdapter;
import com.krp.mvp.databinding.ActivityDashboardBinding;
import com.krp.mvp.interfaces.MainActivityContract;
import com.krp.mvp.model.UserList;
import com.krp.mvp.model.Users;
import com.krp.mvp.presenters.MainActivityPresenterImpl;

import java.util.List;

public class DashboardActivity extends AppCompatActivity implements MainActivityContract.View,UsersCustomAdapter.OnUserClickListener{

    private static final String USER_LIST_KEY = "USER_LIST_KEY";
    ActivityDashboardBinding binding;
    UsersCustomAdapter usersCustomAdapter;
    MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard);

        presenter = new MainActivityPresenterImpl(this);

        if(savedInstanceState !=null && savedInstanceState.containsKey(USER_LIST_KEY)) {
            UserList userList =savedInstanceState.getParcelable(USER_LIST_KEY);
             showUsers(userList.getUsers());
             presenter.setUserData(userList.getUsers());
         }else{
              presenter.makeCallToGetData();
         }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(presenter !=null){
            UserList userList = new UserList();
            userList.setUsers(presenter.getUserData());
            outState.putParcelable(USER_LIST_KEY,userList);
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
    public void showNoUsersMessage() {
        binding.noUsersMessageTv.setVisibility(View.VISIBLE);
    }

    @Override
    public void showFailedMessage() {
        binding.failedMessageTv.setVisibility(View.VISIBLE);
    }

    @Override
    public void showUsers(List<Users> users) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.listOfUsersLV.setLayoutManager(layoutManager);

        binding.listOfUsersLV.setHasFixedSize(true);

        usersCustomAdapter = new UsersCustomAdapter(users,this);
        binding.listOfUsersLV.setAdapter(usersCustomAdapter);
    }

    @Override
    public void onUserClicked(int position, String name) {
        Intent intent = new Intent(this,UserPostsActivity.class);
        intent.putExtra(UserPostsActivity.USER_ID,position+1);
        intent.putExtra(UserPostsActivity.USER_NAME,name);
        startActivity(intent);
    }
}
