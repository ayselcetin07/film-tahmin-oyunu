module com.example.filmoyunu2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;


    opens com.example.filmoyunu2 to javafx.fxml;
    exports com.example.filmoyunu2;
}