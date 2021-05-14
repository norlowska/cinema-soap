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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.util.Callback;
import org.datacontract.schemas._2004._07.cinemasoap_service.Movie;
import org.datacontract.schemas._2004._07.cinemasoap_service.Screening;
import org.tempuri.CinemaSoap;
import org.tempuri.ICinemaService;

import javax.xml.ws.soap.AddressingFeature;

public class RepertoireController implements Initializable {

    private List<String> dates;
    private ObservableList<Movie> movies;

    @FXML
    private ToggleButton  toggleDate1;
    @FXML
    private ToggleButton  toggleDate2;
    @FXML
    private ToggleButton  toggleDate3;
    @FXML
    private ToggleButton  toggleDate4;
    @FXML
    private ToggleButton  toggleDate5;
    @FXML
    private ListView repertoireList;

    public RepertoireController() {

        Date now = new Date();
        String pattern = "dd.MM";
        dates = new ArrayList<String>();
        dates.add(DateTimeFormatter.ofPattern(pattern).format(LocalDateTime.from(now.toInstant().atZone(ZoneId.of("GMT+1")))));
        dates.add(DateTimeFormatter.ofPattern(pattern).format(LocalDateTime.from(now.toInstant().atZone(ZoneId.of("GMT+1"))).plusDays(1)));
        dates.add(DateTimeFormatter.ofPattern(pattern).format(LocalDateTime.from(now.toInstant().atZone(ZoneId.of("GMT+1"))).plusDays(2)));
        dates.add(DateTimeFormatter.ofPattern(pattern).format(LocalDateTime.from(now.toInstant().atZone(ZoneId.of("GMT+1"))).plusDays(3)));
        dates.add(DateTimeFormatter.ofPattern(pattern).format(LocalDateTime.from(now.toInstant().atZone(ZoneId.of("GMT+1"))).plusDays(4)));
        CinemaSoap cinemaSoap = new CinemaSoap();
        ICinemaService service = cinemaSoap.getWSHttpBindingICinemaService(new AddressingFeature(true, true));

        movies = FXCollections.observableArrayList();
        List<Movie> list = service.getRepertoire(dates.get(0)).getMovie();
        //movies.addAll();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toggleDate1.setText(dates.get(0));
        toggleDate2.setText(dates.get(1));
        toggleDate3.setText(dates.get(2));
        toggleDate4.setText(dates.get(3));
        toggleDate5.setText(dates.get(4));
        repertoireList.setItems(movies);
        repertoireList.setCellFactory(new Callback<ListView<Movie>, ListCell<Movie>>() {
            @Override
            public ListCell call(ListView param) {
                return null;
            }
        });
    }
}
