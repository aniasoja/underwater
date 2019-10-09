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


public class Scene3_Controller3 implements Initializable {

	
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private AnchorPane newRoot;
    @FXML
    private StackPane parentContainer;
    @FXML
    private Text text2;

	private double X;
	
	int level;            // need work to decide!
	int level_now;        //
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void position(MouseEvent event) {
    	X = event.getX();
    }
    
    @FXML
    private void loadChar(MouseEvent event) throws IOException {
    	if(X - event.getX()>75) {
        Parent root2 = FXMLLoader.load(getClass().getResource("ChooseChar.fxml"));
        Scene scene = text2.getScene();
        root2.translateXProperty().set(scene.getWidth());

        parentContainer.getChildren().add(root2);
        
        if(level<level_now) {
        	root2.setDisable(true);
        }

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root2.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(newRoot);
        });
        timeline.play();
    	}
    }
    
    @FXML
    private void loadMaze(MouseEvent event) throws IOException{
    	//load the maze
    }
}
