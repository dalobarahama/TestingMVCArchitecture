package com.example.testingmvcarchitecture.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingmvcarchitecture.R;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;

import java.util.ArrayList;
import java.util.List;

public class NewsListViewMvcImpl implements NewsListActivityAdapter.Listener, NewsListViewMvc {

    private RecyclerView recyclerView;
    private NewsListActivityAdapter adapter;

    private final View rootView;

    private final List<Listener> listeners = new ArrayList<>(1);

    public NewsListViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        rootView = inflater.inflate(R.layout.activity_main, parent, false);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsListActivityAdapter(inflater, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void registerListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void unregisterListener(Listener listener) {
        listeners.remove(listener);
    }

    private <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public void bindNews(List<NewsEntity> newsEntities) {
        adapter.bindNews(newsEntities);
    }

    private Context getContext() {
        return getRootView().getContext();
    }

    @Override
    public void onNewsClicked(NewsEntity newsEntity) {
        for (Listener listener : listeners) {
            listener.onNewsClicked(newsEntity);
        }
    }
}
