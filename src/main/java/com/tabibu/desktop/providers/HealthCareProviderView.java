package com.tabibu.desktop.view;

import com.tabibu.desktop.controller.IHealthCareProviderController;
import com.tabibu.desktop.model.HealthCareProvider;
import io.reactivex.Single;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.List;


public class HealthCareProviderView extends VBox implements IHealthCareProviderView {

    private IHealthCareProviderController controller;

    public void setController(IHealthCareProviderController controller) {
        this.controller = controller;
    }

    public void loadData() {
        this.controller.getAllProviders();
    }

    @Override
    public void displayHealthCareProviders(Single<List<HealthCareProvider>> providers) {
        ListView list = new ListView();
        String result = "hi";
        providers.subscribe
                (healthCareProviders -> {
                    healthCareProviders.forEach(healthCareProvider -> {
                        list.getItems().add(healthCareProvider.getName());
                        System.out.println(healthCareProvider.getName());
                    });
                });
        this.getChildren().add(list);
    }
}