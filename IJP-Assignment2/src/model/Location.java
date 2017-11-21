package model;

import java.util.HashMap;

import javafx.scene.image.Image;

public class Location {

	//storage loation name
	private String locationName;

	//storage item in this location
	private HashMap<String, Item> ItemMap = new HashMap<String, Item>();

	//storage next location with direction
	private HashMap<String, Location> NextMap = new HashMap<>(); 
	//storage image of each direction
	private HashMap<String, Image> ImageMap = new HashMap<>(); 

	/**
	 * Return item's hashmap
	 * @return itemmap
	 */
	public HashMap<String, Item> getItemMap() {
		return ItemMap;
	}
	/**
	 * initial the location with location name
	 * @param locationName
	 */
	public Location(String locationName) {
		this.locationName = locationName;

	}

	/**
	 * gets location name
	 * @return locationName
	 */
	public String getlocationName() {
		return locationName;
	}

	/**
	 * 
	 * @param locationName
	 */
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
