package com.example.testingmvcarchitecture;

import android.app.Application;

import com.example.testingmvcarchitecture.common.dependencyinjection.CompositionRoot;

public class CustomApplication extends Application {

    private CompositionRoot compositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        compositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return compositionRoot;
    }
}
