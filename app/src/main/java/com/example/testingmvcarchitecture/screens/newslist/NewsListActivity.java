package com.example.testingmvcarchitecture.screens.newslist;

import android.os.Bundle;
import android.widget.Toast;

import com.example.testingmvcarchitecture.network.ApiService;
import com.example.testingmvcarchitecture.network.NewsResponse;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;
import com.example.testingmvcarchitecture.screens.common.BaseActivity;

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
        mViewMvc.registerListener(this);

        apiService = getCompositionRoot().getNewsApiService();

        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        callRetrofit();
    }

    private void callRetrofit() {
        apiService.getIndonesiaNewsList().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
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