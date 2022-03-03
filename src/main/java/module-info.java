module com.example.userfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.userfx to javafx.fxml;
    exports com.example.userfx;
    exports com.example.userfx.controller;
    opens com.example.userfx.controller to javafx.fxml;
}