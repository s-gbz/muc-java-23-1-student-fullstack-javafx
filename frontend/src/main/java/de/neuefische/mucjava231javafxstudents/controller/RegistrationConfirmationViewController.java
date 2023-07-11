package de.neuefische.mucjava231javafxstudents.controller;

import de.neuefische.mucjava231javafxstudents.model.Student;
import de.neuefische.mucjava231javafxstudents.service.SceneSwitchService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class RegistrationConfirmationViewController {

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label courseOfStudiesLabel;

    private Student selectedStudent;

    private final SceneSwitchService sceneSwitchService = SceneSwitchService.getInstance();

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;

        firstNameLabel.setText(selectedStudent.firstName());
        lastNameLabel.setText(selectedStudent.lastName());
        emailLabel.setText(selectedStudent.email());
        courseOfStudiesLabel.setText(selectedStudent.courseOfStudies());
    }

    @FXML
    public void switchToWelcomeView(ActionEvent event) throws IOException {
        sceneSwitchService.switchToWelcomeView(event);
    }

    @FXML
    public void switchToEditSelectedStudentView(ActionEvent event) throws IOException {
        sceneSwitchService.switchToEditSelectedStudentView(event, selectedStudent);
    }

    @FXML
    public void switchToAllStudentsView(ActionEvent event) throws IOException {
        sceneSwitchService.switchToListAllStudentsView(event);
    }
}
