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
import models.*;
import services.GuestDataSource;
import services.RoomDataSource;

import java.io.IOException;

public class StaffController {
    private Rooms rooms;
    private Guests guests;
    private RoomDataSource roomDataSource;
    private GuestDataSource guestDataSource;
    private String nameStaffLogin;
    private ObservableList<GuestInformation> guestObservableList;

    @FXML
    Label nameStaff;

    @FXML
    TextField nameGuest;

    @FXML
    TableView<GuestInformation> guestTable;

    @FXML
    ChoiceBox roomSetList;

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

                setRoomSetList();

                if(!guests.toList().isEmpty()) {
                    showTableGuest();
                }
            }
        });
    }

    public void showTableGuest(){
        guestObservableList = FXCollections.observableArrayList(guests.toList());
        guestTable.setItems(guestObservableList);

        TableColumn nameGuestCol = new TableColumn("Name's Guest");
        TableColumn roomCol = new TableColumn("Room");
        TableColumn typeCol = new TableColumn("Type");

        nameGuestCol.setCellValueFactory(new PropertyValueFactory<Guests, String>("name"));
        roomCol.setCellValueFactory(new PropertyValueFactory<Guests, String>("roomGuestCon"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Guests, String>("type"));

        guestTable.getColumns().addAll(nameGuestCol, roomCol, typeCol);

        roomCol.setSortType(TableColumn.SortType.ASCENDING);
        guestTable.getSortOrder().add(roomCol);
    }

    public void setRoomSetList(){
        for (RoomInformation r : rooms.toList()){
            if (r.getNumGuests() >= 0 && r.getNumGuests() < r.getMaxGuests()){
                roomSetList.getItems().add(r.getRoomCon());
            }
        }
    }

    @FXML
    public void handleToAddGuest(ActionEvent event){
        for (RoomInformation r : rooms.toList()){
            if (r.getRoomCon().equals(roomSetList.getValue())){
                GuestInformation guestInformation = new GuestInformation(nameGuest.getText(), r.getRoom(), r.getFloor());
                guestInformation.setRoomGuestCon(r.getRoomCon());
                guestInformation.setType(r.getType());
                guests.add(guestInformation);
                guestDataSource.setGuestsData(guests);
                r.setNumGuests(r.getNumGuests() + 1);
                roomDataSource.setRoomsData(rooms);
            }
        }
        nameGuest.clear();
        guestTable.getColumns().clear();
        guestTable.getItems().clear();
        roomSetList.getItems().clear();
        setRoomSetList();
        showTableGuest();
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
        setRoomInformationController.setGuests(guests);
        setRoomInformationController.setRoomDataSource(roomDataSource);
        setRoomInformationController.setGuestDataSource(guestDataSource);
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
        welcomeController.setRooms(rooms);
        welcomeController.setGuests(guests);
        welcomeController.setRoomDataSource(roomDataSource);
        welcomeController.setGuestDataSource(guestDataSource);
        stage.show();
    }
}
