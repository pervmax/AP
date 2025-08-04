package org.example.scrs;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.scrs.MainApp;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) { this.mainApp = mainApp; }

    @FXML
    private void handleLogin() {
        String user = usernameField.getText(), pass = passwordField.getText();
        if ("student".equals(user) && "1234".equals(pass)) {
            messageLabel.setText("");
            mainApp.initDashboardScene();
        } else {
            messageLabel.setText("Invalid credentials!");
        }
    }
}
