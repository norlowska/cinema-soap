package cinemasoap.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import org.datacontract.schemas._2004._07.cinemasoap_service.Reservation;
import org.datacontract.schemas._2004._07.cinemasoap_service.Screening;
import org.tempuri.CinemaSoap;
import org.tempuri.ICinemaService;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.AddressingFeature;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationCellController extends ListCell<Reservation> {
    private ICinemaService service;
    @FXML
    Label infoLabel;

    @FXML
    private void EditReservation()
    {

    }

    @FXML
    private void CancelReservation()
    {
        java.lang.String id = infoLabel.getText();
        CinemaSoap cinemaSoap = new CinemaSoap();
        service = cinemaSoap.getWSHttpBindingICinemaService(new AddressingFeature(true, true));
        Map<String, List<String>> requestHeaders = new HashMap<>();
        requestHeaders.put(Main.getAuthHeader().getKey(), Main.getAuthHeader().getValue());
        BindingProvider bindingProvider = ((BindingProvider) service);
        bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
        service.cancelReservation(id);
    }

}
