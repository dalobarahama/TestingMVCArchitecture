package com.example.testingmvcarchitecture.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testingmvcarchitecture.network.ApiService;
import com.example.testingmvcarchitecture.network.NewsResponse;
import com.example.testingmvcarchitecture.network.RetrofitClientInstance;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListActivity extends AppCompatActivity implements NewsListViewMvcImpl.Listener {

    private NewsListViewMvc mViewMvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewMvc = new NewsListViewMvcImpl(LayoutInflater.from(this), null);
        mViewMvc.registerListener(this);

        callRetrofit();

        setContentView(mViewMvc.getRootView());
    }

    private void callRetrofit() {
        ApiService apiService = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);
        Call<NewsResponse> call = apiService.getIndonesiaNewsList();
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.body() != null) {
                    mViewMvc.bindNews(response.body().getNewsEntities());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(NewsListActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onNewsClicked(NewsEntity newsEntity) {
        Toast.makeText(this, newsEntity.getAuthor(), Toast.LENGTH_SHORT).show();
    }
}