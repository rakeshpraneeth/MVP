package com.krp.mvp.interfaces;

import com.krp.mvp.model.Post;
import com.krp.mvp.model.Users;

import java.util.List;

/**
 * Created by rakeshpraneeth on 3/6/18.
 */

public interface UserPostsContract {

    // It has to be implemented by view such as Activity, fragments
    // It contains callback methods which handles views.
    interface View{
        // Each method specifies about each view operation to be performed.
        void showProgressBar();
        void hideProgressBar();
        void showNoPostsMessage();
        void showFailedMessage();
        void showPosts(List<Post> postsList);
    }

    // It has to be implemented by the class that contains logic.
    // It contains callback methods which handles logic.
    interface Presenter{
        // Each method specifies about operation to be performed on logic side.
        List<Users> getPostsData();
        void makeCallToGetPosts(int id);
        void setUserPosts(List<Post> postsList);
    }
}
