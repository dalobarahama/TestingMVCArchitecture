package com.example.testingmvcarchitecture.screens.newslist;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingmvcarchitecture.news.NewsEntity;
import com.example.testingmvcarchitecture.screens.common.ViewMvcFactory;
import com.example.testingmvcarchitecture.screens.newslist.newslistitem.NewsListItemViewMvc;

import java.util.ArrayList;
import java.util.List;

public class NewsListActivityAdapter extends RecyclerView.Adapter<NewsListActivityAdapter.ViewHolder> implements NewsListItemViewMvc.Listener {


    public interface Listener {
        void onNewsClicked(String position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final NewsListItemViewMvc newsListItemViewMvc;

        public ViewHolder(NewsListItemViewMvc viewMvc) {
            super(viewMvc.getRootView());
            newsListItemViewMvc = viewMvc;
        }

    }

    private final Listener listener;
    private ViewMvcFactory viewMvcFactory;
    private List<NewsEntity> newsList = new ArrayList<>();

    public NewsListActivityAdapter(Listener listener, ViewMvcFactory viewMvcFactory) {
        this.listener = listener;
        this.viewMvcFactory = viewMvcFactory;
    }

    public void bindNews(List<NewsEntity> newsEntities) {
        newsList = new ArrayList<>(newsEntities);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewsListItemViewMvc viewMvc = viewMvcFactory.getNewsListItemViewMvc(parent);
        viewMvc.registerListener(this);
        return new ViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.newsListItemViewMvc.bindNews(newsList.get(position), String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public void onNewsClicked(String position) {
        listener.onNewsClicked(position);
    }
}

