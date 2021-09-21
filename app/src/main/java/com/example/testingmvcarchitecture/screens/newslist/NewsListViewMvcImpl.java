package com.example.testingmvcarchitecture.screens.newslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingmvcarchitecture.R;
import com.example.testingmvcarchitecture.screens.common.BaseObservableViewMvc;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;

import java.util.List;

public class NewsListViewMvcImpl extends BaseObservableViewMvc<NewsListViewMvc.Listener> implements NewsListActivityAdapter.Listener, NewsListViewMvc {

    private RecyclerView recyclerView;
    private NewsListActivityAdapter adapter;

    public NewsListViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.activity_main, parent, false));

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsListActivityAdapter(inflater, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void bindNews(List<NewsEntity> newsEntities) {
        adapter.bindNews(newsEntities);
    }

    @Override
    public void onNewsClicked(NewsEntity newsEntity) {
        for (Listener listener : getListeners()) {
            listener.onNewsClicked(newsEntity);
        }
    }
}
