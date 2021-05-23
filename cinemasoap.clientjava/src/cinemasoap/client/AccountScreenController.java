package cinemasoap.client;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.datacontract.schemas._2004._07.cinemasoap_service.*;
import org.tempuri.CinemaSoap;
import org.tempuri.ICinemaService;

import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.AddressingFeature;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class AccountScreenController implements Initializable {
    public ObservableList<Reservation> reservations;
    private ICinemaService service;

    @FXML
    ListView reservationList;
    @FXML
    Button cancelBtn;

    public AccountScreenController()
    {
        CinemaSoap cinemaSoap = new CinemaSoap();
        service = cinemaSoap.getWSHttpBindingICinemaService(new AddressingFeature(true, true));
        Map<String, List<String>> requestHeaders = new HashMap<>();
        requestHeaders.put(Main.getAuthHeader().getKey(), Main.getAuthHeader().getValue());
        BindingProvider bindingProvider = ((BindingProvider) service);
        bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
        reservations = FXCollections.observableArrayList();
        reservations.addAll(service.getReservationList(Main.getUserEmail()).getReservation());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        reservationList.setItems(reservations);
        reservationList.setCellFactory(reservationCell -> new ReservationCellController());
        reservationList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    Reservation currentItemSelected = (Reservation) reservationList.getSelectionModel().getSelectedItem();
                    String seatsInfo = "";
                    for(Seat s : currentItemSelected.getSeats().getSeat()) {
                        seatsInfo += "\nRząd " + s.getRow()  + ", Miejsce " + s.getSeatNumber();
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, seatsInfo);
                    alert.setHeaderText("Zarezerowane miejsca");
                    alert.showAndWait();
                }
            }
        });
        cancelBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                final Stage thisStage = (Stage)cancelBtn.getScene().getWindow();
                thisStage.close();
            }
        });
    }


}
