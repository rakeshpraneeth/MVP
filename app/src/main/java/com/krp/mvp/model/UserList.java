package com.krp.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rakeshpraneeth on 3/6/18.
 */

public class UserList implements Parcelable {

    private List<Users> users;

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.users);
    }

    public UserList() {
    }

    public UserList(List<Users> users){
        this.users = users;
    }

    protected UserList(Parcel in) {
        this.users = new ArrayList<Users>();
        in.readList(this.users, Users.class.getClassLoader());
    }

    public static final Parcelable.Creator<UserList> CREATOR = new Parcelable.Creator<UserList>() {
        @Override
        public UserList createFromParcel(Parcel source) {
            return new UserList(source);
        }

        @Override
        public UserList[] newArray(int size) {
            return new UserList[size];
        }
    };
}
