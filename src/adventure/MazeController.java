package adventure;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class MazeController {
	 @FXML
	 private StackPane parentContainer;
	 
	 double midX;
	 double midY;
	 
	 @FXML
	 private void position(MouseEvent event) {
	  	double X = event.getX();
	   	double Y = event.getY();
	   	if(X-midX > 0) {
	   		//move one direction
	   	}
	   	else if (X - midX < 0) {
	   		//move another
	   	}
	   	if(Y - midY > 0) {
	   		//aaa
	   	}
	   	else if (X - midX < 0) {
	   		//bbb
	   	}
	   	
	 }

}
