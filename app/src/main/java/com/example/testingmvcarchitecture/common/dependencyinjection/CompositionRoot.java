package com.example.testingmvcarchitecture.common.dependencyinjection;

import com.example.testingmvcarchitecture.common.Constants;
import com.example.testingmvcarchitecture.network.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {

    private Retrofit retrofit;

    private Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public ApiService getNewsApiService() {
        return getRetrofit().create(ApiService.class);
    }
}
