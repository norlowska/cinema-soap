package cinemasoap.client;

import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.datacontract.schemas._2004._07.cinemasoap_service.*;
import org.datacontract.schemas._2004._07.cinemasoap_service.Character;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

public class MovieRepertoireScreenCellViewController extends ListCell<Screening> {

    private FXMLLoader mLLoader;
    private Screening thisScreening;

    @FXML
    public AnchorPane screeningCell;
    @FXML
    public Button bookButton;
    @FXML
    public Label timeLabel;

    @Override
    protected void updateItem(Screening screening, boolean empty) {
        super.updateItem(screening, empty);
        PseudoClass FAVORITE_PSEUDO_CLASS = PseudoClass.getPseudoClass("favorite");
        if(empty || screening == null)
        {
            setText(null);
            pseudoClassStateChanged(FAVORITE_PSEUDO_CLASS, false);
        } else {
            if(mLLoader == null) {
                try {
                    mLLoader = new FXMLLoader(getClass().getResource("MovieRepertoireScreenCellView.fxml"));
                    mLLoader.setController(this);
                    mLLoader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            pseudoClassStateChanged(FAVORITE_PSEUDO_CLASS, !isSelected());
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd.MM.yyyy");
            timeLabel.setText("Czas: " + formatter.format(screening.getFullDate().toGregorianCalendar().getTime()));
            bookButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            // Tutaj wywala nulla mimo warunku
                public void handle(MouseEvent event) {
                    if (screening != null) {
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReservationScreen.fxml"));
                            loader.setController(new ReservationScreenController(screening));
                            Scene sc = new Scene(loader.load(), 600, 400);
                            Stage stage = new Stage();
                            stage.setScene(sc);
                            stage.setTitle("Rezerwacja miejsc | Cinema SOAP");

                            stage.show();
                            final Stage thisStage = (Stage)bookButton.getScene().getWindow();
                            thisStage.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {

                    }
                }
            });
            setGraphic(screeningCell);
        }
    }






}
