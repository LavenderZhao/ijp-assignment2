package controller;

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

	@FXML
	private Button pickButton;
	@FXML
	private Button putButton;
	@FXML
	private Button forwardButton;	
	@FXML
	private Button leftButton;
	@FXML
	private Button rightButton;

	// if the item is on, flag is true
	private boolean flag = false;
	private Image basket = new Image("basket.png");
	private location currentLocation;

	
	public void Initialise() {
		creatLocation();
		Image image = new Image("door.jpg");
		imageView.setImage(image);
		pickButton.setDisable(true);
	}

	public void putButton(ActionEvent event) {
		// if the item is not on the page, put the item on and set flag = true
		// and set visible = true.
		basketView.setImage(basket);

		basketView.setVisible(true);
		item1View.setVisible(false);
		// item.putItem();
		flag = true;
		pickButton.setDisable(false);
		putButton.setDisable(true);
	}

	public void pickButton(ActionEvent event) {
		if (flag) {
			basketView.setVisible(false);
			item1View.setImage(basket);
			item1View.setVisible(true);
			// item.pickItem();
			flag = false;
			putButton.setDisable(false);
			pickButton.setDisable(true);
		}
	}

	public void forwardButton(ActionEvent event) {
		//changeButton(location, index);
	}
	
	public location move(location location, int index) {
		location nextlocation;
		nextlocation = location.getNext(index);
		return nextlocation;
	}

	public void creatLocation() {
		location location0, location1, location2, location3, location4, location5;
		Image location0_1 = new Image("door.jpg");
		Image location1_1 = new Image("Location1_1.jpg");
		Image location1_2 = new Image("Location1_2.jpg");
		Image location1_3 = new Image("Location1_3.jpg");
		Image location1_4 = new Image("Location1_2.jpg");
		Image location2_1 = new Image("Location2_1.jpg");
		Image location2_2 = new Image("Location2_2.jpg");
		Image location2_3 = new Image("Location2_3.jpg");
		Image location2_4 = new Image("Location2_4.jpg");
		Image location3_1 = new Image("Location3_2.jpg");

		location0 = new location();
		location1 = new location("corridor");
		location2 = new location("room407");
		location3 = new location("room409");
		location4 = new location("fireexit");
		location5 = new location("room402");

		location0.setNextMap(1, location1);

		location1.setNextMap(2, location2);
		location1.setNextMap(3, location3);
		location1.setNextMap(4, location4);
		location1.setNextMap(5, location5);
		location1.setNextMap(0, location0);
		
		location2.setNextMap(1, location1);
		location3.setNextMap(1, location1);
		location4.setNextMap(1, location1);
		location5.setNextMap(1, location1);

		// put image into hashmap
		location0.setImageMap(0, location0_1);

		location1.setImageMap(1, location1_1);
		location1.setImageMap(2, location1_2);
		location1.setImageMap(3, location1_3);
		location1.setImageMap(4, location1_4);

		location2.setImageMap(1, location2_1);
		location2.setImageMap(2, location2_2);
		location2.setImageMap(3, location2_3);
		location2.setImageMap(4, location2_4);

	}

	/**
	 * change the ability of button
	 * 
	 */
	private void changeButton(location location, int index) {
		String LocationName = location.getLocationName();
		if (LocationName.equals("corridor")) {
			if (index == 3 || index == 5 || index == 7 || index == 8) {
				forwardButton.setDisable(false);
			} else {
				forwardButton.setDisable(true);
			}
		} else {
			if (index == 3) {
				forwardButton.setDisable(false);
			} else {
				forwardButton.setDisable(true);
			}
		}

	}
}
