package com.example.testingmvcarchitecture.screens;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testingmvcarchitecture.R;
import com.example.testingmvcarchitecture.common.BaseObservableViewMvc;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;

public class NewsListItemViewMvcImpl extends BaseObservableViewMvc<NewsListItemViewMvc.Listener> implements NewsListItemViewMvc {

    private NewsEntity newsEntity;
    private final TextView txtTitle;

    public NewsListItemViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.news_item, parent, false));
        txtTitle = findViewById(R.id.news_title);
        getRootView().setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onNewsClicked(newsEntity);
            }
        });
    }

    @Override
    public void bindNews(NewsEntity newsEntity) {
        this.newsEntity = newsEntity;
        txtTitle.setText(newsEntity.getTitle());
    }
}
