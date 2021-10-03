package com.example.testingmvcarchitecture.screens.newslist;

import android.os.Bundle;
import android.widget.Toast;

import com.example.testingmvcarchitecture.network.ApiService;
import com.example.testingmvcarchitecture.network.NewsResponse;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;
import com.example.testingmvcarchitecture.screens.common.BaseActivity;
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
        apiService.getIndonesiaNewsList().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    bindNews(response.body().getNewsEntities());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
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