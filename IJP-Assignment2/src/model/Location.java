package model;

import java.util.HashMap;

import javafx.scene.image.Image;

public class Location {

	private String locationName;

	private HashMap<String, Item> ItemMap = new HashMap<String, Item>();

	private HashMap<String, Location> NextMap = new HashMap<>(); // store locations
	private HashMap<String, Image> ImageMap = new HashMap<>(); // store images

	public HashMap<String, Item> getItemMap() {
		// System.out.println(ImageMap);
		return ItemMap;
	}

	public Location() {
		// TODO Auto-generated constructor stub
		// this.locationName = "door";
	}

	public Location(String locationName) {
		this.locationName = locationName;

	}


	public String getlocationName() {
		return locationName;
	}

	public void setlocationName(String locationName) {
		this.locationName = locationName;
	}

	public void setImageMap(String direction, Image image) {
		ImageMap.put(direction, image);
	}

	public Image getImageMap(String direction) {
		return ImageMap.get(direction);
	}

	public void setNextMap(String direction, Location Location) {
		NextMap.put(direction, Location);
	}

	public Location getNextMap(String direction) {
		return NextMap.get(direction);
	}

	public void setItemMap(String name, Item item) {
		ItemMap.put(name, item);
	}

	public Item getItem(String itemName) {
		return ItemMap.get(itemName);
	}

	public void removeItem(String itemName) {
		ItemMap.remove(itemName);
	}


}
