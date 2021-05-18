package cinemasoap.client;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.datacontract.schemas._2004._07.cinemasoap_service.Movie;
import org.datacontract.schemas._2004._07.cinemasoap_service.Screening;
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

public class MovieRepertoireScreenController implements Initializable {

    private ObservableList<Screening> screenings;
    private ICinemaService service;

    @FXML
    private ListView seancesList;
    @FXML
    private Button cancelBtn;

    public MovieRepertoireScreenController(List<Screening> screeningsList)
    {
        CinemaSoap cinemaSoap = new CinemaSoap();
        service = cinemaSoap.getWSHttpBindingICinemaService(new AddressingFeature(true, true));
        Map<String, List<String>> requestHeaders = new HashMap<>();
        requestHeaders.put(Main.getAuthHeader().getKey(), Main.getAuthHeader().getValue());
        BindingProvider bindingProvider = ((BindingProvider) service);
        bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
        screenings = FXCollections.observableArrayList();
        screenings.addAll(screeningsList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        seancesList.setItems(screenings);
        seancesList.setCellFactory(movieListView -> new MovieRepertoireScreenCellViewController());
        cancelBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                final Stage thisStage = (Stage)cancelBtn.getScene().getWindow();
                thisStage.close();
            }
        });
    }
}

