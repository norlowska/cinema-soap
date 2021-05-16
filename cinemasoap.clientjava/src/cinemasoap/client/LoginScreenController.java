package cinemasoap.client;


import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import org.datacontract.schemas._2004._07.cinemasoap_service.Movie;
import org.datacontract.schemas._2004._07.cinemasoap_service.Screening;
import org.tempuri.CinemaSoap;
import org.tempuri.ICinemaService;

import javax.xml.ws.soap.AddressingFeature;

public class LoginScreenController implements Initializable {
    @FXML
    private TextField emailTextBox;
    @FXML
    private TextField passwordTextBox;
    @FXML
    private Button loginButton;

    public CinemaSoap cinemaSoap;
    public ICinemaService service;

    public LoginScreenController() {
        cinemaSoap = new CinemaSoap();
        service = cinemaSoap.getWSHttpBindingICinemaService(new AddressingFeature(true, true));
    }

    private String[] getLoginData()
    {
        String[] loginData = new String[2];

        loginData[0] = this.emailTextBox.getText();
        loginData[1] = this.passwordTextBox.getText();

        return loginData;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    loginButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

        }
    });
    }
}
