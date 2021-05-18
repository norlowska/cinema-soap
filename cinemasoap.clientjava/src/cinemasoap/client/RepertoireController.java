package cinemasoap.client;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.datacontract.schemas._2004._07.cinemasoap_service.Movie;
import org.datacontract.schemas._2004._07.cinemasoap_service.ObjectFactory;
import org.datacontract.schemas._2004._07.cinemasoap_service.Screening;
import org.tempuri.CinemaSoap;
import org.tempuri.ICinemaService;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.AddressingFeature;

public class RepertoireController implements Initializable {

    private List<String> dates;
    private ObservableList<Movie> movies;
    private ICinemaService service;

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
    @FXML
    private ToggleGroup dateToggle;
    @FXML
    private Button accountButton;

    @FXML
    private void showMySeances()
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountScreen.fxml"));
            Scene sc = new Scene(loader.load(), 810, 513);

            Stage stage = new Stage();
            stage.setScene(sc);

            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


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
        service = cinemaSoap.getWSHttpBindingICinemaService(new AddressingFeature(true, true));
        Map<String, List<String>> requestHeaders = new HashMap<>();
        requestHeaders.put(Main.getAuthHeader().getKey(), Main.getAuthHeader().getValue());
        BindingProvider bindingProvider = ((BindingProvider) service);
        bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
        movies = FXCollections.observableArrayList();
        movies.addAll(service.getRepertoire(dates.get(0)).getMovie());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toggleDate1.setText(dates.get(0));
        toggleDate2.setText(dates.get(1));
        toggleDate3.setText(dates.get(2));
        toggleDate4.setText(dates.get(3));
        toggleDate5.setText(dates.get(4));
        repertoireList.setItems(movies);
        repertoireList.setCellFactory(movieListView -> new MovieListCell());

        dateToggle.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (dateToggle.getSelectedToggle() != null) {
                    String dateStr = ((ToggleButton) dateToggle.getSelectedToggle()).getText();
                    movies.remove(0, movies.size());
                    movies.addAll(service.getRepertoire(dateStr).getMovie());
                }
            }
        });

        repertoireList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    Movie currentItemSelected = (Movie) repertoireList.getSelectionModel().getSelectedItem();
                    // tutaj dodać wywołanie nowego okna seansów
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("MovieRepertoireScreen.fxml"));
                        List<Screening> screenings = currentItemSelected.getScreenings().getValue().getScreening();
                        ObjectFactory factory = new ObjectFactory();
                        for(Screening s : screenings)
                            s.setMovie(factory.createMovie(currentItemSelected));
                        loader.setController(new MovieRepertoireScreenController(screenings));
                        Scene sc = new Scene(loader.load(), 600, 400);
                        Stage stage = new Stage();
                        stage.setScene(sc);
                        stage.setTitle("Seanse \"" + screenings.get(0).getMovie().getValue().getTitle().getValue() + "\" | Cinema SOAP");

                        stage.show();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        accountButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountScreen.fxml"));
                    loader.setController(new AccountScreenController());
                    Scene sc = null;
                    sc = new Scene(loader.load(), 600, 400);
                    Stage stage = new Stage();
                    stage.setScene(sc);
                    stage.setTitle("Moje konto | Cinema SOAP");
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
