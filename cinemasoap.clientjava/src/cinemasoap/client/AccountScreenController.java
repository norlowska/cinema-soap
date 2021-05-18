package cinemasoap.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.datacontract.schemas._2004._07.cinemasoap_service.Movie;
import org.datacontract.schemas._2004._07.cinemasoap_service.Reservation;
import org.datacontract.schemas._2004._07.cinemasoap_service.User;
import org.tempuri.CinemaSoap;
import org.tempuri.ICinemaService;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.AddressingFeature;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class AccountScreenController implements Initializable {
    public User user = this.user;
    private ObservableList<Reservation> reservations;
    private ICinemaService service;

    @FXML
    ListView reservationList;

    public AccountScreenController()
    {
        CinemaSoap cinemaSoap = new CinemaSoap();
        service = cinemaSoap.getWSHttpBindingICinemaService(new AddressingFeature(true, true));
        Map<String, List<String>> requestHeaders = new HashMap<>();
        requestHeaders.put(Main.getAuthHeader().getKey(), Main.getAuthHeader().getValue());
        BindingProvider bindingProvider = ((BindingProvider) service);
        bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
        reservations = FXCollections.observableArrayList();
        reservations.addAll(service.getReservationList(user.getUserID()).getReservation());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        reservationList.setItems(reservations);
        reservationList.setCellFactory(movieListView -> new MovieListCell());
    }


}
