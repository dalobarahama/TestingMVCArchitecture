package com.example.testingmvcarchitecture.screens.common;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testingmvcarchitecture.CustomApplication;
import com.example.testingmvcarchitecture.common.dependencyinjection.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot controllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if (controllerCompositionRoot == null) {
            controllerCompositionRoot = new ControllerCompositionRoot(
                    ((CustomApplication) getApplication()).getCompositionRoot(), this
            );
        }
        return controllerCompositionRoot;
    }

}
