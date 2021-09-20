package com.example.testingmvcarchitecture.screens;

import com.example.testingmvcarchitecture.common.ObservableViewMvc;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;

import java.util.List;

public interface NewsListViewMvc extends ObservableViewMvc<NewsListViewMvc.Listener> {
    public interface Listener {
        void onNewsClicked(NewsEntity newsEntity);
    }

    void bindNews(List<NewsEntity> newsEntities);
}
