package org.example.scrs;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.example.scrs.MainApp;

public class DashboardController {
    @FXML private Label welcomeLabel;
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        welcomeLabel.setText("Welcome, " + mainApp.getStudent().getName() + "!");
    }

    @FXML
    private void goToProfile() { mainApp.initProfileScene(); }
    @FXML
    private void goToRegisterCourse() { mainApp.initRegisterCourseScene(); }
    @FXML
    private void goToViewCourses() { mainApp.initViewCoursesScene(); }
    @FXML
    private void goToPieChart() { mainApp.initPieChartScene(); }
    @FXML
    private void handleLogout() { mainApp.initLoginScene(); }
}
