package adventure;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Scene2_Controller2 implements Initializable {

    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private AnchorPane newRoot;
    @FXML
    private StackPane parentContainer;
    @FXML
    private Text text2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void loadThird(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ChooseChar.fxml"));
        Scene scene = text2.getScene();
        root.translateYProperty().set(scene.getHeight());

        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(newRoot);
        });
        timeline.play();
    }

}
