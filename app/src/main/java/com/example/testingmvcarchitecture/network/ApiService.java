package com.example.testingmvcarchitecture.network;

import com.example.testingmvcarchitecture.BuildConfig;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/v2/top-headlines?country=id&apiKey=" + BuildConfig.API_KEY)
    Call<NewsResponse> getIndonesiaNewsList();

}
