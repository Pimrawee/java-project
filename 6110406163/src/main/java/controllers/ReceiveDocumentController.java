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

public class ReceiveDocumentController {
    private String nameStaffLogin;
    private Rooms rooms;
    private RoomDataSource roomDataSource;
    private Guests guests;
    private GuestDataSource guestDataSource;
    private Locker locker;
    private LockerDataSource lockerDataSource;
    private ObservableList<Document> documentObservableList;
    private Document document;
    ObservableList<String> setLevelList = FXCollections.observableArrayList("Regular", "Secret", "Top Secret");

    @FXML
    Label nameStaff, error;

    @FXML
    TextField receiverDocument, senderDocument, sizeDocument;

    @FXML
    ChoiceBox roomList, levelList;

    @FXML
    TableView documentTable;

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
                levelList.setItems(setLevelList);

                setRoomList();

                if(!locker.toListDocument().isEmpty()) {
                    showTableDocument();
                }
            }
        });

        documentTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                document = (Document) newValue;
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

    public void showTableDocument(){
        documentObservableList = FXCollections.observableArrayList(locker.toListDocument());
        documentTable.setItems(documentObservableList);

        TableColumn timeCol = new TableColumn("Date & Time");
        TableColumn receiverCol = new TableColumn("Receiver");
        TableColumn roomCol = new TableColumn("Room");
        TableColumn senderCol = new TableColumn("Sender");
        TableColumn sizeCol = new TableColumn("Size");
        TableColumn levelCol = new TableColumn("Level of Importance");

        timeCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("time"));
        receiverCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("receiver"));
        roomCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("roomReceiver"));
        senderCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("sender"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("size"));
        levelCol.setCellValueFactory(new PropertyValueFactory<Locker, String>("levelImportant"));

        documentTable.getColumns().addAll(timeCol,receiverCol , roomCol, senderCol, sizeCol, levelCol);

        timeCol.setSortType(TableColumn.SortType.DESCENDING);
        documentTable.getSortOrder().add(timeCol);
    }

    @FXML
    public void handleToAddDocument(ActionEvent event){
        if (receiverDocument.getText().equals("") || roomList.getValue() == null || senderDocument.getText().equals("") || sizeDocument.getText().equals("") || levelList.getValue() == null){
            error.setText("Incorrect information");
        }
        else {
            if (guests.checkGuest(receiverDocument.getText(), (String) roomList.getValue())) {
                Document document = new Document(receiverDocument.getText(), (String) roomList.getValue(), senderDocument.getText(), sizeDocument.getText(), (String) levelList.getValue());
                document.setDateTimeReceive();
                locker.addDocument(document);
                lockerDataSource.setLockerData(locker);
                error.setText("Successful!");
            } else {
                error.setText("Invalid Information.");
            }
        }
        error.setOpacity(1);
        receiverDocument.clear();
        roomList.getItems().clear();
        senderDocument.clear();
        sizeDocument.clear();
        documentTable.getColumns().clear();
        documentTable.getItems().clear();
        levelList.setValue(setLevelList);
        setRoomList();
        showTableDocument();
    }

    @FXML
    public void handleToRemoveDocument(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation");
        alert.setContentText("Are you sure?");
        alert.showAndWait().ifPresent((btnType)->{
            if (btnType == ButtonType.OK){
                locker.removeDocument(document);
                lockerDataSource.setLockerData(locker);
                documentTable.getColumns().clear();
                documentTable.getItems().clear();
                showTableDocument();
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
