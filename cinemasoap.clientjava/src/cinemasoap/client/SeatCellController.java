package cinemasoap.client;

import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import org.datacontract.schemas._2004._07.cinemasoap_service.*;
import org.datacontract.schemas._2004._07.cinemasoap_service.Character;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class SeatCellController extends ListCell<Seat> {
    private FXMLLoader mLLoader;
    @FXML
    private Label seatInfo;
    @FXML
    private AnchorPane anchorPane;

    @Override
    protected void updateItem(Seat seat, boolean empty) {
        super.updateItem(seat, empty);
        PseudoClass FAVORITE_PSEUDO_CLASS = PseudoClass.getPseudoClass("favorite");
        if(empty || seat == null)
        {
            setText(null);
            pseudoClassStateChanged(FAVORITE_PSEUDO_CLASS, false);
        } else {
            if(mLLoader == null) {
                try {
                    mLLoader = new FXMLLoader(getClass().getResource("SeatCell.fxml"));
                    mLLoader.setController(this);
                    mLLoader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            pseudoClassStateChanged(FAVORITE_PSEUDO_CLASS, !isSelected());
            seatInfo.setText("Rząd " + seat.getRow() + ", Miejsce " + seat.getSeatNumber());
            setText("Rząd " + seat.getRow() + ", Miejsce " + seat.getSeatNumber());
            setGraphic(anchorPane);
        }
    }
}
