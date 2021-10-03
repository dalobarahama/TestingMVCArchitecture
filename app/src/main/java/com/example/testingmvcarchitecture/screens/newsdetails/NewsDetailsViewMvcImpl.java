package com.example.testingmvcarchitecture.screens.newsdetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.testingmvcarchitecture.R;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;
import com.example.testingmvcarchitecture.screens.common.BaseViewMvc;

public class NewsDetailsViewMvcImpl extends BaseViewMvc implements NewsDetailsViewMvc {

    private final TextView newsTitleTextView;
    private final TextView newsDescriptionTextView;
    private final ProgressBar progressBarIndicator;

    public NewsDetailsViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.activity_news_details, parent, false));

        newsTitleTextView = findViewById(R.id.news_title);
        newsDescriptionTextView = findViewById(R.id.news_description);
        progressBarIndicator = findViewById(R.id.progress_bar_indicator);
    }

    @Override
    public void bindNews(NewsEntity newsEntity) {
        newsTitleTextView.setText(newsEntity.getTitle());
        newsDescriptionTextView.setText(newsEntity.getDescription());
    }

    @Override
    public void showProgressIndicator() {
        progressBarIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressIndicator() {
        progressBarIndicator.setVisibility(View.INVISIBLE);
    }
}
