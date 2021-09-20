package com.example.testingmvcarchitecture.screens;

import com.example.testingmvcarchitecture.common.ObservableViewMvc;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;

public interface NewsListItemViewMvc extends ObservableViewMvc<NewsListItemViewMvc.Listener> {
    public interface Listener {
        void onNewsClicked(NewsEntity newsEntity);
    }

    void bindNews(NewsEntity newsEntity);

}
