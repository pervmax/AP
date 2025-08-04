module org.example.scrs {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.scrs to javafx.fxml;
    exports org.example.scrs;
}
