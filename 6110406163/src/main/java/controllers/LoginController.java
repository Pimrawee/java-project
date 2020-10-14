package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Staffs;
import services.StaffDataSource;
import services.StaffFileDataSource;

import java.io.IOException;

public class LoginController {
    private String check;
    private Staffs staffs;
    private StaffDataSource staffDataSource;
    private String nameStaffLogin;

    @FXML
    TextField username;

    @FXML
    PasswordField password;

    @FXML
    Label error;

    public void setCheck(String check) {
        this.check = check;
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }

    public void setStaffDataSource(StaffDataSource staffDataSource) {
        this.staffDataSource = staffDataSource;
    }

    @FXML
    public void initialize(){
        error.setOpacity(0);
    }

    @FXML
    public void handleToLogin(ActionEvent event) throws IOException {
        if (check.equals("a")) {
            if (username.getText().equals("123") && password.getText().equals("123")) {
                Button b = (Button) event.getSource();
                Stage stage = (Stage) b.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/administrator.fxml"));
                stage.setScene(new Scene(loader.load(), 800, 600));
                AdministratorController administratorController = loader.getController();
                administratorController.setStaffs(staffs);
                administratorController.setStaffDataSource(staffDataSource);
                stage.show();
            }
            else {
                error.setText("Invalid Account.");
                error.setOpacity(1);
            }
        }
        else if (check.equals("s")){
            if (!staffs.checkEmpty()) {
                if (staffs.checkPinStaff(username.getText(), password.getText())) {
                    staffs.setDateTime(username.getText(), password.getText());
                    staffDataSource.setStaffsData(staffs);
                    Button b = (Button) event.getSource();
                    Stage stage = (Stage) b.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/staff.fxml"));
                    stage.setScene(new Scene(loader.load(), 800, 600));
                    StaffController staffController = loader.getController();
                    staffController.setNameStaffLogin(nameStaffLogin);
                    staffController.setStaffs(staffs);
                    staffController.setStaffDataSource(staffDataSource);
                    stage.show();
                }
                else {
                    error.setText("Invalid Account.");
                    error.setOpacity(1);
                }
            }
            else {
                error.setText("Invalid Account.");
                error.setOpacity(1);
            }
        }
    }

    @FXML
    public void handleToBack(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/welcome.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        WelcomeController welcomeController = loader.getController();
        welcomeController.setStaffs(staffs);
        welcomeController.setStaffDataSource(staffDataSource);
        stage.show();
    }
}
