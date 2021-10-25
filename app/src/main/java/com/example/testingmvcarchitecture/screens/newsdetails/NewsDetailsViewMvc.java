package com.example.testingmvcarchitecture.screens.newsdetails;

import com.example.testingmvcarchitecture.news.NewsEntity;
import com.example.testingmvcarchitecture.screens.common.views.ViewMvc;

public interface NewsDetailsViewMvc extends ViewMvc {

    void bindNews(NewsEntity newsEntity);

    void showProgressIndicator();

    void hideProgressIndicator();
}
