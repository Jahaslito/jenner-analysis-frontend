package com.tabibu.desktop.diagnosis;

import com.tabibu.desktop.common.TabibuView;
import com.tabibu.desktop.util.TableBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class DiagnosisView extends TabibuView implements IDiagnosisView {

    private IDiagnosisController controller;
    private ObservableList<DiagnosisViewModel> diagnosisList = FXCollections.observableArrayList();

    public DiagnosisView() {
        initDataTable();
    }

    public void setController(IDiagnosisController controller) {
        this.controller = controller;
    }

    public void loadData() {
        this.controller.getAllDiagnosis();
    }

    @Override
    public void displayAllDiagnosis(List<DiagnosisViewModel> diagnoses) {
        diagnosisList.addAll(diagnoses);
    }

    public void initDataTable() {
        TableView diagnosisTable = TableBuilder.createTable()
                .withColumns(List.of(
                        new TableColumn("Patient Age"),
                        new TableColumn("Diagnosis Date"),
                        new TableColumn("Health Care Provider"),
                        new TableColumn("Diseases")
                )).withProperties(List.of(
                        new PropertyValueFactory<DiagnosisViewModel, Integer>("patientAge"),
                        new PropertyValueFactory<DiagnosisViewModel, String>("diagnosisDate"),
                        new PropertyValueFactory<DiagnosisViewModel, String>("healthCareProvider"),
                        new PropertyValueFactory<DiagnosisViewModel, String>("diseases")
                )).withData(diagnosisList).build();
        this.getChildren().add(diagnosisTable);
    }
}
