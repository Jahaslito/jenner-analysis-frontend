package com.tabibu.desktop.report;

import java.util.HashMap;

public interface IReportView {
    void displayPieChartAnalytics(HashMap<String, Integer> reportedCases, HashMap<String, Integer> deathToll);

    void displayLineChartAnalytics(HashMap<String, HashMap<String, Integer>> reportedCases);
}
