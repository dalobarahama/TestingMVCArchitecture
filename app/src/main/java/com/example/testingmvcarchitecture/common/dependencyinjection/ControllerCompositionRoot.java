package com.example.testingmvcarchitecture.common.dependencyinjection;

import android.app.Activity;
import android.view.LayoutInflater;

import com.example.testingmvcarchitecture.network.ApiService;
import com.example.testingmvcarchitecture.network.FetchNewsDetailsUseCase;
import com.example.testingmvcarchitecture.screens.common.ViewMvcFactory;

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

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }

    public FetchNewsDetailsUseCase getFetchNewsDetailsUserCase() {
        return new FetchNewsDetailsUseCase(getNewsApiService());
    }
}
