package org.example.scrs;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.scrs.MainApp;
import org.example.scrs.Student;

public class ProfileController {
    @FXML private TextField nameField, emailField, programField, semesterField;
    @FXML private Label statusLabel;
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        loadStudentDetails();
    }

    private void loadStudentDetails() {
        Student s = mainApp.getStudent();
        nameField.setText(s.getName());
        emailField.setText(s.getEmail());
        programField.setText(s.getProgram());
        semesterField.setText(s.getSemester());
        statusLabel.setText("");
    }

    @FXML
    private void saveProfile() {
        // Clear previous status
        statusLabel.setText("");

        // Validate input fields
        if (nameField.getText().trim().isEmpty()) {
            showError("⚠️ Name cannot be empty!");
            nameField.requestFocus();
            return;
        }

        String email = emailField.getText().trim();
        if (email.isEmpty()) {
            showError("⚠️ Email cannot be empty!");
            emailField.requestFocus();
            return;
        }

        if (!isValidEmail(email)) {
            showError("⚠️ Please enter a valid email address!");
            emailField.requestFocus();
            return;
        }

        if (programField.getText().trim().isEmpty()) {
            showError("⚠️ Program cannot be empty!");
            programField.requestFocus();
            return;
        }

        String semester = semesterField.getText().trim();
        if (semester.isEmpty()) {
            showError("⚠️ Semester cannot be empty!");
            semesterField.requestFocus();
            return;
        }

        if (!isValidSemester(semester)) {
            showError("⚠️ Please enter a valid semester (1-8)!");
            semesterField.requestFocus();
            return;
        }

        // Save the profile
        Student s = mainApp.getStudent();
        s.setName(nameField.getText().trim());
        s.setEmail(email);
        s.setProgram(programField.getText().trim());
        s.setSemester(semester);

        try {
            mainApp.getDataStore().saveStudent(s);
            showSuccess("✅ Profile updated successfully!");
        } catch (Exception e) {
            showError("❌ Error saving profile. Please try again.");
        }
    }

    @FXML
    private void goToDashboard() { mainApp.initDashboardScene(); }

    private void showError(String message) {
        statusLabel.setText(message);
        statusLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-weight: bold;");
    }

    private void showSuccess(String message) {
        statusLabel.setText(message);
        statusLabel.setStyle("-fx-text-fill: #27ae60; -fx-font-weight: bold;");
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".") &&
                email.indexOf("@") > 0 &&
                email.indexOf("@") < email.lastIndexOf(".");
    }

    private boolean isValidSemester(String semester) {
        try {
            int sem = Integer.parseInt(semester);
            return sem >= 1 && sem <= 8;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
