package adventure;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Permanent+Marker&display=swap");
        stage.setScene(scene);
        stage.setTitle("Underwater adventure");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
