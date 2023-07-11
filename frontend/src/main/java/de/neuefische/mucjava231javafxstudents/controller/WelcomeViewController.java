package de.neuefische.mucjava231javafxstudents.controller;

import de.neuefische.mucjava231javafxstudents.service.SceneSwitchService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class WelcomeViewController {

    private final SceneSwitchService sceneSwitchService = SceneSwitchService.getInstance();

    @FXML
    public void switchToRegistrationView(ActionEvent event) throws IOException {
        sceneSwitchService.switchToCreateNewStudentView(event);
    }

    @FXML
    public void switchToAllStudentsView(ActionEvent event) throws IOException {
        sceneSwitchService.switchToListAllStudentsView(event);
    }
}