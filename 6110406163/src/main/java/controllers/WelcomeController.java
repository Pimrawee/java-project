package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Guests;
import models.Locker;
import models.Rooms;
import models.Staffs;
import services.*;

import java.io.IOException;

public class WelcomeController {
    private Staffs staffs = new Staffs();
    private Rooms rooms = new Rooms();
    private Guests guests = new Guests();
    private Locker locker = new Locker();
    private StaffDataSource staffDataSource;
    private RoomDataSource roomDataSource;
    private GuestDataSource guestDataSource;
    private LockerDataSource lockerDataSource;

    @FXML
    public void initialize(){
        staffDataSource = new StaffFileDataSource("data", "staffs.csv");
        roomDataSource = new RoomFileDataSource("data", "rooms.csv");
        guestDataSource = new GuestFileDataSource("data", "guests.csv");
        lockerDataSource = new LockerFileDataSource("data", "locker.csv");
        staffs = staffDataSource.getStaffsData();
        rooms = roomDataSource.getRoomsData();
        guests = guestDataSource.getGuestsData();
        locker = lockerDataSource.getLockerData();
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

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public void setLockerDataSource(LockerDataSource lockerDataSource) {
        this.lockerDataSource = lockerDataSource;
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
        loginController.setLocker(locker);
        loginController.setLockerDataSource(lockerDataSource);
        stage.show();
    }

    @FXML
    public void handleToGuestLogin(ActionEvent event) throws IOException{
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        LoginController loginController = loader.getController();
        loginController.setGuests(guests);
        loginController.setGuestDataSource(guestDataSource);
        loginController.setCheck("g");
        stage.show();
    }

    @FXML
    public void handleToManual(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/manual.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
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
