package com.krp.mvp.presenters;

import com.krp.mvp.common.BaseUrl;
import com.krp.mvp.interfaces.ApiService;
import com.krp.mvp.interfaces.DashboardContract;
import com.krp.mvp.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rakeshpraneeth on 3/5/18.
 */

public class DashboardPresenterImpl implements DashboardContract.Presenter{

    DashboardContract.View mainActivityView;
    ApiService apiService;
    private List<Users> usersList;

    public DashboardPresenterImpl(DashboardContract.View mainActivityView){
        this.mainActivityView = mainActivityView;
    }
    @Override
    public void makeCallToGetData() {

        if(mainActivityView !=null){

            // start showing the progress bar.
            mainActivityView.showProgressBar();

            if(apiService == null){
                // If the api service is not created at all, the create it.
                // It is called first time when this particular presenter is called.
                apiService = BaseUrl.getApiService();
            }

            Call<List<Users>> usersCall = apiService.getAllUsers();
            usersCall.enqueue(new Callback<List<Users>>() {
                @Override
                public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                    if(response.isSuccessful() && response.body().size()>0){
                        // If response is success and has data >0
                        // storing the response in a variable
                        usersList = response.body();

                        // calling the main activity method to show list of users.
                        mainActivityView.showUsers(usersList);

                    }else{
                        // If the no of users = zero then call the method to show no user found message .
                        mainActivityView.showNoUsersMessage();
                    }
                    // Hide the progress bar after obtaining the result.
                    mainActivityView.hideProgressBar();
                }

                @Override
                public void onFailure(Call<List<Users>> call, Throwable t) {
                    // If the network call is failed, we show the failed message label.
                    mainActivityView.showFailedMessage();

                    // Hide the progress bar after failure.
                    mainActivityView.hideProgressBar();
                }
            });

        }
    }
}
