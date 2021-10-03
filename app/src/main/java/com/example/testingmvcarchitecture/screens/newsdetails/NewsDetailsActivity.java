package com.example.testingmvcarchitecture.screens.newsdetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.testingmvcarchitecture.network.FetchNewsDetailsUseCase;
import com.example.testingmvcarchitecture.network.entities.NewsEntity;
import com.example.testingmvcarchitecture.screens.common.BaseActivity;

public class NewsDetailsActivity extends BaseActivity implements FetchNewsDetailsUseCase.Listener {

    private static final String EXTRA_NEWS_POSITION = "EXTRA_NEWS_POSITION";

    private NewsDetailsViewMvc newsDetailsViewMvc;

    private FetchNewsDetailsUseCase fetchNewsDetailsUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchNewsDetailsUseCase = getCompositionRoot().getFetchNewsDetailsUserCase();
        newsDetailsViewMvc = getCompositionRoot().getViewMvcFactory().getNewsDetailsViewMvc(null);

        setContentView(newsDetailsViewMvc.getRootView());
    }

    public static void start(Context context, String newsPosition) {
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        intent.putExtra(EXTRA_NEWS_POSITION, newsPosition);
        context.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchNewsDetailsUseCase.registerListener(this);

        newsDetailsViewMvc.showProgressIndicator();
        fetchNewsDetailsUseCase.fetchNewsDetailsAndNotify(getNewsPosition());
    }

    @Override
    protected void onStop() {
        super.onStop();
        fetchNewsDetailsUseCase.unregisterListener(this);
    }

    private int getNewsPosition() {
        String position = getIntent().getStringExtra(EXTRA_NEWS_POSITION);
        return Integer.parseInt(position);
    }

    private void bindNewsDetails(NewsEntity newsEntity) {
        newsDetailsViewMvc.hideProgressIndicator();
        newsDetailsViewMvc.bindNews(newsEntity);
    }

    @Override
    public void onNewsDetailsFetched(NewsEntity newsEntity) {
        bindNewsDetails(newsEntity);
    }

    @Override
    public void onNewsDetailsFetchFailed() {
        newsDetailsViewMvc.hideProgressIndicator();
        Toast.makeText(this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
    }
}