module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.example.demo to javafx.fxml;
    requires javafx.graphics;
    exports com.s5;
    opens com.s5 to javafx.graphics;
}
