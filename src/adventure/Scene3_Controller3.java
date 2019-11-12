package adventure;

import java.io.IOException;
import javafx.scene.shape.Circle;
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
    private Circle a;
    @FXML
    private Circle b;
    @FXML
    private Circle c;
    @FXML
    private Circle d;
    @FXML
    private Circle main;

	private double X;
	private double Y;
	
	boolean check1 = false;
	boolean check2;
	boolean check3;
	boolean check4;
	/*
	 * 212.0 218.0
	 * 236.0 109.0
	 * 351.0 111.0
	 * 381.0 200.0
	 */
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void position(MouseEvent event) {
    	X = event.getX();
    	Y = event.getY();
    	
    	if(X < 150 || X > 450) {
    		if(Y < 55 || Y > 300) {
    			check1 = false;
    			check2 = false;
    			check3 = false;
    			check4 = false;
    			System.out.println("all gone");
    		}
    	}
    	if(check1 == false) {
        	if(X > 190.0 && X < 234 &&Y > 195 && Y < 240) {
        		check1 = true;
            	check2 = false;
            	System.out.print("1");
        	}
    	} else if(check2 == false) {
        	if(X > 210 && X < 260 && Y > 85 && Y < 135) {
        		check2 = true;
        		check3 = false;
        		System.out.print("2");
        	}
        } else if (check3 == false) {
        	if(X > 325 && X < 375 && Y > 90 && Y < 135) {
        		check3 = true;
        		check4 = false;
        		System.out.print("3");
        	}
    	} else if(check4 == false) {
    		if(X > 355 && X < 405 && Y > 175 && Y < 225) {
    			check4 = true;
    			System.out.print("4");
    		}
    	}
    }
    @FXML
    private void over(MouseEvent event) {
    	System.out.println("woeking");
    	if(check1 == true && check2 == true && check3 == true && check4 == true) {
    		System.out.print("ready!");
    		check1 = false;
			check2 = false;
			check3 = false;
			check4 = false;
    	} else {
    		check1 = false;
			check2 = false;
			check3 = false;
			check4 = false;
			System.out.println("again");
    	}
    }
    
}
