package com.example.testingmvcarchitecture.UI;

import android.view.View;

import com.example.testingmvcarchitecture.network.entities.NewsEntity;

import java.util.List;

public interface NewsListViewMvc {
    public interface Listener {
        void onNewsClicked(NewsEntity newsEntity);
    }

    void registerListener(Listener listener);

    void unregisterListener(Listener listener);

    View getRootView();

    void bindNews(List<NewsEntity> newsEntities);
}
