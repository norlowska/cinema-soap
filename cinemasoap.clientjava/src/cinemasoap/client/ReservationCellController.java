package cinemasoap.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import org.datacontract.schemas._2004._07.cinemasoap_service.Reservation;
import org.datacontract.schemas._2004._07.cinemasoap_service.Screening;
import org.tempuri.CinemaSoap;
import org.tempuri.ICinemaService;

import javax.xml.ws.soap.AddressingFeature;
import java.awt.*;

public class ReservationCellController extends ListCell<Reservation> {

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
        ICinemaService service = cinemaSoap.getWSHttpBindingICinemaService(new AddressingFeature(true, true));
        service.cancelReservation(id);
    }

}
