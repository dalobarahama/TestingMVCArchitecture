package com.example.testingmvcarchitecture.networking.news;

import com.example.testingmvcarchitecture.news.NewsEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsSchema {

    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("articles")
    private List<NewsEntity> newsEntities;

    public NewsSchema(String status, String totalResults, List<NewsEntity> newsEntities) {
        this.status = status;
        this.totalResults = totalResults;
        this.newsEntities = newsEntities;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsEntity> getNewsEntities() {
        return newsEntities;
    }

    public void setNewsEntities(List<NewsEntity> newsEntities) {
        this.newsEntities = newsEntities;
    }
}
