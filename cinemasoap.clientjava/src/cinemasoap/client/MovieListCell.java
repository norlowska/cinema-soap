package cinemasoap.client;

import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.datacontract.schemas._2004._07.cinemasoap_service.Actor;
import org.datacontract.schemas._2004._07.cinemasoap_service.Character;
import org.datacontract.schemas._2004._07.cinemasoap_service.CrewMember;
import org.datacontract.schemas._2004._07.cinemasoap_service.Movie;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class MovieListCell extends ListCell<Movie> {
    private FXMLLoader mLLoader;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Text title;
    @FXML
    private Text director;
    @FXML
    private Label description;
    @FXML
    private Label cast;
    @FXML
    private ImageView poster;

    @Override
    protected void updateItem(Movie movie, boolean empty) {
        super.updateItem(movie, empty);
        PseudoClass FAVORITE_PSEUDO_CLASS = PseudoClass.getPseudoClass("favorite");
        if(empty || movie == null)
        {
            setText(null);
            pseudoClassStateChanged(FAVORITE_PSEUDO_CLASS, false);
        } else {
            if(mLLoader == null) {
                try {
                    mLLoader = new FXMLLoader(getClass().getResource("MovieListCellView.fxml"));
                    mLLoader.setController(this);
                    mLLoader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            pseudoClassStateChanged(FAVORITE_PSEUDO_CLASS, !isSelected());
            title.setText(movie.getTitle().getValue());
            List<CrewMember> crewMemberList = movie.getCrew().getValue().getCrewMember();
            String directorStr = "reż. ";
            for(CrewMember cm : crewMemberList){
                if(cm.getJob().equals("Director"))
                    directorStr += cm.getFirstName() +" "+ cm.getLastName() + ", ";
            };
            director.setText(directorStr.substring(0, directorStr.length()-2));
            description.setText(movie.getDesc().getValue());
            String castStr = "";
            for(Character item : movie.getCharacters().getValue().getCharacter()){
                Actor actor = item.getActor();
                castStr += actor.getFirstName() + " " + (actor.getSecondName().getValue() != null && !actor.getSecondName().getValue().isEmpty() ? actor.getSecondName().getValue() + " " : "") + item.getActor().getLastName() + ", ";
            }
            castStr =  castStr.substring(0, castStr.length() -2);
            cast.setText(castStr);
            poster.setImage(new Image(new ByteArrayInputStream((movie.getImageData().getValue()))));
            setText(null);
            setGraphic(anchorPane);
        }
    }
}
