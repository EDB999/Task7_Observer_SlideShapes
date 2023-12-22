module com.example.task7_observer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task7_observer to javafx.fxml;
    exports com.example.task7_observer;
}