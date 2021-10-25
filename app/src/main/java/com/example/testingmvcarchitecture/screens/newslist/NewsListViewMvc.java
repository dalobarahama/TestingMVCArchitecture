package com.example.testingmvcarchitecture.screens.newslist;

import com.example.testingmvcarchitecture.screens.common.views.ObservableViewMvc;
import com.example.testingmvcarchitecture.news.NewsEntity;

import java.util.List;

public interface NewsListViewMvc extends ObservableViewMvc<NewsListViewMvc.Listener> {
    public interface Listener {
        void onNewsClicked(String position);
    }

    void bindNews(List<NewsEntity> newsEntities);
}
