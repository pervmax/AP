package org.example.scrs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import org.example.scrs.MainApp;

public class ViewCoursesController {
    @FXML private TableView<CourseEntry> coursesTable;
    @FXML private TableColumn<CourseEntry, String> courseNameColumn;
    @FXML private TableColumn<CourseEntry, Void> deleteColumn;
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        loadCourses();
    }
    private void loadCourses() {
        ObservableList<CourseEntry> data = FXCollections.observableArrayList();
        for (String c : mainApp.getStudent().getRegisteredCourses())
            data.add(new CourseEntry(c));
        coursesTable.setItems(data);
        courseNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        // Delete Button in Table
        deleteColumn.setCellFactory(getDeleteFactory());
    }
    private Callback<TableColumn<CourseEntry, Void>, TableCell<CourseEntry, Void>> getDeleteFactory() {
        return col -> new TableCell<>() {
            private final Button delBtn = new Button("🗑️ Delete");
            {
                delBtn.getStyleClass().add("delete-button");
                delBtn.setOnAction(event -> {
                    CourseEntry entry = getTableView().getItems().get(getIndex());

                    // Add confirmation dialog
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirm Deletion");
                    alert.setHeaderText("Delete Course Registration");
                    alert.setContentText("Are you sure you want to unregister from " + entry.getName() + "?");

                    alert.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {
                            mainApp.getStudent().getRegisteredCourses().remove(entry.getName());
                            mainApp.getDataStore().saveStudent(mainApp.getStudent());
                            loadCourses();
                        }
                    });
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : delBtn);
            }
        };
    }
    public static class CourseEntry {
        private final javafx.beans.property.SimpleStringProperty name;
        public CourseEntry(String name) { this.name = new javafx.beans.property.SimpleStringProperty(name);}
        public String getName() { return name.get(); }
        public javafx.beans.property.SimpleStringProperty nameProperty() { return name; }
    }
    @FXML
    private void goToDashboard() { mainApp.initDashboardScene(); }
}
