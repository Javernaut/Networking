package com.javernaut.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.javernaut.networking.adapter.GithubersAdapter;
import com.javernaut.networking.model.Githuber;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void applyGithubers(List<Githuber> githubers) {
        recyclerView.setAdapter(new GithubersAdapter(githubers));
    }
}
