package com.example.testingmvcarchitecture.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testingmvcarchitecture.R;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;

import java.util.ArrayList;
import java.util.List;

public class NewsListItemViewMvcImpl implements NewsListItemViewMvc {

    private final View rootView;
    private final List<Listener> listeners = new ArrayList<>(1);

    private NewsEntity newsEntity;
    private final TextView txtTitle;

    public NewsListItemViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        rootView = inflater.inflate(R.layout.news_item, parent, false);
        txtTitle = findViewById(R.id.news_title);
        getRootView().setOnClickListener(v -> {
            for (Listener listener : listeners) {
                listener.onNewsClicked(newsEntity);
            }
        });
    }

    private <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public void registerListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void unregisterListener(Listener listener) {
        listeners.remove(listener);
    }

    @Override
    public void bindNews(NewsEntity newsEntity) {
        this.newsEntity = newsEntity;
        txtTitle.setText(newsEntity.getTitle());
    }
}
