module com.example.ricochetrobot_botuli_niane_valery {
    requires javafx.controls;
    requires javafx.fxml;


    opens com to javafx.fxml;
    exports com;
}