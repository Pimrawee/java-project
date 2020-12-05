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
import services.*;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class ReceiveParcelController {
    private String nameStaffLogin;
    private Rooms rooms;
    private RoomDataSource roomDataSource;
    private Guests guests;
    private GuestDataSource guestDataSource;
    private Locker locker;
    private ObservableList<Letter> parcelObservableList;
    private LockerDataSource lockerDataSource;
    private Parcel parcel;

    @FXML
    Label nameStaff, error;

    @FXML
    TextField receiverParcel, senderParcel, companyParcel, trackingNumberParcel, sizeParcel;

    @FXML
    ChoiceBox roomList;

    @FXML
    TableView parcelTable;

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
                error.setOpacity(0);

                setRoomList();

                if(!locker.toLists(new ParcelFormat()).isEmpty()) {
                    showTableParcel();
                }
            }
        });

        parcelTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                parcel = (Parcel) newValue;
            }
        });
    }

    public void setRoomList(){
        Collections.sort(guests.toList(), new Comparator<GuestInformation>() {
            @Override
            public int compare(GuestInformation o1, GuestInformation o2) {
                return o1.getRoomGuestCon().compareTo(o2.getRoomGuestCon());
            }
        });

        for (GuestInformation g : guests.toList()){
            if (!g.getName().equals("")){
                roomList.getItems().add(g.getRoomGuestCon());
            }
        }
    }

    public void showTableParcel(){
        parcelObservableList = FXCollections.observableArrayList(locker.toLists(new ParcelFormat()));
        parcelTable.setItems(parcelObservableList);

        TableColumn timeCol = new TableColumn("Date & Time");
        TableColumn receiverCol = new TableColumn("Receiver");
        TableColumn roomCol = new TableColumn("Room");
        TableColumn senderCol = new TableColumn("Sender");
        TableColumn companyCol = new TableColumn("Company");
        TableColumn trackingNumberCol = new TableColumn("Tracking No.");
        TableColumn sizeCol = new TableColumn("Size");

        timeCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("time"));
        receiverCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("receiver"));
        roomCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("roomReceiver"));
        senderCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("sender"));
        companyCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("company"));
        trackingNumberCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("trackingNumber"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("size"));

        parcelTable.getColumns().addAll(timeCol,receiverCol , roomCol, senderCol, companyCol, trackingNumberCol, sizeCol);

        timeCol.setSortType(TableColumn.SortType.DESCENDING);
        parcelTable.getSortOrder().add(timeCol);
    }

    @FXML
    public void handleToAddParcel(ActionEvent event){
        if (receiverParcel.getText().equals("") || roomList.getValue() == null || senderParcel.getText().equals("") || sizeParcel.getText().equals("") || companyParcel.getText().equals("") || trackingNumberParcel.getText().equals("")){
            error.setText("Incorrect information");
        }
        else {
            if (guests.checkGuest(receiverParcel.getText(), (String) roomList.getValue())) {
                Parcel parcel = new Parcel(receiverParcel.getText(), (String) roomList.getValue(), senderParcel.getText(), sizeParcel.getText(), companyParcel.getText(), trackingNumberParcel.getText());
                parcel.setDateTimeReceive();
                locker.addItem(parcel);
                lockerDataSource.setLockerData(locker);
                error.setText("Successful!");
            } else {
                error.setText("Invalid Information.");
            }
        }
        error.setOpacity(1);
        receiverParcel.clear();
        roomList.getItems().clear();
        senderParcel.clear();
        companyParcel.clear();
        trackingNumberParcel.clear();
        sizeParcel.clear();
        parcelTable.getColumns().clear();
        parcelTable.getItems().clear();
        setRoomList();
        showTableParcel();
    }

    @FXML
    public void handleToRemoveParcel(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation");
        alert.setContentText("Are you sure?");
        alert.showAndWait().ifPresent((btnType)->{
            if (btnType == ButtonType.OK){
                locker.removeItem(parcel);
                lockerDataSource.setLockerData(locker);
                parcelTable.getColumns().clear();
                parcelTable.getItems().clear();
                showTableParcel();
            }
        });
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
        welcomeController.setGuests(guests);
        welcomeController.setGuestDataSource(guestDataSource);
        welcomeController.setLocker(locker);
        welcomeController.setLockerDataSource(lockerDataSource);
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
        staffController.setGuests(guests);
        staffController.setGuestDataSource(guestDataSource);
        staffController.setLocker(locker);
        staffController.setLockerDataSource(lockerDataSource);
        stage.show();
    }
}
