package com.krp.mvp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.krp.mvp.R;
import com.krp.mvp.model.Post;

import java.util.List;

/**
 * Created by rakeshpraneeth on 3/6/18.
 */

public class PostsCustomAdapter extends RecyclerView.Adapter<PostsCustomAdapter.PostsViewHolder>{

    private List<Post> postsList;

    public PostsCustomAdapter(List<Post> postsList){
        this.postsList = postsList;
    }

    @Override
    public PostsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item,parent,false);
        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostsViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder{

        public TextView postTitle;
        public TextView postBody;

        public PostsViewHolder(View itemView) {
            super(itemView);

            postTitle = itemView.findViewById(R.id.title);
            postBody = itemView.findViewById(R.id.body);
        }

        public void bind(int position){
            postTitle.setText(postsList.get(position).getTitle());
            postBody.setText(postsList.get(position).getBody());

        }
    }
}
