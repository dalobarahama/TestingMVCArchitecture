package com.example.testingmvcarchitecture.screens.newslist;

import com.example.testingmvcarchitecture.screens.common.ObservableViewMvc;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;

public interface NewsListItemViewMvc extends ObservableViewMvc<NewsListItemViewMvc.Listener> {
    public interface Listener {
        void onNewsClicked(String position);
    }

    void bindNews(NewsEntity newsEntity, String position);

}
