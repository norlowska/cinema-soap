package cinemasoap.client;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import org.datacontract.schemas._2004._07.cinemasoap_service.Movie;
import org.tempuri.CinemaSoap;
import org.tempuri.ICinemaService;

import javax.xml.ws.soap.AddressingFeature;
import java.net.URL;
import java.util.ResourceBundle;

public class MovieRepertoireScreenController implements Initializable {


    private ObservableList<Movie> movies;
    private ICinemaService service;

    @FXML
    private ListView seancesList;

    public MovieRepertoireScreenController(String date)
    {
        CinemaSoap cinemaSoap = new CinemaSoap();
        service = cinemaSoap.getWSHttpBindingICinemaService(new AddressingFeature(true, true));

        movies = FXCollections.observableArrayList();
        movies.addAll(service.getRepertoire(date).getMovie());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        seancesList.setItems(movies);
        seancesList.setCellFactory(movieListView -> new MovieRepertoireScreenCellViewController());



    }

}

