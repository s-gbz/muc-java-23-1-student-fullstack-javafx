module de.neuefische.mucjava231javafxstudents {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    requires org.controlsfx.controls;
    requires java.net.http;

    opens de.neuefische.mucjava231javafxstudents to javafx.fxml;
    exports de.neuefische.mucjava231javafxstudents;

    opens de.neuefische.mucjava231javafxstudents.controller to javafx.fxml;
    exports de.neuefische.mucjava231javafxstudents.controller;

    opens de.neuefische.mucjava231javafxstudents.model to com.fasterxml.jackson.databind;
    exports de.neuefische.mucjava231javafxstudents.model;
}