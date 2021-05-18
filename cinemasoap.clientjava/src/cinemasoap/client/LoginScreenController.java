package cinemasoap.client;


import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.datacontract.schemas._2004._07.cinemasoap_service.Movie;
import org.datacontract.schemas._2004._07.cinemasoap_service.Screening;
import org.tempuri.CinemaSoap;
import org.tempuri.ICinemaService;
import sun.misc.BASE64Encoder;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.AddressingFeature;

public class LoginScreenController implements Initializable {
    @FXML
    private TextField emailTextBox;
    @FXML
    private PasswordField passwordTextBox;
    @FXML
    private Button loginButton;

    public CinemaSoap cinemaSoap;
    public ICinemaService service;
    public String[] loginData;
    FXMLLoader loader;

    public LoginScreenController() {
        cinemaSoap = new CinemaSoap();
        service = cinemaSoap.getWSHttpBindingICinemaService(new AddressingFeature(true, true));
    }

    private void getLoginData()
    {
        loginData = new String[2];

        loginData[0] = this.emailTextBox.getText();
        loginData[1] = this.passwordTextBox.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    loginButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                getLoginData();
                final Stage thisStage = (Stage)loginButton.getScene().getWindow();
                loader = new FXMLLoader(getClass().getResource("Repertoire.fxml"));

                try {
                    String authString = loginData[0] + ":" + loginData[1];
                    String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
                    Map<String, List<String>> requestHeaders = new HashMap<>();
                    Main.setAuthHeader("Authorization", Arrays.asList("Basic " + authStringEnc));
                    requestHeaders.put(Main.getAuthHeader().getKey(), Main.getAuthHeader().getValue());
                    BindingProvider bindingProvider = ((BindingProvider) service);
                    bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    service.getRepertoire(formatter.format(new Date())).getMovie();
                    Main.setUserEmail(loginData[0]);
                } catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Nieprawidłowe dane logowania. Spróbuj ponownie.");
                    alert.show();
                    return;
                }
                Parent root = (Parent) loader.load();
                Stage repertoireStage = new Stage();
                repertoireStage.setScene(new Scene(root));
                repertoireStage.setTitle("Repertuar | Cinema SOAP");
                thisStage.close();
                repertoireStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    }
}
