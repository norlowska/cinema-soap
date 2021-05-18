package cinemasoap.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.List;

public class Main extends Application {
    private static Pair<String, List<String>> authHeader;
    public static Pair<String, List<String>> getAuthHeader() {
        return authHeader;
    }
    public static void setAuthHeader(String key, List<String> value) {
        Main.authHeader = new Pair<String, List<String>>(key, value);
    }


    private  static String userEmail;
    public static String getUserEmail() {
        return userEmail;
    }
    public static void setUserEmail(String userEmail) {
        Main.userEmail = userEmail;
    }

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
