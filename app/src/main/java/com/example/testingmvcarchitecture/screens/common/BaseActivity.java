package com.example.testingmvcarchitecture.screens.common;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testingmvcarchitecture.CustomApplication;
import com.example.testingmvcarchitecture.common.dependencyinjection.CompositionRoot;

public class BaseActivity extends AppCompatActivity {

    protected CompositionRoot getCompositionRoot() {
        return ((CustomApplication) getApplication()).getCompositionRoot();
    }

}
