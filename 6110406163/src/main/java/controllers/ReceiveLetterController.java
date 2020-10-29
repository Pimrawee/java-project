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

public class ReceiveLetterController {
    private String nameStaffLogin;
    private Rooms rooms;
    private RoomDataSource roomDataSource;
    private Guests guests;
    private GuestDataSource guestDataSource;
    private Locker locker;
    private LockerDataSource lockerDataSource;
    private ObservableList<Letter> letterObservableList;
    private Letter letter;

    @FXML
    ChoiceBox roomList;

    @FXML
    Label nameStaff, error;

    @FXML
    TextField receiverLetter, senderLetter, sizeLetter;

    @FXML
    TableView letterTable;

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

                if(!locker.toListLetter().isEmpty()) {
                    showTableLetter();
                }
            }
        });

        letterTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                letter = (Letter) newValue;
            }
        });
    }

    public void setRoomList(){
        for (GuestInformation g : guests.toList()){
            if (!g.getName().equals("")){
                roomList.getItems().add(g.getRoomGuestCon());
            }
        }
    }

    public void showTableLetter(){
        letterObservableList = FXCollections.observableArrayList(locker.toListLetter());
        letterTable.setItems(letterObservableList);

        TableColumn timeCol = new TableColumn("Date & Time");
        TableColumn receiverCol = new TableColumn("Receiver");
        TableColumn roomCol = new TableColumn("Room");
        TableColumn senderCol = new TableColumn("Sender");
        TableColumn sizeCol = new TableColumn("Size");

        timeCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("time"));
        receiverCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("receiver"));
        roomCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("roomReceiver"));
        senderCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("sender"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("size"));

        letterTable.getColumns().addAll(timeCol,receiverCol , roomCol, senderCol, sizeCol);

        timeCol.setSortType(TableColumn.SortType.DESCENDING);
        letterTable.getSortOrder().add(timeCol);
    }

    @FXML
    public void handleToAddLetter(ActionEvent event){
        if (receiverLetter.getText().equals("") || roomList.getValue() == null || senderLetter.getText().equals("") || sizeLetter.getText().equals("")){
            error.setText("Incorrect information");
        }
        else {
            if (guests.checkGuest(receiverLetter.getText(), (String) roomList.getValue())) {
                Letter letter = new Letter(receiverLetter.getText(), (String) roomList.getValue(), senderLetter.getText(), sizeLetter.getText());
                letter.setDateTimeReceive();
                locker.addLetter(letter);
                lockerDataSource.setLockerData(locker);
                error.setText("Successful!");
            } else {
                error.setText("Invalid Information.");
            }
        }
        error.setOpacity(1);
        receiverLetter.clear();
        roomList.getItems().clear();
        senderLetter.clear();
        sizeLetter.clear();
        letterTable.getColumns().clear();
        letterTable.getItems().clear();
        setRoomList();
        showTableLetter();
    }

    @FXML
    public void handleToRemoveLetter(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation");
        alert.setContentText("Are you sure?");
        alert.showAndWait().ifPresent((btnType)->{
            if (btnType == ButtonType.OK){
                locker.removeLetter(letter);
                lockerDataSource.setLockerData(locker);
                letterTable.getColumns().clear();
                letterTable.getItems().clear();
                showTableLetter();
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
