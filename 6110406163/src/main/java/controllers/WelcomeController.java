package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Rooms;
import models.Staffs;
import services.RoomDataSource;
import services.RoomFileDataSource;
import services.StaffDataSource;
import services.StaffFileDataSource;

import java.io.IOException;

public class WelcomeController {
    private Staffs staffs = new Staffs();
    private Rooms rooms = new Rooms();
    private StaffDataSource staffDataSource;
    private RoomDataSource roomDataSource;

    @FXML
    public void initialize(){
        staffDataSource = new StaffFileDataSource("data", "staffs.csv");
        roomDataSource = new RoomFileDataSource("data", "rooms.csv");
        staffs = staffDataSource.getStaffsData();
        rooms = roomDataSource.getRoomsData();
        System.out.println(rooms.toString());
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
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
    public void handleToAdministratorLogin(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        LoginController loginController = loader.getController();
        loginController.setCheck("a");
        loginController.setStaffs(staffs);
        loginController.setStaffDataSource(staffDataSource);
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
        loginController.setStaffDataSource(staffDataSource);
        loginController.setRooms(rooms);
        loginController.setRoomDataSource(roomDataSource);
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
