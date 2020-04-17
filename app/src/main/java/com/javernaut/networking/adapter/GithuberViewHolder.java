package com.javernaut.networking.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javernaut.networking.R;
import com.javernaut.networking.model.Githuber;
import com.squareup.picasso.Picasso;

public class GithuberViewHolder extends RecyclerView.ViewHolder {

    private TextView userNameView;
    private ImageView avatarView;

    public GithuberViewHolder(@NonNull View itemView) {
        super(itemView);

        userNameView = itemView.findViewById(R.id.username_view);
        avatarView = itemView.findViewById(R.id.avatar_view);
    }

    public void bindTo(Githuber githuber) {
        userNameView.setText(githuber.getLogin());
        Picasso.get()
                .load(githuber.getAvatarUrl())
                .into(avatarView);
    }
}