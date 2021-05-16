package cinemasoap.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Repertoire.fxml"));
        primaryStage.setTitle("Cinema SOAP");
        Scene sc = new Scene(root, 810, 513);
        sc.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(sc);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
