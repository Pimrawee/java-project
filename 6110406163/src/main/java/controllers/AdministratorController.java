package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.StaffInformation;
import models.Staffs;
import services.StaffDataSource;
import services.StaffFileDataSource;

import java.io.IOException;
import java.util.ArrayList;

public class AdministratorController {
    private Staffs staffs;
    private StaffDataSource staffDataSource;
    private ObservableList<StaffInformation> staffObservableList;

    @FXML
    TableView<StaffInformation> staffsTable;

    @FXML
    Label error;

    @FXML
    Button registerStaff;

    @FXML
    TextField nameStaff, usernameStaff, passwordStaff;

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }

    public void setStaffDataSource(StaffDataSource staffDataSource) {
        this.staffDataSource = staffDataSource;
    }

    @FXML
    public void initialize(){
        error.setOpacity(0);

//        staffObservableList = FXCollections.observableArrayList(staffs.toList());
//        staffsTable.setItems(staffObservableList);

//        TableColumn
    }

    @FXML
    public void handleToRegisterStaff(Event e){
        if (staffs.checkEmpty()) {
            StaffInformation staffInformation = new StaffInformation(nameStaff.getText(), usernameStaff.getText(), passwordStaff.getText());
            staffs.addStaff(staffInformation);
            staffDataSource.setStaffsData(staffs);
            error.setText("Successful!");
        }
        else {
            if (!(staffs.checkStaff(nameStaff.getText()))) {
                StaffInformation staffInformation = new StaffInformation(nameStaff.getText(), usernameStaff.getText(), passwordStaff.getText());
                staffs.addStaff(staffInformation);
                staffDataSource.setStaffsData(staffs);
                error.setText("Successful!");
            }
            else {
                error.setText("Has the name of the central officer.");
            }
        }
        error.setOpacity(1);
    }

    @FXML
    public void handleToLogout(ActionEvent event) throws IOException {
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
