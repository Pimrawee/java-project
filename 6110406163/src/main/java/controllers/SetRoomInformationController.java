package controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Guests;
import models.RoomInformation;
import models.Rooms;
import services.GuestDataSource;
import services.RoomDataSource;

import java.io.IOException;

public class SetRoomInformationController {
    private String nameStaffLogin;
    private Rooms rooms;
    private Guests guests;
    private RoomDataSource roomDataSource;
    private GuestDataSource guestDataSource;
    ObservableList<String> roomList = FXCollections.observableArrayList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10");
    ObservableList<String> floorList = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8");
    ObservableList<String> typeList = FXCollections.observableArrayList("Single", "Twin");

    @FXML
    ChoiceBox room, floor, type;

    @FXML
    Label nameStaff, error;

    public void setNameStaffLogin(String nameStaffLogin) {
        this.nameStaffLogin = nameStaffLogin;
    }

    public void setRoomDataSource(RoomDataSource roomDataSource) {
        this.roomDataSource = roomDataSource;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
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
        room.setValue("01");
        room.setItems(roomList);
        floor.setValue("1");
        floor.setItems(floorList);
        type.setValue("Single");
        type.setItems(typeList);
    }

    @FXML
    public void handleToSetRoom(Event e){
        String roomSet = (String) room.getValue();
        String floorSet = (String) floor.getValue();
        String typeSet = (String) type.getValue();
            if (rooms.checkEmpty()) {
                RoomInformation roomInformation = new RoomInformation(roomSet, floorSet, typeSet);
                if (typeSet.equals("Single")) {
                    roomInformation.setMaxGuests(1);
                } else if (typeSet.equals("Twin")) {
                    roomInformation.setMaxGuests(2);
                }
                rooms.add(roomInformation);
                roomDataSource.setRoomsData(rooms);
                error.setText("Successful!");
            } else {
                if (rooms.checkRoom(roomSet, floorSet)) {
                    RoomInformation roomInformation = new RoomInformation(roomSet, floorSet, typeSet);
                    if (typeSet.equals("Single")) {
                        roomInformation.setMaxGuests(1);
                    } else if (typeSet.equals("Twin")) {
                        roomInformation.setMaxGuests(2);
                    }
                    rooms.add(roomInformation);
                    roomDataSource.setRoomsData(rooms);
                    error.setText("Successful!");
                } else {
                    error.setText("This room is already set.");
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
        welcomeController.setRooms(rooms);
        welcomeController.setRoomDataSource(roomDataSource);
        stage.show();
    }

    @FXML
    public void handleToBack(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/staff.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        StaffController staffController = loader.getController();
        staffController.setNameStaffLogin(nameStaffLogin);
        staffController.setRooms(rooms);
        staffController.setGuests(guests);
        staffController.setRoomDataSource(roomDataSource);
        staffController.setGuestDataSource(guestDataSource);
        stage.show();
    }
}
