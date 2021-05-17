package cinemasoap.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
            primaryStage.setTitle("Logowanie | Cinema SOAP");
            Scene sc = new Scene(root, 600, 400);
            sc.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
            primaryStage.setScene(sc);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
