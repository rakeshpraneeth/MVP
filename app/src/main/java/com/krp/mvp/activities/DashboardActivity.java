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
import com.krp.mvp.interfaces.DashboardContract;
import com.krp.mvp.model.UserList;
import com.krp.mvp.model.Users;
import com.krp.mvp.presenters.DashboardPresenterImpl;

import java.util.List;

public class DashboardActivity extends AppCompatActivity implements DashboardContract.View,UsersCustomAdapter.OnUserClickListener{

    private static final String USER_LIST_KEY = "USER_LIST_KEY";
    ActivityDashboardBinding binding;
    UsersCustomAdapter usersCustomAdapter;
    DashboardContract.Presenter presenter;
    UserList userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard);

        if(savedInstanceState !=null && savedInstanceState.containsKey(USER_LIST_KEY)) {
            userList = savedInstanceState.getParcelable(USER_LIST_KEY);
             showUsersInRv(userList.getUsers());
         }else{
            presenter = new DashboardPresenterImpl(this);
            presenter.makeCallToGetData();
         }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(userList !=null){
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
        userList = new UserList(users);
        showUsersInRv(users);

    }

    private void showUsersInRv(List<Users> users){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.listOfUsersRV.setLayoutManager(layoutManager);

        binding.listOfUsersRV.setHasFixedSize(true);

        usersCustomAdapter = new UsersCustomAdapter(users,this);
        binding.listOfUsersRV.setAdapter(usersCustomAdapter);
    }

    @Override
    public void onUserClicked(Users user) {
        Intent intent = new Intent(this,UserPostsActivity.class);
        intent.putExtra(UserPostsActivity.USER_ID,user.getId());
        intent.putExtra(UserPostsActivity.USER_NAME,user.getName());
        startActivity(intent);
    }
}
