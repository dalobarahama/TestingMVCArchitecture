package com.example.testingmvcarchitecture.common.dependencyinjection;

import android.app.Activity;
import android.view.LayoutInflater;

import com.example.testingmvcarchitecture.network.ApiService;

public class ControllerCompositionRoot {

    private final CompositionRoot compositionRoot;
    private final Activity activity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, Activity activity) {
        this.compositionRoot = compositionRoot;
        this.activity = activity;
    }

    public ApiService getNewsApiService() {
        return compositionRoot.getNewsApiService();
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(activity);
    }
}
