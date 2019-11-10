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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.image.ImageView;


public class Scene2_Controller2 implements Initializable {
    @FXML
    private AnchorPane newRoot;
    @FXML
    private Text text2;
    @FXML
    private ImageView leftArrow;
    @FXML
    private ImageView rightArrow;
    
    
    private double Y;
    boolean done = false;
    int level = 0;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    }
    
    @FXML
    private void position(MouseEvent event) {
    	Y = event.getY();
    }
    
    @FXML
    private void loadThird(MouseEvent event) throws IOException {
    	StackPane parentContainer = ((StackPane) newRoot.getParent());
    	if(Y-event.getY()>100 && done == false) {
	    	
	        Parent root2 = FXMLLoader.load(getClass().getResource("ChooseChar.fxml"));
	        Scene scene = newRoot.getScene();
	        root2.translateYProperty().set(scene.getHeight());
	
	        parentContainer.getChildren().add(root2);
	        
	        /*
	        if(this.getClass() == Scene2_Controller) {
	        	root2.getChildrenUnmodifiable().get(3).setOpacity(0.0);
	    	}
	    	*/
    		
	        Timeline timeline = new Timeline();
	        KeyValue kv0 = new KeyValue(newRoot.translateYProperty(), -400, Interpolator.LINEAR);
    		KeyFrame kf0 = new KeyFrame(Duration.seconds(1), kv0);
	        KeyValue kv1 = new KeyValue(root2.translateYProperty(), 0, Interpolator.LINEAR);
	        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
	        timeline.getKeyFrames().addAll(kf0, kf1);
	        timeline.setOnFinished(t -> {
	        	parentContainer.getChildren().remove(newRoot);
	        });
	        timeline.play();
	        done = true;
	        
	        /*
	        Timeline timeline = new Timeline();
	        KeyValue kv = new KeyValue(root2.translateYProperty(), 0, Interpolator.EASE_IN);
	        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
	        KeyValue kv1 = new KeyValue(text2.translateYProperty(), -200, Interpolator.EASE_IN);
	        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
	        KeyValue kv2 = new KeyValue(text2.opacityProperty(), 1.0);
	        KeyFrame kf2 = new KeyFrame(Duration.seconds(1), kv2);
	        timeline.getKeyFrames().addAll(kf, kf1, kf2);
	        timeline.setOnFinished(t -> {
	        	parentContainer.getChildren().remove(newRoot);
	        });
	        timeline.play();
	        */
	    }
    }
}
