
import java.util.HashMap;

import javax.xml.ws.AsyncHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import model.location;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class WorldController {

	@FXML
	private ImageView imageView;
	@FXML
	private ImageView item1View;
	@FXML
	private ImageView basketView;

//	@FXML
//	private Button pickButton;
//	@FXML
//	private Button putButton;
	@FXML
	private Button forwardButton;
	@FXML
	private Button leftButton;
	@FXML
	private Button rightButton;


	private location currentLocation;
	private Integer Imageindex = 1;

	public void Initialise() {
		//creatLocation();
		Image image = new Image("door.jpg");
		imageView.setImage(image);
		
	}

	public void leftButton(ActionEvent event) {
		if (Imageindex < 4) {
			Imageindex += 3;
			Imageindex = Imageindex % 4;
		} else {
			Imageindex -= 1;
		}
		Image image = currentLocation.getImage(Imageindex);
		imageView.setImage(image);
	}
	
	public void rightButton(ActionEvent event) {
		Imageindex += 1;
		Imageindex = Imageindex % 4;
		Image image = currentLocation.getImage(Imageindex);
		imageView.setImage(image);
	}

	public void forwardButton(ActionEvent event) {
		// changeButton(location, index);
		currentLocation = move();
		Imageindex = 1;
		Image image = currentLocation.getImage(1);
		imageView.setImage(image);
	}
	
	public void isforward() {
		boolean flag;
		location nextlocation;
		nextlocation = currentLocation.getNext(Imageindex);
		if (nextlocation == null) {
			forwardButton.setVisible(false);
		} else {
			forwardButton.setVisible(true);
		}
	}

	public location move() {
		location nextlocation;
		nextlocation = currentLocation.getNext(Imageindex);
		return nextlocation;
	}

	public void creatLocation() {
		location location0, location1_1, location1_2, location2, location3, location4, location5;
		Image location0_1 = new Image("door.jpg");
		Image location1_1_1 = new Image("Location1_1_1.jpg");
		Image location1_1_2 = new Image("Location1_1_2.jpg");
		Image location1_1_3 = new Image("Location1_1_2.jpg");
		Image location1_1_4 = new Image("Location1_1_4.jpg");
		Image location2_1 = new Image("Location2_1.jpg");
		Image location2_2 = new Image("Location2_2.jpg");
		Image location2_3 = new Image("Location2_3.jpg");
		Image location2_4 = new Image("Location2_4.jpg");
		Image location3_1 = new Image("Location3_2.jpg");

		location0 = new location();
		location1_1 = new location("corridor1");
		location1_2 = new location("corridor2");
		location2 = new location("room407");
		location3 = new location("room409");
		location4 = new location("fireexit");
		location5 = new location("room412");

		location0.setNextMap(1, location1_1);

		location1_1.setNextMap(2, location2);
		location1_1.setNextMap(1, location1_2);	
		location1_1.setNextMap(0, location0);
		
		location1_2.setNextMap(3, location3);
		location1_2.setNextMap(2, location4);
		location1_2.setNextMap(1, location5);

		location2.setNextMap(1, location1_1);
		location3.setNextMap(1, location1_1);
		location4.setNextMap(6, location1_2);
		location5.setNextMap(6, location1_2);

		// put image into hashmap
		location0.setImageMap(0, location0_1);

		location1_1.setImageMap(1, location1_1_1);
		location1_1.setImageMap(2, location1_1_2);
		location1_1.setImageMap(3, location1_1_3);
		location1_1.setImageMap(4, location1_1_4);

		location2.setImageMap(1, location2_1);
		location2.setImageMap(2, location2_2);
		location2.setImageMap(3, location2_3);
		location2.setImageMap(4, location2_4);
		
		
		currentLocation = location0;

	}


}
