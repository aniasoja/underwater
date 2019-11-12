package adventure;

import java.io.IOException;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;


public class Scene1_Controller implements Initializable {

    @FXML
    private StackPane parentContainer;
    @FXML
    private AnchorPane anchorRoot1;
    @FXML
    private AnchorPane anchorRoot2;
    @FXML
    private AnchorPane anchorRoot3;
    @FXML
    private AnchorPane anchorRoot4;
    @FXML
    private AnchorPane anchorRoot5;
    @FXML
    private AnchorPane anchorRoot6;
    @FXML
    private ImageView leftArrow;
    @FXML
    private ImageView rightArrow;
    @FXML
    private Text text;
    @FXML
    private Text level;
    
    private double Y;
    boolean done;
    int a;
    Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    private void position(MouseEvent event) {
    	Node level2 = text.getParent().getParent().getChildrenUnmodifiable().get(3);
    	Text level = (Text) level2;
    	
    	if(level.getText() == "") {
    		level.setText("0");
    	}
    	
    	Y = event.getY();
    }

    @FXML
    private void loadNextText(MouseEvent event) throws IOException {
    	if(Y-event.getY()>100 && done == false) {
    		Node level2 = text.getParent().getParent().getChildrenUnmodifiable().get(text.getParent().getParent().getChildrenUnmodifiable().size()-1);
        	Text level = (Text) level2;
        	
    		if(level.getText().equals("0")) {
    			Parent root = FXMLLoader.load(getClass().getResource("FXML2.fxml"));
    			done = false;
    			loadStory(root, anchorRoot1, level);
    		}
    		else if(level.getText().equals("1")) {
    			Parent root = FXMLLoader.load(getClass().getResource("FXML3.fxml"));
    			done = false;
    			loadStory(root, anchorRoot2, level);
    		}
    		else if(level.getText().equals("2")) {
    			Parent root = FXMLLoader.load(getClass().getResource("FXML4.fxml"));
    			done = false;
    			loadStory(root, anchorRoot3, level);
    		}
    		else if(level.getText().equals("3")) {
    			Parent root = FXMLLoader.load(getClass().getResource("FXML5.fxml"));
    			done = false;
    			loadStory(root, anchorRoot4, level);
    		}
    		else if(level.getText().equals("4")) {
    			Parent root = FXMLLoader.load(getClass().getResource("FXML6.fxml"));
    			done = false;
    			loadStory(root, anchorRoot5, level);
    		}
    		else if(level.getText().equals("5")) {
    			done = true;
    			parentContainer = (StackPane) text.getParent().getParent();
    			parentContainer.getChildren().remove(1);
    			parentContainer.getChildren().remove(1);
	        	Parent root1 = FXMLLoader.load(getClass().getResource("ChooseChar1.fxml"));
	        	StackPane root = (StackPane) root1;
    			parentContainer.getChildren().addAll(0, root.getChildrenUnmodifiable());
    			
    	        Timeline timeline = new Timeline();
    	        KeyValue kv0 = new KeyValue(anchorRoot6.translateYProperty(), -400, Interpolator.LINEAR);
    			KeyFrame kf0 = new KeyFrame(Duration.seconds(2), kv0);
    			KeyValue kv2 = new KeyValue(anchorRoot6.opacityProperty(), 1.0, Interpolator.LINEAR);
    			KeyFrame kf2 = new KeyFrame(Duration.seconds(1), kv2);
    	        
    	        timeline.getKeyFrames().addAll(kf0, kf2);
    	        timeline.setOnFinished(t -> {
    	        	String b = level.getText();
    	        	a = Integer.parseInt(b) + 1;
    	        	b = String.valueOf(a);
    	        	level.setText(b);
    	        	BackgroundImage myBI= new BackgroundImage(
    	        			new Image("/UnderwaterAdventure/resources/bg2.png"),
    	        			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
    	        	parentContainer.setBackground(new Background(myBI));
    	        });
    	        timeline.play();
    	        parentContainer.getChildren().remove(anchorRoot6);
    	        done = true;
    		}
    	}
    }
    @FXML
    private void loadStory(Parent root, AnchorPane anchorRoot, Text level) {
    	parentContainer = (StackPane) text.getParent().getParent();
		Scene scene = anchorRoot.getScene();
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Chelsea+Market&display=swap");
		Node text2 = root.getChildrenUnmodifiable().get(0);
		Text text = (Text) text2;
		text.setStyle("-fx-font-family: 'Chelsea Market'; -fx-font-size: 20;");
		text.translateYProperty().set(scene.getHeight());

		parentContainer.getChildren().add(0, root);
		
        Timeline timeline = new Timeline();
        KeyValue kv0 = new KeyValue(anchorRoot.translateYProperty(), -400, Interpolator.LINEAR);
		KeyFrame kf0 = new KeyFrame(Duration.seconds(1), kv0);
        KeyValue kv1 = new KeyValue(text.translateYProperty(), 0, Interpolator.LINEAR);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().addAll(kf0, kf1);
        timeline.setOnFinished(t -> {
        	parentContainer.getChildren().remove(anchorRoot);
        	String b = level.getText();
        	a = Integer.parseInt(b) + 1;
        	b = String.valueOf(a);
        	level.setText(b);
        });
        timeline.play();
        done = true;
    }

}
