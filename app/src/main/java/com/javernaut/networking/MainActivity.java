package com.javernaut.networking;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.javernaut.networking.adapter.GithubersAdapter;
import com.javernaut.networking.model.Githuber;
import com.javernaut.networking.networking.okhttp.NetworkingWithOkHttp;
import com.javernaut.networking.networking.retrofit.NetworkingWithRetrofit;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Starting the background task
        new InternetRequestTask().execute();
    }

    @MainThread
    private void applyGithubers(List<Githuber> githubers) {
        recyclerView.setAdapter(new GithubersAdapter(githubers));
    }

    @WorkerThread
    private List<Githuber> executeRequest() {
//        return Collections.emptyList();
//        return NetworkingWithOkHttp.makeRequest();
        return NetworkingWithRetrofit.makeRequest();
    }

    // The class for a background task
    private class InternetRequestTask extends AsyncTask<Void, Void, List<Githuber>> {

        // Method will be called in background thread
        @Override
        protected List<Githuber> doInBackground(Void... voids) {
            return executeRequest();
        }

        // Method will be called in main thread after the doInBackground() has finished
        @Override
        protected void onPostExecute(List<Githuber> githubers) {
            applyGithubers(githubers);
        }
    }
}
