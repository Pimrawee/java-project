package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    String check;

//    @FXML
//    public void initialize(){
//        error.setText("");
//    }

    public void setCheck(String check) {
        this.check = check;
    }

    @FXML
    TextField username, password;
    Label error;

    @FXML
    public void handleToLogin(ActionEvent event) throws IOException {
        if (check.equals("administrator")) {

        }
        else if(check.equals("staff")){

        }
    }

    @FXML
    public void handleToBack(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }
}
