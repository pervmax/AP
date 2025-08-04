package org.example.scrs;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.scrs.MainApp;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.SelectionMode;

public class RegisterCourseController {
    @FXML private ListView<String> courseListView;
    @FXML private Label msgLabel;
    private MainApp mainApp;
    private final String[] availableCourses = {"Java", "DBMS", "Python", "Web Dev", "Networking"};

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        courseListView.setItems(FXCollections.observableArrayList(availableCourses));

        // Enable multiple selection
        courseListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        msgLabel.setText("");
    }

    @FXML
    private void registerCourses() {
        List<String> selected = courseListView.getSelectionModel().getSelectedItems();

        if (selected.isEmpty()) {
            msgLabel.setText("⚠️ Please select at least one course to register.");
            msgLabel.setStyle("-fx-text-fill: #e74c3c;");
            return;
        }

        int added = 0;
        int alreadyRegistered = 0;
        StringBuilder registeredCourses = new StringBuilder();
        StringBuilder alreadyRegisteredCourses = new StringBuilder();

        // Create a copy of the selected items to avoid modification issues
        List<String> selectedCopy = new ArrayList<>(selected);

        for (String c : selectedCopy) {
            if (!mainApp.getStudent().getRegisteredCourses().contains(c)) {
                mainApp.getStudent().getRegisteredCourses().add(c);
                added++;
                if (registeredCourses.length() > 0) {
                    registeredCourses.append(", ");
                }
                registeredCourses.append(c);
            } else {
                alreadyRegistered++;
                if (alreadyRegisteredCourses.length() > 0) {
                    alreadyRegisteredCourses.append(", ");
                }
                alreadyRegisteredCourses.append(c);
            }
        }

        mainApp.getDataStore().saveStudent(mainApp.getStudent());

        if (added > 0 && alreadyRegistered > 0) {
            msgLabel.setText("✅ Registered: " + registeredCourses.toString() +
                    "\nℹ️ Already registered: " + alreadyRegisteredCourses.toString());
            msgLabel.setStyle("-fx-text-fill: #27ae60;");
        } else if (added > 0) {
            msgLabel.setText("✅ Successfully registered for: " + registeredCourses.toString());
            msgLabel.setStyle("-fx-text-fill: #27ae60;");
        } else {
            msgLabel.setText("ℹ️ All selected courses are already registered: " + alreadyRegisteredCourses.toString());
            msgLabel.setStyle("-fx-text-fill: #f39c12;");
        }

        // Clear selection after processing
        courseListView.getSelectionModel().clearSelection();
    }

    @FXML
    private void goToDashboard() { mainApp.initDashboardScene(); }
}
