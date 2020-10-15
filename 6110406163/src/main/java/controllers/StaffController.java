package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Rooms;
import models.Staffs;
import services.RoomDataSource;
import services.StaffDataSource;
import services.StaffFileDataSource;

import java.io.IOException;

public class StaffController {
    private Staffs staffs;
    private Rooms rooms;
    private StaffDataSource staffDataSource;
    private RoomDataSource roomDataSource;
    private String nameStaffLogin;

    @FXML
    Label nameStaff;

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }

    public void setNameStaffLogin(String nameStaffLogin) {
        this.nameStaffLogin = nameStaffLogin;
    }

    public void setStaffDataSource(StaffDataSource staffDataSource) {
        this.staffDataSource = staffDataSource;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public void setRoomDataSource(RoomDataSource roomDataSource) {
        this.roomDataSource = roomDataSource;
    }

    @FXML
    public void initialize(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                nameStaff.setText(nameStaffLogin);
            }
        });
    }

    @FXML
    public void handleToSetRoomInformation(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/set_room_information.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        SetRoomInformationController setRoomInformationController = loader.getController();
        setRoomInformationController.setNameStaffLogin(nameStaffLogin);
        setRoomInformationController.setRooms(rooms);
        setRoomInformationController.setRoomDataSource(roomDataSource);
        stage.show();
    }

    @FXML
    public void handleToAddGuest(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/add_guest.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

    @FXML
    public void handleToStatus(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/status.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

    @FXML
    public void handleToReceiveLetter(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/receive_letter.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

    @FXML
    public void handleToReceiveDocument(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/receive_document.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

    @FXML
    public void handleToReceiveParcel(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/receive_parcel.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

    @FXML
    public void handleToLogout(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/welcome.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        WelcomeController welcomeController = loader.getController();
        welcomeController.setStaffs(staffs);
        welcomeController.setRooms(rooms);
        welcomeController.setStaffDataSource(staffDataSource);
        welcomeController.setRoomDataSource(roomDataSource);
        stage.show();
    }
}
