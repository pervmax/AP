package org.example.scrs;

import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        MainApp mainApp = new MainApp();
        mainApp.start(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
