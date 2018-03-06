package com.krp.mvp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.krp.mvp.R;
import com.krp.mvp.model.Users;

import java.util.List;

/**
 * Created by rakeshpraneeth on 3/5/18.
 */

public class UsersCustomAdapter extends RecyclerView.Adapter<UsersCustomAdapter.UsersViewHolder>{

    List<Users> usersList;

    public UsersCustomAdapter(List<Users> usersList){
        this.usersList = usersList;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item,parent,false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder{

        public TextView userName;
        public TextView address;

        public UsersViewHolder(View view){
            super(view);
            userName = view.findViewById(R.id.username_title);
            address = view.findViewById(R.id.address_body);
        }

        public void bind(int positon){
            userName.setText(usersList.get(positon).getUsername());
            address.setText(usersList.get(positon).getAddress().getCompleteAddress());
        }

    }
}
