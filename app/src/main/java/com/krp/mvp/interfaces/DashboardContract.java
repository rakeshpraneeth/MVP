package com.krp.mvp.interfaces;

import com.krp.mvp.model.Users;

import java.util.List;

/**
 * Created by rakeshpraneeth on 3/5/18.
 */

public interface DashboardContract {

    // These interfaces has to be implemented like listeners.

    // It has to be implemented by view such as Activity, fragments
    // It contains callback methods which handles views.
    interface View{
        // Each method specifies about each view operation to be performed.
        void showProgressBar();
        void hideProgressBar();
        void showNoUsersMessage();
        void showFailedMessage();
        void showUsers(List<Users> usersList);
    }

    // It has to be implemented by the class that contains logic.
    // It contains callback methods which handles logic.
    interface Presenter{
        // Each method specifies about operation to be performed on logic side.
        List<Users> getUserData();
        void makeCallToGetData();
        void setUserData(List<Users> usersList);
    }
}
