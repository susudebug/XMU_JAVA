module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.demo to javafx.fxml;

    exports com.s3;
    requires javafx.graphics;
    opens com.s4 to javafx.graphics;

}
