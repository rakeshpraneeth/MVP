package com.krp.mvp.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.krp.mvp.R;
import com.krp.mvp.adapters.UsersCustomAdapter;
import com.krp.mvp.databinding.ActivityMainBinding;
import com.krp.mvp.interfaces.MainActivityContract;
import com.krp.mvp.model.Users;
import com.krp.mvp.presenters.MainActivityPresenterImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    ActivityMainBinding binding;
    UsersCustomAdapter usersCustomAdapter;
    MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

         presenter = new MainActivityPresenterImpl(this);
         presenter.makeCallToGetData();
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
    public void showUsers(List<Users> usersList) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.listOfUsersLV.setLayoutManager(layoutManager);

        binding.listOfUsersLV.setHasFixedSize(true);

        usersCustomAdapter = new UsersCustomAdapter(usersList);
        binding.listOfUsersLV.setAdapter(usersCustomAdapter);
    }
}
