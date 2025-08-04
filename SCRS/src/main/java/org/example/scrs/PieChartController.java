package org.example.scrs;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class PieChartController {
    @FXML private PieChart pieChart;
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        int total = 5;
        int registered = mainApp.getStudent().getRegisteredCourses().size();
        pieChart.setData(FXCollections.observableArrayList(
                new PieChart.Data("Registered", registered),
                new PieChart.Data("Not Registered", total - registered)
        ));
    }
    @FXML
    private void goToDashboard() { mainApp.initDashboardScene(); }
}
