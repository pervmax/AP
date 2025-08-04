package org.example.scrs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage stage;
    private Scene loginScene, dashboardScene, profileScene, registerScene, viewCoursesScene, pieChartScene;
    private StudentDataStore dataStore = new StudentDataStore();
    private Student student;

    public Student getStudent() {
        return student;
    }

    public StudentDataStore getDataStore() {
        return dataStore;
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            this.stage = primaryStage;
            this.student = dataStore.loadStudent(); // Assuming this returns a dummy or null for now
            initLoginScene(); // First scene to show
            stage.setTitle("Student Course Registration System");
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initLoginScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/scrs/view/LoginView.fxml"));
            Parent root = loader.load();
            LoginController ctrl = loader.getController();
            ctrl.setMainApp(this);
            loginScene = new Scene(root, 800, 600);
            loginScene.getStylesheets().add(getClass().getResource("/org/example/scrs/styles/application.css").toExternalForm());
            stage.setScene(loginScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initDashboardScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/scrs/view/DashboardView.fxml"));
            Parent root = loader.load();
            DashboardController ctrl = loader.getController();
            ctrl.setMainApp(this);
            dashboardScene = new Scene(root, 800, 600);
            dashboardScene.getStylesheets().add(getClass().getResource("/org/example/scrs/styles/application.css").toExternalForm());
            stage.setScene(dashboardScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initProfileScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/scrs/view/ProfileView.fxml"));
            Parent root = loader.load();
            ProfileController ctrl = loader.getController();
            ctrl.setMainApp(this);
            profileScene = new Scene(root, 800, 600);
            profileScene.getStylesheets().add(getClass().getResource("/org/example/scrs/styles/application.css").toExternalForm());
            stage.setScene(profileScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initRegisterCourseScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/scrs/view/RegisterCourseView.fxml"));
            Parent root = loader.load();
            RegisterCourseController ctrl = loader.getController();
            ctrl.setMainApp(this);
            registerScene = new Scene(root, 800, 600);
            registerScene.getStylesheets().add(getClass().getResource("/org/example/scrs/styles/application.css").toExternalForm());
            stage.setScene(registerScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initViewCoursesScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/scrs/view/ViewCoursesView.fxml"));
            Parent root = loader.load();
            ViewCoursesController ctrl = loader.getController();
            ctrl.setMainApp(this);
            viewCoursesScene = new Scene(root, 800, 600);
            viewCoursesScene.getStylesheets().add(getClass().getResource("/org/example/scrs/styles/application.css").toExternalForm());
            stage.setScene(viewCoursesScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initPieChartScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/scrs/view/PieChartView.fxml"));
            Parent root = loader.load();
            PieChartController ctrl = loader.getController();
            ctrl.setMainApp(this);
            pieChartScene = new Scene(root, 800, 600);
            pieChartScene.getStylesheets().add(getClass().getResource("/org/example/scrs/styles/application.css").toExternalForm());
            stage.setScene(pieChartScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
