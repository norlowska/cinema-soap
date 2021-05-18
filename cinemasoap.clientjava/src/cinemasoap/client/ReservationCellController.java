package cinemasoap.client;

import javafx.css.PseudoClass;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.datacontract.schemas._2004._07.cinemasoap_service.Reservation;
import org.datacontract.schemas._2004._07.cinemasoap_service.Screening;
import org.datacontract.schemas._2004._07.cinemasoap_service.Seat;
import org.tempuri.CinemaSoap;
import org.tempuri.ICinemaService;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.AddressingFeature;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationCellController extends ListCell<Reservation> {
    private ICinemaService service;
    private FXMLLoader mLLoader;
    private Reservation reservation;

    @FXML
    Label titleInfo;
    @FXML
    Label screeningDetails;
    @FXML
    AnchorPane reservationCell;
    @FXML
    Button editReservation;
    @FXML
    Button cancelReservation;

    public ReservationCellController() {
        CinemaSoap cinemaSoap = new CinemaSoap();
        service = cinemaSoap.getWSHttpBindingICinemaService(new AddressingFeature(true, true));
        Map<String, List<String>> requestHeaders = new HashMap<>();
        requestHeaders.put(Main.getAuthHeader().getKey(), Main.getAuthHeader().getValue());
        BindingProvider bindingProvider = ((BindingProvider) service);
        bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
    }

    @FXML
    private void EditReservation()
    {

    }

    @Override
    protected void updateItem(Reservation reservation, boolean empty) {
        super.updateItem(reservation, empty);
        this.reservation = reservation;
        PseudoClass FAVORITE_PSEUDO_CLASS = PseudoClass.getPseudoClass("favorite");
        if(empty || reservation == null)
        {
            setText(null);
            pseudoClassStateChanged(FAVORITE_PSEUDO_CLASS, false);
        } else {
            if(mLLoader == null) {
                try {
                    mLLoader = new FXMLLoader(getClass().getResource("ReservationCell.fxml"));
                    mLLoader.setController(this);
                    mLLoader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            pseudoClassStateChanged(FAVORITE_PSEUDO_CLASS, !isSelected());
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd.MM.yyyy");
            titleInfo.setText(reservation.getScreening().getMovie().getValue().getTitle().getValue());
            String screeningDetailStr = formatter.format(reservation.getScreening().getFullDate().toGregorianCalendar().getTime());
            for(Seat s : reservation.getSeats().getSeat()) {
                screeningDetailStr += "\nRząd " + s.getRow()  + ", Miejsce " + s.getSeatNumber();
            }
            screeningDetails.setText(screeningDetailStr);
            editReservation.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    if (reservation != null) {
                        try {

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {

                    }
                }
            });
            cancelReservation.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    if (reservation != null) {
                        try {
                            service.cancelReservation(reservation.getReservationID());
                            getListView().getItems().remove(getItem());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {

                    }
                }
            });
            setGraphic(reservationCell);
        }
    }
}
