package cinemasoap.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.datacontract.schemas._2004._07.cinemasoap_service.Movie;
import org.datacontract.schemas._2004._07.cinemasoap_service.Screen;
import org.datacontract.schemas._2004._07.cinemasoap_service.Screening;
import org.datacontract.schemas._2004._07.cinemasoap_service.Seat;
import org.tempuri.CinemaSoap;
import org.tempuri.ICinemaService;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.AddressingFeature;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationScreenController implements Initializable {

    private ICinemaService service;
    private ObservableList<Seat> seats;
    private Screening screening;
    private Movie movie;

    @FXML
    private Label infoLabel;

    @FXML
    private ImageView posterView;

    @FXML
    private Button bookButton;

    @FXML
    private Button cancelButton;

    @FXML
    private ListView seatsView;



    public ReservationScreenController(Screening screening)
    {
        this.screening = screening;
        this.movie = screening.getMovie().getValue();
        CinemaSoap cinemaSoap = new CinemaSoap();
        service = cinemaSoap.getWSHttpBindingICinemaService(new AddressingFeature(true, true));
        Map<String, List<String>> requestHeaders = new HashMap<>();
        requestHeaders.put(Main.getAuthHeader().getKey(), Main.getAuthHeader().getValue());
        BindingProvider bindingProvider = ((BindingProvider) service);
        bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
        seats = FXCollections.observableArrayList();
        seats.addAll(screening.getFreeSeats().getValue().getSeat());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        infoLabel.setText("Tytuł: " + movie.getTitle().getValue() +
                "\nData: " + formatter.format(screening.getFullDate().toGregorianCalendar().getTime()) +
                "\nSala: " + screening.getScreen().getValue().getScreenName().getValue());
        posterView.setImage(new Image(new ByteArrayInputStream((movie.getImageData().getValue()))));
        seatsView.setItems(seats);
        //seatsView.setCellFactory(seatsView -> new ReservationCellController());

        cancelButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                final Stage thisStage = (Stage)cancelButton.getScene().getWindow();
                thisStage.close();
            }
        });
    }


}
