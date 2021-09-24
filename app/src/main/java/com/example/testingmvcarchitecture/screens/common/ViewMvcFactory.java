package com.example.testingmvcarchitecture.screens.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.testingmvcarchitecture.screens.newslist.NewsListItemViewMvc;
import com.example.testingmvcarchitecture.screens.newslist.NewsListItemViewMvcImpl;
import com.example.testingmvcarchitecture.screens.newslist.NewsListViewMvc;
import com.example.testingmvcarchitecture.screens.newslist.NewsListViewMvcImpl;

public class ViewMvcFactory {

    private final LayoutInflater layoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public NewsListViewMvc getNewsListViewMvc(@Nullable ViewGroup parent) {
        return new NewsListViewMvcImpl(layoutInflater, parent, this);
    }

    public NewsListItemViewMvc getNewsListItemViewMvc(@Nullable ViewGroup parent) {
        return new NewsListItemViewMvcImpl(layoutInflater, parent);
    }
}
