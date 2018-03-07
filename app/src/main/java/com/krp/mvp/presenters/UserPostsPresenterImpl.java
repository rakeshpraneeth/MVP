package com.krp.mvp.presenters;

import com.krp.mvp.common.BaseUrl;
import com.krp.mvp.interfaces.ApiService;
import com.krp.mvp.interfaces.UserPostsContract;
import com.krp.mvp.model.Post;
import com.krp.mvp.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rakeshpraneeth on 3/6/18.
 */

public class UserPostsPresenterImpl implements UserPostsContract.Presenter{

    UserPostsContract.View userPostsActivityView;
    ApiService apiService;

    public UserPostsPresenterImpl(UserPostsContract.View userPostsActivityView){
        this.userPostsActivityView = userPostsActivityView;
    }

    @Override
    public void makeCallToGetPosts(int id) {

        if(userPostsActivityView !=null){

            userPostsActivityView.showProgressBar();

            if(apiService == null){
                apiService = BaseUrl.getApiService();
            }

            Call<List<Post>> postsCall = apiService.getUserPosts(id);
            postsCall.enqueue(new Callback<List<Post>>() {
                @Override
                public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                    if(response.isSuccessful() && response.body().size() >0){
                        userPostsActivityView.showPosts(response.body());
                    }else{
                        userPostsActivityView.showNoPostsMessage();
                    }
                    userPostsActivityView.hideProgressBar();
                }

                @Override
                public void onFailure(Call<List<Post>> call, Throwable t) {

                    userPostsActivityView.showFailedMessage();
                    userPostsActivityView.hideProgressBar();
                }
            });
        }

    }

    @Override
    public List<Users> getPostsData() {
        return null;
    }

    @Override
    public void setUserPosts(List<Post> postsList) {

    }
}
