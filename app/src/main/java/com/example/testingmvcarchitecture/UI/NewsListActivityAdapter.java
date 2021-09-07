package com.example.testingmvcarchitecture.UI;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingmvcarchitecture.network.entities.NewsEntity;

import java.util.ArrayList;
import java.util.List;

public class NewsListActivityAdapter extends RecyclerView.Adapter<NewsListActivityAdapter.ViewHolder> implements NewsListItemViewMvc.Listener {


    public interface Listener {
        void onNewsClicked(NewsEntity newsEntity);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final NewsListItemViewMvc newsListItemViewMvc;

        public ViewHolder(NewsListItemViewMvc viewMvc) {
            super(viewMvc.getRootView());
            newsListItemViewMvc = viewMvc;
        }

    }

    private final LayoutInflater inflater;

    private final Listener listener;
    private List<NewsEntity> newsList = new ArrayList<>();

    public NewsListActivityAdapter(LayoutInflater inflater, Listener listener) {
        this.inflater = inflater;
        this.listener = listener;
    }

    public void bindNews(List<NewsEntity> newsEntities) {
        newsList = new ArrayList<>(newsEntities);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewsListItemViewMvc viewMvc = new NewsListItemViewMvcImpl(inflater, parent);
        viewMvc.registerListener(this);
        return new ViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.newsListItemViewMvc.bindNews(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public void onNewsClicked(NewsEntity newsEntity) {
        listener.onNewsClicked(newsEntity);
    }
}

