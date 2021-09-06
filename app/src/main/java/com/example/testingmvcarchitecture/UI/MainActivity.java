package com.example.testingmvcarchitecture.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingmvcarchitecture.R;
import com.example.testingmvcarchitecture.network.ApiService;
import com.example.testingmvcarchitecture.network.NewsResponse;
import com.example.testingmvcarchitecture.network.RetrofitClientInstance;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private MainActivityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progress_bar);

        callRetrofit();

    }

    private void callRetrofit() {
        ApiService apiService = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);
        Call<NewsResponse> call = apiService.getIndonesiaNewsList();
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.body() != null) {
                    progressBar.setVisibility(View.INVISIBLE);
                    generateDataList(response.body().getNewsEntities());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE); 
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void generateDataList(List<NewsEntity> newsEntities) {
        adapter = new MainActivityAdapter(newsEntities);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}