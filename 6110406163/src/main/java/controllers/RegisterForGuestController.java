package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.GuestInformation;
import models.Guests;
import services.GuestDataSource;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;


public class RegisterForGuestController {
    private Guests guests;
    private GuestDataSource guestDataSource;

    @FXML
    TextField nameGuest, usernameGuest;

    @FXML
    PasswordField passwordGuest;

    @FXML
    ChoiceBox roomChoiceBox;

    @FXML
    Label error;

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
                error.setOpacity(0);
                setRoomList();
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
                roomChoiceBox.getItems().add(g.getRoomGuestCon());
            }
        }
    }

    @FXML
    public void handleToRegister(ActionEvent event) {
        if (nameGuest.getText().equals("") && roomChoiceBox.getValue().equals("") && usernameGuest.getText().equals("") && passwordGuest.getText().equals("")){
            error.setText("Incorrect information.");
        }
        else {
            if (guests.checkGuest(nameGuest.getText(), (String) roomChoiceBox.getValue())){
                guests.setUsernameAndPassword(nameGuest.getText(), usernameGuest.getText(), passwordGuest.getText());
                guestDataSource.setGuestsData(guests);
                error.setText("Successful!");
            }
            else {
                error.setText("Incorrect information.");
            }
        }
        nameGuest.clear();
        usernameGuest.clear();
        passwordGuest.clear();
        error.setOpacity(1);
    }

    @FXML
    public void handleToBack(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/welcome.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        WelcomeController welcomeController = loader.getController();
        welcomeController.setGuests(guests);
        welcomeController.setGuestDataSource(guestDataSource);
        stage.show();
    }

}
