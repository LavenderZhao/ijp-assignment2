package controller;

import java.util.HashMap;
import java.util.Map.Entry;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

import model.Direction;
import model.Item;
import model.Location;
import model.World;

/**
 * This class contain all the 
 * @author xueqi zhao
 * @version 5.2
 */
public class WorldController {

	// show the image of the location
	@FXML
	private ImageView imageView;

	// show the image of picked item
	@FXML
	private ImageView item1View;
	@FXML
	private ImageView item2View;

	// show the image of item in the location
	@FXML
	private ImageView insideView1;
	@FXML
	private ImageView insideView2;

	// show the name of the location
	@FXML
	private Label locationLable;

	// the button used to move around the location
	@FXML
	private Button forwardButton;
	@FXML
	private Button leftButton;
	@FXML
	private Button rightButton;

	// menubutton used to pick and put item
	@FXML
	private MenuItem pickBasket;
	@FXML
	private MenuItem pickChocolate;
	@FXML
	private MenuItem putBasket;
	@FXML
	private MenuItem putChocolate;

	// storage the current location
	private Location currentLocation;
	// storage the current direction
	private String currentdirection = "north";
	// storage the carried item
	private HashMap<String, Item> carriedtitem = new HashMap<>();

	// create the direction object
	private Direction direction = new Direction();
	Item item1 = new Item("basket");
	Item item2 = new Item("chocolate");

	/**
	 * initialise the application
	 */
	public void Initialise() {

		// create the world object
		World world = new World();
		// initialise the world with all the location and item
		world.createLocation();
		world.createItem();

		// set the current location
		currentLocation = world.getCurrentLocation();

		// dispaly items on this location
		displayImage();

		putBasket.setVisible(false);
		putChocolate.setVisible(false);

		// show the name of this location
		locationLable.setText(currentLocation.getlocationName());
		// show the image of this location
		imageView.setImage(currentLocation.getImageMap(currentdirection));

	}

	/**
	 * Turn left method. turn left and show the new image
	 * 
	 * @param event
	 */
	public void leftButton(ActionEvent event) {

		// get the next direction
		currentdirection = direction.turnLeft(currentdirection);
		// show the new image
		imageView.setImage(currentLocation.getImageMap(currentdirection));
		// judge whether can move to next location
		isforward();
	}

	/**
	 * Turn right method. turn right and show the new image
	 * 
	 * @param event
	 */
	public void rightButton(ActionEvent event) {

		// get the next direction
		currentdirection = direction.turnRight(currentdirection);
		// show the new image
		imageView.setImage(currentLocation.getImageMap(currentdirection));
		// judge whether can move to next location
		isforward();
	}

	/**
	 * Move forward method.
	 * 
	 * @param event
	 */
	public void forwardButton(ActionEvent event) {

		// set currentlocation as next location
		currentLocation = currentLocation.getNextMap(currentdirection);
		// show the image
		Image image = currentLocation.getImageMap(currentdirection);
		imageView.setImage(image);
		// set the label
		locationLable.setText(currentLocation.getlocationName());

		// dispaly items on this location
		displayImage();

		// judge whether can move to next location
		isforward();

	}

	/**
	 * pick basket
	 * 
	 * @param event
	 */
	public void pickBasket(ActionEvent event) {

		item1 = currentLocation.getItem(item1.getName());
		carriedtitem.put(item1.getName(), item1);
		insideView1.setVisible(false);
		item1View.setImage(item1.getItemimage());
		item1View.setVisible(true);
		pickBasket.setVisible(false);
		putBasket.setVisible(true);
		currentLocation.removeItem(item1.getName());
	}

	public void pickChocolate(ActionEvent event) {

		item2 = currentLocation.getItem(item2.getName());
		carriedtitem.put(item2.getName(), item2);
		insideView2.setVisible(false);
		item2View.setImage(item2.getItemimage());
		item2View.setVisible(true);
		pickChocolate.setVisible(false);
		putChocolate.setVisible(true);
		currentLocation.removeItem(item2.getName());
	}

	public void putBasket(ActionEvent event) {
//		if (isInside1()) {
			insideView1.setVisible(true);
			item1View.setVisible(false);
			pickBasket.setVisible(true);
			putBasket.setVisible(false);
			currentLocation.setItemMap(item1.getName(), item1);
//		} else {
//			insideView2.setVisible(true);
//			item2View.setVisible(false);
//			pickBasket.setVisible(true);
//			putBasket.setVisible(false);
//			currentLocation.setItemMap(item1.getName(), item1);
//		}
		
	}

	public void putChocolate(ActionEvent event) {
//		if (isInside1()) {
//			insideView1.setVisible(true);
//			item1View.setVisible(false);
//			pickChocolate.setVisible(true);
//			putChocolate.setVisible(false);
//			currentLocation.setItemMap(item2.getName(), item2);
//		} else {
			insideView2.setVisible(true);
			item2View.setVisible(false);
			pickChocolate.setVisible(true);
			putChocolate.setVisible(false);
			currentLocation.setItemMap(item2.getName(), item2);
		//}
		
	}

	/**
	 * Judge whether can move forward.
	 */
	public void isforward() {

		// if do not have next location, means can not move forward,
		// then set the move forward button not visible
		if (currentLocation.getNextMap(currentdirection) == null) {
			forwardButton.setVisible(false);
		} else {
			forwardButton.setVisible(true);
		}
	}

	public void displayImage() {

		// Integer itemNumber = currentLocation.getItemNumber();
		HashMap<String, Item> itemmap = currentLocation.getItemMap();

		insideView1.setVisible(false);
		insideView2.setVisible(false);
		pickBasket.setVisible(false);
		pickChocolate.setVisible(false);

		for (Entry<String, Item> entry : itemmap.entrySet()) {
			if (entry.getKey().equals("house")) {
				insideView1.setImage(entry.getValue().getItemimage());
				insideView1.setVisible(true);
				pickBasket.setVisible(true);
			} else if (entry.getKey().equals("chocolate")) {
				insideView2.setImage(entry.getValue().getItemimage());
				insideView2.setVisible(true);
				pickChocolate.setVisible(true);
			}
		}
	}

	public Boolean isInside1() {
		if (currentLocation.getItemMap().size()>=1) {
			return true;
		}
		return false;
	}

	public boolean isCarryitem() {
		if(carriedtitem.size()>=1)
			return true;	
		return false;
		
	}

}