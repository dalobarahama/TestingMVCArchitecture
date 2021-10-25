package com.example.testingmvcarchitecture.networking;

import com.example.testingmvcarchitecture.BuildConfig;
import com.example.testingmvcarchitecture.networking.news.NewsSchema;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/v2/top-headlines?country=id&apiKey=" + BuildConfig.API_KEY)
    Call<NewsSchema> getIndonesiaNewsList();

}
