package model;
import java.util.HashMap;

import javafx.scene.image.Image;

public class location {
	private String LocationName;
	private HashMap<Integer, location> NextMap;  //store locations
	private HashMap<Integer, Image> ImageMap;	//store images
	
	public location() {
		// TODO Auto-generated constructor stub
		this.LocationName = "door";
	}
	
	public location(String LocationName) {
		this.LocationName = LocationName;
	}
	
	public String getLocationName() {
		return LocationName;
	}

	public void setLocationName(String locationName) {
		LocationName = locationName;
	}

	
	public void setImageMap(Integer index, Image image) {
		ImageMap.put(index, image);
	}

	public Image getImage(Integer index) {
		return ImageMap.get(index);
	}
	
	
	
	public void setNextMap(Integer index, location location) {
		NextMap.put(index, location);
	}
	
	public location getNext(Integer index) {
		return NextMap.get(index);
	}
	
	

}
