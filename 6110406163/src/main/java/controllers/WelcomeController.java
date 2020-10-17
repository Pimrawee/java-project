package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Guests;
import models.Rooms;
import models.Staffs;
import services.*;

import java.io.IOException;

public class WelcomeController {
    private Staffs staffs = new Staffs();
    private Rooms rooms = new Rooms();
    private Guests guests = new Guests();
    private StaffDataSource staffDataSource;
    private RoomDataSource roomDataSource;
    private GuestDataSource guestDataSource;

    @FXML
    public void initialize(){
        staffDataSource = new StaffFileDataSource("data", "staffs.csv");
        roomDataSource = new RoomFileDataSource("data", "rooms.csv");
        guestDataSource = new GuestFileDataSource("data", "guests.csv");
        staffs = staffDataSource.getStaffsData();
        rooms = roomDataSource.getRoomsData();
        guests = guestDataSource.getGuestsData();
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

    public void setGuests(Guests guests) {
        this.guests = guests;
    }

    public void setGuestDataSource(GuestDataSource guestDataSource) {
        this.guestDataSource = guestDataSource;
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
        loginController.setGuests(guests);
        loginController.setGuestDataSource(guestDataSource);
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
