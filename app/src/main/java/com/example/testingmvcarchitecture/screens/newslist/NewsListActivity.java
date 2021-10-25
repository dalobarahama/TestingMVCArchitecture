package com.example.testingmvcarchitecture.screens.newslist;

import android.os.Bundle;
import android.widget.Toast;

import com.example.testingmvcarchitecture.networking.ApiService;
import com.example.testingmvcarchitecture.networking.news.NewsSchema;
import com.example.testingmvcarchitecture.news.NewsEntity;
import com.example.testingmvcarchitecture.screens.common.controllers.BaseActivity;
import com.example.testingmvcarchitecture.screens.newsdetails.NewsDetailsActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListActivity extends BaseActivity implements NewsListViewMvcImpl.Listener {

    private ApiService apiService;

    private NewsListViewMvc mViewMvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewMvc = getCompositionRoot().getViewMvcFactory().getNewsListViewMvc(null);

        apiService = getCompositionRoot().getNewsApiService();

        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewMvc.registerListener(this);
        callRetrofit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewMvc.unregisterListener(this);
    }

    private void callRetrofit() {
        apiService.getIndonesiaNewsList().enqueue(new Callback<NewsSchema>() {
            @Override
            public void onResponse(Call<NewsSchema> call, Response<NewsSchema> response) {
                if (response.isSuccessful()) {
                    bindNews(response.body().getNewsEntities());
                }
            }

            @Override
            public void onFailure(Call<NewsSchema> call, Throwable t) {
                Toast.makeText(NewsListActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void bindNews(List<NewsEntity> newsEntities) {
        mViewMvc.bindNews(newsEntities);
    }

    @Override
    public void onNewsClicked(String position) {
        NewsDetailsActivity.start(this, position);
    }
}