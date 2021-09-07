package com.example.testingmvcarchitecture.UI;

import android.view.View;

import com.example.testingmvcarchitecture.network.entities.NewsEntity;

public interface NewsListItemViewMvc {
    public interface Listener {
        void onNewsClicked(NewsEntity newsEntity);
    }

    View getRootView();

    void registerListener(Listener listener);

    void unregisterListener(Listener listener);

    void bindNews(NewsEntity newsEntity);

}
