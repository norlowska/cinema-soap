package cinemasoap.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import org.datacontract.schemas._2004._07.cinemasoap_service.Movie;
import org.datacontract.schemas._2004._07.cinemasoap_service.Screen;
import org.datacontract.schemas._2004._07.cinemasoap_service.Screening;
import org.datacontract.schemas._2004._07.cinemasoap_service.Seat;
import org.tempuri.CinemaSoap;
import org.tempuri.ICinemaService;

import javax.xml.ws.soap.AddressingFeature;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

public class ReservationScreenController implements Initializable {

    private ICinemaService service;
    private ObservableList<Seat> seats;

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
        if(screening != null) {
            Movie movie = screening.getMovie().getValue();
            CinemaSoap cinemaSoap = new CinemaSoap();
            infoLabel.setText("Title: " + movie.getTitle().toString() + "\n Date" + screening.getFullDate().toString() + "\n Seats:");

        }
        else infoLabel.setText("error");

        CinemaSoap cinemaSoap = new CinemaSoap();
        service = cinemaSoap.getWSHttpBindingICinemaService(new AddressingFeature(true, true));
        seats = FXCollections.observableArrayList();
        seats.addAll(screening.getFreeSeats().getValue().getSeat());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        seatsView.setItems(seats);
        seatsView.setCellFactory(movieListView -> new MovieListCell());
    }


}
