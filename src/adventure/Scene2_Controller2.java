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
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.effect.ColorAdjust; 


public class Scene2_Controller2 implements Initializable {
    @FXML
    private StackPane triton;
    @FXML
    private StackPane octopus;
    @FXML
    private StackPane dolphin;
    @FXML
    private StackPane mermaid;
    @FXML
    private ImageView leftArrow;
    @FXML
    private ImageView rightArrow;
    @FXML
    private Text description;
    @FXML
    private Text name;
    @FXML
    private Text level;
    @FXML
    private StackPane parentContainer;

	private double X;

	boolean done = false;
	boolean check = false;
	
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void position(MouseEvent event) {
    	X = event.getX();
    }
    
    @FXML
    private void loadNext(MouseEvent event) throws IOException {
    	Node level2 = name.getParent().getParent().getChildrenUnmodifiable().get(name.getParent().getParent().getChildrenUnmodifiable().size()-1);
    	Text level = (Text) level2;
        
    	if(level.getText().equals("6")) {
    		level.setText(level.getText() + "" + "A");
        }
	    if(X - event.getX()>50 && done == false) {
	    	if(level.getText().contains("A")) {
	    		StackPane triton = FXMLLoader.load(getClass().getResource("ChooseChar2.fxml"));
	    		move(name.getParent(), triton, level, -1400, "B", name.getParent().getParent());
	    	} else if(level.getText().contains("B")) {
	    		StackPane dolphin = FXMLLoader.load(getClass().getResource("ChooseChar3.fxml"));
	    		move(name.getParent(), dolphin, level, -1400, "C", name.getParent().getParent());
	    	} else if(level.getText().contains("C")) {
	    		StackPane mermaid = FXMLLoader.load(getClass().getResource("ChooseChar4.fxml"));
	    		move(name.getParent(), mermaid, level, -1400, "D", name.getParent().getParent());
	    		}
	    	} else if(event.getX() - X > 50 && done == false) {
		    	if(level.getText().contains("B")) {
		    		move(name.getParent(), octopus, level, 1400, "A", name.getParent().getParent());
		    	} else if(level.getText().contains("C")) {
		    		StackPane triton = FXMLLoader.load(getClass().getResource("ChooseChar2.fxml"));
		    		move(name.getParent(), triton, level, 1400, "B", name.getParent().getParent());
		    	} else if(level.getText().contains("D")) {
		    		StackPane dolphin = FXMLLoader.load(getClass().getResource("ChooseChar3.fxml"));
		    		move(name.getParent(), dolphin,level, 1400, "C", name.getParent().getParent());
		    	}
	    }
	    
    }
    
    @FXML
    private void loadMaze(MouseEvent event) throws IOException{
    	if(event.getClickCount() == 2) {
    		StackPane parentContainer = (StackPane) name.getParent().getParent();
    		parentContainer.getChildren().clear();
    		AnchorPane newscene = FXMLLoader.load(getClass().getResource("replay.fxml"));
    		parentContainer.getChildren().add(newscene);
    	}
    }
    @FXML
    private void move(Parent now1, StackPane next, Text level, int Xproperty, String set, Parent parentContainer1) {
    	done = true;
    	StackPane parentContainer = (StackPane) parentContainer1;
    	StackPane now = (StackPane) now1;
    	Scene scene = parentContainer.getScene();
    	if(Xproperty<0) {
    		next.translateXProperty().set(scene.getWidth());
    	} else {
    		next.translateXProperty().set(-scene.getWidth());
    	}

    	if(parentContainer.getChildren().contains(next) == false) {
    		parentContainer.getChildren().add(0, next);
    	}
        
    	System.out.println(level.getText());
    	
        if(level.getText().startsWith("6")) {
        	if(next.getId().equals("octopus") == false) {
        		System.out.println("lovely");
        		//next.setDisable(true);
            	ColorAdjust grayscale = new ColorAdjust();
            	grayscale.setSaturation(-0.5);
            	next.setEffect(grayscale);
        	}
        }

        Timeline timeline = new Timeline();
        KeyValue kv0 = new KeyValue(now.translateXProperty(), Xproperty, Interpolator.LINEAR);
		KeyFrame kf0 = new KeyFrame(Duration.seconds(1), kv0);
        KeyValue kv1 = new KeyValue(next.translateXProperty(), 0, Interpolator.LINEAR);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        KeyValue kv2 = new KeyValue(now.opacityProperty(), 0.0);
        KeyFrame kf2 = new KeyFrame(Duration.seconds(2), kv2);
        timeline.getKeyFrames().addAll(kf0, kf1, kf2);
        timeline.setOnFinished(t -> {
        	done = false;
        });
        level.setText(level.getText().substring(0, 1) + "" + set);
        timeline.play();
    }
}
