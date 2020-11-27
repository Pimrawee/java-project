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
import services.LockerDataSource;
import services.RoomDataSource;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class StaffController {
    private Rooms rooms;
    private Guests guests;
    private RoomDataSource roomDataSource;
    private GuestDataSource guestDataSource;
    private String nameStaffLogin;
    private ObservableList<GuestInformation> guestObservableList;
    private ObservableList<RoomInformation> roomObservableList;
    private Locker locker;
    private LockerDataSource lockerDataSource;
    private GuestInformation guestInformation;

    @FXML
    Label nameStaff, error;

    @FXML
    TextField nameGuest;

    @FXML
    TableView<GuestInformation> guestTable;

    @FXML
    TableView<RoomInformation> roomTable;

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

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public void setLockerDataSource(LockerDataSource lockerDataSource) {
        this.lockerDataSource = lockerDataSource;
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

                if(!rooms.toList().isEmpty()) {
                    showTableRoom();
                }
            }
        });
        error.setOpacity(0);
        guestTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                guestInformation = (GuestInformation) newValue;
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

    public void showTableRoom(){
        roomObservableList = FXCollections.observableArrayList(rooms.toList());
        roomTable.setItems(roomObservableList);

        TableColumn buildingCol = new TableColumn("Building");
        TableColumn floorCol = new TableColumn("Floor");
        TableColumn roomCol = new TableColumn("Room");
        TableColumn typeCol = new TableColumn("Type");
        TableColumn maxCol = new TableColumn("Capacity");
        TableColumn numCol = new TableColumn("Quantity");

        buildingCol.setCellValueFactory(new PropertyValueFactory<Rooms, String>("building"));
        floorCol.setCellValueFactory(new PropertyValueFactory<Rooms, String>("floor"));
        roomCol.setCellValueFactory(new PropertyValueFactory<Rooms, String>("roomCon"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Rooms, String>("type"));
        maxCol.setCellValueFactory(new PropertyValueFactory<Rooms, String>("maxGuests"));
        numCol.setCellValueFactory(new PropertyValueFactory<Rooms, String>("numGuests"));


        roomTable.getColumns().addAll(buildingCol, floorCol, roomCol, typeCol, maxCol, numCol);

        roomCol.setSortType(TableColumn.SortType.ASCENDING);
        roomTable.getSortOrder().add(roomCol);
    }

    public void setRoomSetList(){
        Collections.sort(rooms.toList(), new Comparator<RoomInformation>() {
            @Override
            public int compare(RoomInformation o1, RoomInformation o2) {
                return o1.getRoomCon().compareTo(o2.getRoomCon());
            }
        });

        for (RoomInformation r : rooms.toList()){
            if (r.getNumGuests() >= 0 && r.getNumGuests() < r.getMaxGuests()){
                roomSetList.getItems().add(r.getRoomCon());
            }
        }
    }

    @FXML
    public void handleToAddGuest(ActionEvent event){
        if (nameGuest.getText().equals("") || roomSetList.getValue() == null){
            error.setText("Incorrect information");
        }
        else {
            for (RoomInformation r : rooms.toList()) {
                if (r.getRoomCon().equals(roomSetList.getValue())) {
                    GuestInformation guestInformation = new GuestInformation(nameGuest.getText(), r.getRoom(), r.getFloor());
                    guestInformation.setRoomGuestCon(r.getRoomCon());
                    guestInformation.setType(r.getType());
                    guests.add(guestInformation);
                    guestDataSource.setGuestsData(guests);
                    r.setNumGuests(r.getNumGuests() + 1);
                    roomDataSource.setRoomsData(rooms);
                    error.setText("Add Successful!");
                }
            }
            error.setOpacity(1);
            nameGuest.clear();
            guestTable.getColumns().clear();
            guestTable.getItems().clear();
            roomSetList.getItems().clear();
            roomTable.getColumns().clear();
            roomTable.getItems().clear();
            setRoomSetList();
            showTableGuest();
            showTableRoom();
        }
    }

    @FXML
    public void handleToRemoveGuest(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation");
        alert.setContentText("Are you sure?");
        alert.showAndWait().ifPresent((btnType)->{
            if (btnType == ButtonType.OK){
                guests.remove(guestInformation);
                guestDataSource.setGuestsData(guests);
                rooms.removeGuest(guestInformation);
                roomDataSource.setRoomsData(rooms);
                nameGuest.clear();
                guestTable.getColumns().clear();
                guestTable.getItems().clear();
                roomTable.getColumns().clear();
                roomTable.getItems().clear();
                error.setText("Remove Successful!");
                error.setOpacity(1);
                showTableGuest();
                showTableRoom();
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
        ReceiveLetterController receiveLetterController = loader.getController();
        receiveLetterController.setNameStaffLogin(nameStaffLogin);
        receiveLetterController.setRooms(rooms);
        receiveLetterController.setRoomDataSource(roomDataSource);
        receiveLetterController.setGuests(guests);
        receiveLetterController.setGuestDataSource(guestDataSource);
        receiveLetterController.setLocker(locker);
        receiveLetterController.setLockerDataSource(lockerDataSource);
        stage.show();
    }

    @FXML
    public void handleToReceiveDocument(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/receive_document.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        ReceiveDocumentController receiveDocumentController = loader.getController();
        receiveDocumentController.setNameStaffLogin(nameStaffLogin);
        receiveDocumentController.setRooms(rooms);
        receiveDocumentController.setRoomDataSource(roomDataSource);
        receiveDocumentController.setGuests(guests);
        receiveDocumentController.setGuestDataSource(guestDataSource);
        receiveDocumentController.setLocker(locker);
        receiveDocumentController.setLockerDataSource(lockerDataSource);
        stage.show();
    }

    @FXML
    public void handleToReceiveParcel(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/receive_parcel.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        ReceiveParcelController receiveParcelController = loader.getController();
        receiveParcelController.setNameStaffLogin(nameStaffLogin);
        receiveParcelController.setRooms(rooms);
        receiveParcelController.setRoomDataSource(roomDataSource);
        receiveParcelController.setGuests(guests);
        receiveParcelController.setGuestDataSource(guestDataSource);
        receiveParcelController.setLocker(locker);
        receiveParcelController.setLockerDataSource(lockerDataSource);
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
        welcomeController.setLocker(locker);
        welcomeController.setLockerDataSource(lockerDataSource);
        stage.show();
    }
}
