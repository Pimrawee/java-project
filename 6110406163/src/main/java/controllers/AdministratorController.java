package controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.StaffInformation;
import models.Staffs;
import services.StaffDataSource;

import java.io.IOException;

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
    TextField nameStaff, usernameStaff;

    @FXML
    PasswordField passwordStaff;

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }

    public void setStaffDataSource(StaffDataSource staffDataSource) {
        this.staffDataSource = staffDataSource;
    }

    public void initialize(){
        Platform.runLater(() -> {
            if(!staffs.toList().isEmpty()) {
                showTableStaff();
            }
        });
        error.setOpacity(0);
    }

    public void showTableStaff(){
        staffObservableList = FXCollections.observableArrayList(staffs.toList());
        staffsTable.setItems(staffObservableList);

        TableColumn timeCol = new TableColumn("Date & Time");
        TableColumn nameStaffCol = new TableColumn("Name's Staff");
        TableColumn usernameCol = new TableColumn("Username");
        TableColumn passwordCol = new TableColumn("Password");

        timeCol.setCellValueFactory(new PropertyValueFactory<Staffs, String>("date"));
        nameStaffCol.setCellValueFactory(new PropertyValueFactory<Staffs, String>("name"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<Staffs, String>("username"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<Staffs, String>("password"));

        staffsTable.getColumns().addAll(timeCol, nameStaffCol, usernameCol, passwordCol);

        timeCol.setSortType(TableColumn.SortType.DESCENDING);
        staffsTable.getSortOrder().add(timeCol);
    }

    @FXML
    public void handleToRegisterStaff(ActionEvent event){
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
        staffsTable.getColumns().clear();
        staffsTable.getItems().clear();
        showTableStaff();
        error.setOpacity(1);
        nameStaff.clear();
        usernameStaff.clear();
        passwordStaff.clear();
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
