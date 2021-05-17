package cinemasoap.client;

import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import org.datacontract.schemas._2004._07.cinemasoap_service.*;
import org.datacontract.schemas._2004._07.cinemasoap_service.Character;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class MovieRepertoireScreenCellViewController extends ListCell<Screening> {

    private FXMLLoader mLLoader;
    private Movie movie;

    @FXML
    private AnchorPane screeningCell;
    @FXML
    private Button bookButton;
    @FXML
    private Label timeLabel;

    @FXML
    public void book(ActionEvent evt)
    {
        //tutaj dodać generowanie nowej rezerwacji.
        FXMLLoader scene = new FXMLLoader(getClass().getResource("ReservationScreen.fxml"));
    }

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
            timeLabel.setText("Time: " + screening.getFullDate());
            setGraphic(screeningCell);
        }
    }
}
