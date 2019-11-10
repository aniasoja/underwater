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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Scene3_Controller3 implements Initializable {

    @FXML
    private AnchorPane root2;
    @FXML
    private StackPane seahorse;
    @FXML
    private StackPane octopus;
    @FXML
    private ImageView leftArrow;
    @FXML
    private ImageView rightArrow;

	private double X;
	
	int level;            // need work to decide!
	int level_now;        //
	boolean done = false;
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void position(MouseEvent event) {
    	X = event.getX();
    	System.out.println(X);
    	StackPane parentContainer = ((StackPane) root2.getParent());
    	System.out.println(parentContainer.getChildrenUnmodifiable());
    	System.out.println(root2.getChildren());
    }
    
    @FXML
    private void loadNext(MouseEvent event) throws IOException {
    if(X - event.getX()>75 && done == false) {
        StackPane octopus = FXMLLoader.load(getClass().getResource("ChooseChar2.fxml"));
        Scene scene = seahorse.getScene();
        octopus.translateXProperty().set(scene.getWidth());
        octopus.setTranslateY(70);

        root2.getChildren().add(octopus);
        
        if(level<level_now) {
        	octopus.setDisable(true);
        }

        Timeline timeline = new Timeline();
        KeyValue kv0 = new KeyValue(seahorse.translateXProperty(), -400, Interpolator.LINEAR);
		KeyFrame kf0 = new KeyFrame(Duration.seconds(1), kv0);
        KeyValue kv1 = new KeyValue(octopus.translateXProperty(), 0, Interpolator.LINEAR);
        //KeyValue kv0a = new KeyValue(octopus.translateYProperty(), 100, Interpolator.LINEAR);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().addAll(kf0, kf1);
        timeline.setOnFinished(t -> {
        	root2.getChildren().remove(seahorse);
        });
        timeline.play();
        done = true;
    	}
    else if(X - event.getX()<75 && done == false) {
        StackPane seahorse = FXMLLoader.load(getClass().getResource("ChooseChar.fxml"));
        Scene scene = octopus.getScene();
        seahorse.translateXProperty().set(scene.getWidth());
        //seahorse.setTranslateY(70);

        root2.getChildren().add(seahorse);
        
        if(level<level_now) {
        	seahorse.setDisable(true);
        }

        Timeline timeline = new Timeline();
        KeyValue kv0 = new KeyValue(octopus.translateXProperty(), -400, Interpolator.LINEAR);
		KeyFrame kf0 = new KeyFrame(Duration.seconds(1), kv0);
        KeyValue kv1 = new KeyValue(seahorse.translateXProperty(), 0, Interpolator.LINEAR);
        //KeyValue kv0a = new KeyValue(octopus.translateYProperty(), 100, Interpolator.LINEAR);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().addAll(kf0, kf1);
        timeline.setOnFinished(t -> {
        	root2.getChildren().remove(octopus);
        });
        timeline.play();
        done = true;
    	}
    }
    
    @FXML
    private void loadMaze(MouseEvent event) throws IOException{
    	//load the maze
    }
}
