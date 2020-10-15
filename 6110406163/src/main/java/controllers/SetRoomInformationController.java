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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.RoomInformation;
import models.Rooms;
import services.RoomDataSource;

import java.io.IOException;

public class SetRoomInformationController {
    private String nameStaffLogin;
    private Rooms rooms;
    private RoomDataSource roomDataSource;
    ObservableList<String> typeList = FXCollections.observableArrayList("Single", "Twin");

    @FXML
    TextField room, floor;

    @FXML
    ChoiceBox type;

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

    @FXML
    public void initialize(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                nameStaff.setText(nameStaffLogin);
            }
        });
        error.setOpacity(0);
        type.setValue("Single");
        type.setItems(typeList);
    }

    @FXML
    public void handleToSetRoom(Event e){
        String typeRoom = (String) type.getValue();
        if (rooms.checkEmpty()){
            RoomInformation roomInformation = new RoomInformation(Integer.parseInt(room.getText()), Integer.parseInt(floor.getText()), typeRoom);
            if (typeRoom.equals("Single")) {
                roomInformation.setMaxGuests(1);
            } else if (typeRoom.equals("Twin")) {
                roomInformation.setMaxGuests(2);
            }
            rooms.add(roomInformation);
            roomDataSource.setRoomsData(rooms);
            error.setText("Successful!");
        }
        else {
            if (rooms.checkRoom(Integer.parseInt(room.getText()), Integer.parseInt(floor.getText()))) {
                RoomInformation roomInformation = new RoomInformation(Integer.parseInt(room.getText()), Integer.parseInt(floor.getText()), typeRoom);
                if (typeRoom.equals("Single")) {
                    roomInformation.setMaxGuests(1);
                } else if (typeRoom.equals("Twin")) {
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
        room.clear();
        floor.clear();
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
        staffController.setRoomDataSource(roomDataSource);
        stage.show();
    }
}
