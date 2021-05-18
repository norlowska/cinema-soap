package cinemasoap.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.datacontract.schemas._2004._07.cinemasoap_service.*;
import org.tempuri.BookScreening;
import org.tempuri.BookScreeningResponse;
import org.tempuri.CinemaSoap;
import org.tempuri.ICinemaService;
import org.datacontract.schemas._2004._07.cinemasoap_service.ObjectFactory;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.AddressingFeature;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
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
        seatsView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        seatsView.setItems(seats);
        seatsView.setCellFactory(seatsView -> new SeatCellController());

        cancelButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                final Stage thisStage = (Stage)cancelButton.getScene().getWindow();
                thisStage.close();
            }
        });

        bookButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                List<Seat> selectedIndices = seatsView.getSelectionModel().getSelectedItems();
                ObjectFactory factory = new ObjectFactory();
                BookScreening booking = new BookScreening();
                ArrayOfSeat seats = factory.createArrayOfSeat();
                for(Seat s : selectedIndices)
                    seats.getSeat().add(s);
                FileContentResponseDTO res = service.bookScreening(screening.getScreeningID(), seats, Main.getUserEmail());
                if(res.getMessage().getValue() != null && !res.getMessage().getValue().isEmpty() && res.getContent().getValue() == null) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setContentText(res.getMessage().getValue());
                    errorAlert.show();
                    return;
                }

                final Stage thisStage = (Stage)cancelButton.getScene().getWindow();
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Zapisz potwierdzenie");
                fileChooser.setInitialFileName(res.getMessage().getValue() + ".pdf");
                fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF", "*.pdf"));
                File file = fileChooser.showSaveDialog(thisStage);
                if (file != null) {
                    try {
                        Files.write(file.toPath(), res.getContent().getValue());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                thisStage.close();
            }
        });
    }


}
