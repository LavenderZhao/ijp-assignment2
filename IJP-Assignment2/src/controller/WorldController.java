package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import model.Direction;
import model.Item;
import model.Location;
import model.World;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;

public class WorldController {

	@FXML
	private ImageView imageView;
	@FXML
	private ImageView item1View;
	@FXML
	private ImageView item2View;
	@FXML
	private ImageView insideView1;
	@FXML
	private ImageView insideView2;
	@FXML
	private Label locationLable;

	@FXML
	private Button forwardButton;
	@FXML
	private Button leftButton;
	@FXML
	private Button rightButton;

	@FXML
	private Menu pickMnue;
	@FXML
	private Menu putMnue;

	private Location currentLocation;
	private String currentdirection = "north";
	private Direction direction;
	private Item currentitem;

	public void Initialise() {
		World world = new World();
		world.createLocation();
		world.createItem();
		displayImage();
		currentLocation = world.getCurrentLocation();
		locationLable.setText(currentLocation.getlocationName());
		imageView.setImage(currentLocation.getImageMap(currentdirection));

	}

	public void leftButton(ActionEvent event) {

		currentdirection = turnLeft(currentdirection);

		Image image = currentLocation.getImageMap(currentdirection);
		imageView.setImage(image);
		isforward();
		locationLable.setText(currentLocation.getlocationName());
		displayImage();
	}

	public void rightButton(ActionEvent event) {

		currentdirection = turnRight(currentdirection);

		Image image = currentLocation.getImageMap(currentdirection);
		imageView.setImage(image);
		isforward();
		locationLable.setText(currentLocation.getlocationName());
		displayImage();
	}

	public void forwardButton(ActionEvent event) {

		currentLocation = currentLocation.getNextMap(currentdirection);
		System.out.println(currentLocation.getlocationName());
		isforward();
		Image image = currentLocation.getImageMap(currentdirection);
		System.out.println(currentdirection);
		imageView.setImage(image);
		locationLable.setText(currentLocation.getlocationName());
		displayImage();
	}

	public void isforward() {
		Location nextlocation;
		nextlocation = currentLocation.getNextMap(currentdirection);
		if (nextlocation == null) {
			forwardButton.setVisible(false);
		} else {
			forwardButton.setVisible(true);
		}
	}

	public void displayImage() {
		
		Integer itemNumber = 0;
		itemNumber = currentLocation.getItemNumber();
		for (int i = 0; i < itemNumber; i++) {
			if (itemNumber==1) {
				insideView1.setImage(currentLocation.getItemMap(itemNumber));
			} else {
				insideView2.setImage(currentLocation.getItemMap(itemNumber));
			}
			
		}
		
	}

	public String turnRight(String direction) {

		switch (direction) {
		case "north":
			return "east";
		case "east":
			return "south";
		case "south":
			return "west";
		case "west":
			return "north";
		}
		return null;
	}

	public String turnLeft(String direction) {

		switch (direction) {
		case "north":
			return "west";
		case "east":
			return "north";
		case "south":
			return "east";
		case "west":
			return "south";
		}
		return null;
	}
}
