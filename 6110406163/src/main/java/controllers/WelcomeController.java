package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Staffs;
import services.StaffFileDataSource;

import java.io.IOException;

public class WelcomeController {
    private Staffs staffs = new Staffs();
    private StaffFileDataSource staffFileDataSource;

    @FXML
    public void initialize(){
        staffFileDataSource = new StaffFileDataSource("data", "staffs.csv");
        staffs = staffFileDataSource.getStaffsData();
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }

    public void setStaffFileDataSource(StaffFileDataSource staffFileDataSource) {
        this.staffFileDataSource = staffFileDataSource;
    }

    @FXML
    public void handleToAdministratorLogin(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        LoginController loginController = loader.getController();
        loginController.setCheck("a");
        loginController.setStaffs(staffs);
        loginController.setStaffFileDataSource(staffFileDataSource);
        stage.show();
    }

    @FXML
    public void handleToStaffLogin(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        LoginController loginController = loader.getController();
        loginController.setCheck("s");
        loginController.setStaffs(staffs);
        loginController.setStaffFileDataSource(staffFileDataSource);
        stage.show();
    }

    @FXML
    public void handleToProfile(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/profile.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }
}
