package com.example.testingmvcarchitecture.screens.newslist.newslistitem;

import com.example.testingmvcarchitecture.screens.common.views.ObservableViewMvc;
import com.example.testingmvcarchitecture.news.NewsEntity;

public interface NewsListItemViewMvc extends ObservableViewMvc<NewsListItemViewMvc.Listener> {
    public interface Listener {
        void onNewsClicked(String position);
    }

    void bindNews(NewsEntity newsEntity, String position);

}
