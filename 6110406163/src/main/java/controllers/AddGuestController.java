package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.GuestInformation;
import models.Guests;
import models.Rooms;
import models.Staffs;
import services.GuestDataSource;
import services.RoomDataSource;
import services.StaffDataSource;

import java.io.IOException;

public class AddGuestController {
    private String nameStaffLogin;
    private Rooms rooms;
    private Guests guests;
    private RoomDataSource roomDataSource;
    private GuestDataSource guestDataSource;

    @FXML
    Label error, nameStaff;

    @FXML
    Button addGuest;

    @FXML
    TextField nameGuest, roomGuest , floorGuest;

    public void setNameStaffLogin(String nameStaffLogin) {
        this.nameStaffLogin = nameStaffLogin;
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
    public void initialize(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                nameStaff.setText(nameStaffLogin);
            }
        });
        error.setOpacity(0);
    }

    @FXML
    public void handleToAddGuest(Event e){
        if (Integer.parseInt(roomGuest.getText()) <= 0 || Integer.parseInt(roomGuest.getText()) > 10 ||
        Integer.parseInt(floorGuest.getText()) <= 0 || Integer.parseInt(floorGuest.getText()) > 8){
            error.setText("Fill in wrong information. Please enter it again.");
        }
        else {
            if (!rooms.checkRoom(Integer.parseInt(roomGuest.getText()), Integer.parseInt(floorGuest.getText()))) {
                if (rooms.checkNumGuest(Integer.parseInt(roomGuest.getText()), Integer.parseInt(floorGuest.getText()))) {
                    GuestInformation guestInformation = new GuestInformation(nameGuest.getText(), roomGuest.getText(), floorGuest.getText());
                    guestInformation.setType(rooms.findTypeRoom(Integer.parseInt(roomGuest.getText()), Integer.parseInt(floorGuest.getText())));
                    guests.add(guestInformation);
                    rooms.addGuest(Integer.parseInt(roomGuest.getText()), Integer.parseInt(floorGuest.getText()));
                    error.setText("Successful!");
                    roomDataSource.setRoomsData(rooms);
                    guestDataSource.setGuestsData(guests);
                } else {
                    error.setText("This room is full.");
                }
            } else {
                error.setText("This room has not set room information yet."); // ไม่มีการเซ็ตห้อง
            }
        }
        nameGuest.clear();
        roomGuest.clear();
        floorGuest.clear();
        error.setOpacity(1);
    }

    @FXML
    public void handleToLogout(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/welcome.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        LoginController loginController =loader.getController();
        loginController.setGuests(guests);
        loginController.setGuestDataSource(guestDataSource);
        stage.show();
    }

    @FXML
    public void handleToBack(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/staff.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        StaffController staffController = loader.getController();
        staffController.setGuests(guests);
        staffController.setGuestDataSource(guestDataSource);
        stage.show();
    }
}
