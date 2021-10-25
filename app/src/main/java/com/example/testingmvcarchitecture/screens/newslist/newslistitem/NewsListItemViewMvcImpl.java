package com.example.testingmvcarchitecture.screens.newslist.newslistitem;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testingmvcarchitecture.R;
import com.example.testingmvcarchitecture.news.NewsEntity;
import com.example.testingmvcarchitecture.screens.common.views.BaseObservableViewMvc;

public class NewsListItemViewMvcImpl extends BaseObservableViewMvc<NewsListItemViewMvc.Listener> implements NewsListItemViewMvc {

    private final TextView txtTitle;
    private String newsPosition;

    public NewsListItemViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.news_item, parent, false));
        txtTitle = findViewById(R.id.news_title);
        getRootView().setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onNewsClicked(newsPosition);
            }
        });
    }

    @Override
    public void bindNews(NewsEntity newsEntity, String position) {
        this.newsPosition = position;
        txtTitle.setText(newsEntity.getTitle());
    }
}
