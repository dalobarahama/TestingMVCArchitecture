package com.example.testingmvcarchitecture.screens.newsdetails;

import com.example.testingmvcarchitecture.network.entities.NewsEntity;
import com.example.testingmvcarchitecture.screens.common.ViewMvc;

public interface NewsDetailsViewMvc extends ViewMvc {

    void bindNews(NewsEntity newsEntity);

    void showProgressIndicator();

    void hideProgressIndicator();
}
