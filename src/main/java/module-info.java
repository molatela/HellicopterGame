module com.example.hellicoptergame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hellicoptergame to javafx.fxml;
    exports com.example.hellicoptergame;
}