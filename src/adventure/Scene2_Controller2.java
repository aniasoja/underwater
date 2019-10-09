package adventure;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Scene2_Controller2 implements Initializable {
    @FXML
    private AnchorPane newRoot;
    @FXML
    private StackPane parentContainer;
    @FXML
    private Text text2;
    
    private double Y;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void position(MouseEvent event) {
    	Y = event.getY();
    	System.out.println(Y);
    }
    
    @FXML
    private void loadThird(MouseEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("ChooseChar.fxml"));
        Scene scene = text2.getScene();
        root2.translateYProperty().set(scene.getHeight());

        parentContainer.getChildren().add(root2);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root2.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(newRoot);
        });
        timeline.play();
    }

}
