package com.example.testingmvcarchitecture.network;

import com.example.testingmvcarchitecture.common.BaseObservable;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchNewsDetailsUseCase extends BaseObservable<FetchNewsDetailsUseCase.Listener> {

    private final ApiService apiService;

    public FetchNewsDetailsUseCase(ApiService apiService) {
        this.apiService = apiService;
    }

    public interface Listener {

        void onNewsDetailsFetched(NewsEntity newsEntity);

        void onNewsDetailsFetchFailed();
    }

    public void fetchNewsDetailsAndNotify(int newsPosition) {
        apiService.getIndonesiaNewsList().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    notifySuccess(response.body().getNewsEntities().get(newsPosition));
                } else {
                    notifyFailure();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                notifyFailure();
            }
        });
    }

    private void notifyFailure() {
        for (Listener listener : getListeners()) {
            listener.onNewsDetailsFetchFailed();
        }
    }

    private void notifySuccess(NewsEntity newsEntity) {
        for (Listener listener : getListeners()) {
            listener.onNewsDetailsFetched(newsEntity);
        }
    }
}

