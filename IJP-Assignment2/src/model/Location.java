package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javafx.scene.image.Image;

public class Location {
	
	private String locationName;
	private boolean flag; 	//judge is there an item in this location
	private Integer itemNumber = 0;
	
	private HashMap<Integer, Image> ItemMap = new HashMap<Integer, Image>();
		
	private HashMap<String, Location> NextMap = new HashMap<>();  //store locations
	private HashMap<String, Image> ImageMap = new  HashMap<>();	//store images
	
	

	public HashMap<Integer, Image> getItemMap() {
		//System.out.println(ImageMap);
		return ItemMap;
	}

	public Location() {
		// TODO Auto-generated constructor stub
		this.locationName = "door";
	}
	
	public Location(String locationName) {
		this.locationName = locationName;
		
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
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

	public void setItemMap(Integer Numer, Image image) {
		ItemMap.put(Numer,image);
		itemNumber++;
		System.out.println(itemNumber);
	}

	public Image getItemMap(Integer itemNumer) {
		//System.out.println(ItemMap);
		return ItemMap.get(itemNumer);
	}

	public Integer getItemNumber() {
		System.out.println("here");
		//System.out.println(itemNumber);
		return itemNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	

}
