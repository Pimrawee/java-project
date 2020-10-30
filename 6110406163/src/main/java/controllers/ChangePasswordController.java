package controllers;

import javafx.application.Platform;
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

import java.io.IOException;

public class ChangePasswordController {
    private Staffs staffs;
    private StaffDataSource staffDataSource;

    @FXML
    TextField username;

    @FXML
    PasswordField newPassword, confirmNewPassword;

    @FXML
    Label error;

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
    public void handleToConfirmNewPassword(ActionEvent event) {
        if (username.getText().equals("") || newPassword.getText().equals("") || confirmNewPassword.getText().equals("")){
            error.setText("Incorrect information");
        }
        else {
            if (newPassword.getText().equals(confirmNewPassword.getText())){
                if (staffs.checkUsernameStaff(username.getText())){
                    staffs.setNewPassword(username.getText(), newPassword.getText());
                    staffDataSource.setStaffsData(staffs);
                    error.setText("Password changed successfully.");
                }
                else {
                    error.setText("Incorrect information");
                }
            }
            else {
                error.setText("Incorrect information");
            }
        }
        username.clear();
        newPassword.clear();
        confirmNewPassword.clear();
        error.setOpacity(1);
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
