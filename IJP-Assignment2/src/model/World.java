package model;

import java.net.URL;

import javafx.scene.image.Image;

/**
 * Initialises all the location and item
 * @author xueqi zhao
 * @version 3.2
 */
public class World {
	
	//storage current location
	private Location currentLocation;
	
	//create locations
	private Location  location1, location5, location2, location3, location4, location6;
	
	/**
	 * Return current location
	 * @return currentlocation
	 */
	public Location getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * 
	 */
	public void createLocation() {
		
		//initialize locations with name
		location1 = new Location("corridor1");
		location5 = new Location("corridor2");
		location6 = new Location("corridor3");
		location2 = new Location("room407");
		location3 = new Location("room409");
		location4 = new Location("room412");
		
		//initialize each location
		createLocation1();
		createLocation2();
		createLocation3();
		createlocation4();
		createlocation5();
		createlocation6();
		
		
		//Initialize the current location.
		currentLocation = location1;

	}
	
	public void createLocation1() {
		
		//initialize images of each direction
		URL url1 = this.getClass().getResource("/resources/1_1.jpg");
		URL url2 = this.getClass().getResource("/resources/1_2.jpg");
		URL url3 = this.getClass().getResource("/resources/1_3.jpg");
		URL url4 = this.getClass().getResource("/resources/1_4.jpg");
		Image location111 = new Image(url1.toString());
		Image location112 = new Image(url2.toString());
		Image location113 = new Image(url3.toString());
		Image location114 = new Image(url4.toString());
		
		// put image into hashmap
		location1.setImageMap("north", location111);
		location1.setImageMap("east", location112);
		location1.setImageMap("south", location113);
		location1.setImageMap("west", location114);
		
		//put next location into hashmap
		location1.setNextMap("east", location2);
		location1.setNextMap("north", location5);	
		
	}
	public void createlocation5() {
		
		URL url1 = this.getClass().getResource("/resources/5_1.jpg");
		URL url2 = this.getClass().getResource("/resources/5_2.jpg");
		URL url3 = this.getClass().getResource("/resources/5_3.jpg");
		URL url4 = this.getClass().getResource("/resources/5_4.jpg");
		Image location121 = new Image(url1.toString());
		Image location122 = new Image(url2.toString());
		Image location123 = new Image(url3.toString());
		Image location124 = new Image(url4.toString());
		
		
		location5.setImageMap("north", location121);
		location5.setImageMap("east", location122);
		location5.setImageMap("south", location123);
		location5.setImageMap("west", location124);
		
		location5.setNextMap("south", location1);	
		location5.setNextMap("east", location3);
		location5.setNextMap("west", location6);
	}
	public void createLocation2() {
		
		
		URL url1 = this.getClass().getResource("/resources/2_1.jpg");
		URL url2 = this.getClass().getResource("/resources/2_2.jpg");
		URL url3 = this.getClass().getResource("/resources/2_3.jpg");
		URL url4 = this.getClass().getResource("/resources/2_4.jpg");
		Image location21 = new Image(url1.toString());
		Image location22 = new Image(url2.toString());
		Image location23 = new Image(url3.toString());
		Image location24 = new Image(url4.toString());
		
		location2.setImageMap("north", location21);
		location2.setImageMap("east", location22);
		location2.setImageMap("south", location23);
		location2.setImageMap("west", location24);
		
		location2.setNextMap("west", location1);
	}
	public void createLocation3() {
		
		
		URL url1 = this.getClass().getResource("/resources/3_1.jpg");
		URL url2 = this.getClass().getResource("/resources/3_2.jpg");
		URL url3 = this.getClass().getResource("/resources/3_3.jpg");
		URL url4 = this.getClass().getResource("/resources/3_4.jpg");
		Image location31 = new Image(url1.toString());
		Image location32 = new Image(url2.toString());
		Image location33 = new Image(url3.toString());
		Image location34 = new Image(url4.toString());
		
		location3.setImageMap("north", location31);
		location3.setImageMap("east", location32);
		location3.setImageMap("south", location33);
		location3.setImageMap("west", location34);
		
		location3.setNextMap("west", location5);
	}
	
	public void createlocation4() {
		
		
		URL url1 = this.getClass().getResource("/resources/4_1.jpg");
		URL url2 = this.getClass().getResource("/resources/4_2.jpg");
		URL url3 = this.getClass().getResource("/resources/4_3.jpg");
		URL url4 = this.getClass().getResource("/resources/4_4.jpg");
		Image location41 = new Image(url1.toString());
		Image location42 = new Image(url2.toString());
		Image location43 = new Image(url3.toString());
		Image location44 = new Image(url4.toString());
		
		location4.setImageMap("north", location41);
		location4.setImageMap("east", location42);
		location4.setImageMap("south", location43);
		location4.setImageMap("west", location44);
		
		location4.setNextMap("north", location6);
	}
	
	public void createlocation6() {
		
		
		URL url1 = this.getClass().getResource("/resources/6_1.jpg");
		URL url2 = this.getClass().getResource("/resources/6_2.jpg");
		URL url3 = this.getClass().getResource("/resources/6_3.jpg");
		URL url4 = this.getClass().getResource("/resources/6_4.jpg");
		Image location61 = new Image(url1.toString());
		Image location62 = new Image(url2.toString());
		Image location63 = new Image(url3.toString());
		Image location64 = new Image(url4.toString());
		
		location6.setImageMap("north", location61);
		location6.setImageMap("east", location62);
		location6.setImageMap("south", location63);
		location6.setImageMap("west", location64);
		
		location6.setNextMap("south", location4);	
		location6.setNextMap("east", location5);
	}
	
	/**
	 * initialize items.
	 * create items and put them in initial location
	 */
	public void createItem() {
		
		URL url1 = this.getClass().getResource("/resources/house.png");
		URL url2 = this.getClass().getResource("/resources/chocolate.png");
		Image itemimage1 = new Image(url1.toString());
		Image itemimage2 = new Image(url2.toString());
		Item item1 = new Item(location1, itemimage1, "house");
		Item item2 = new Item(location1,itemimage2,"chocolate");
		
		
		location1.setItemMap(item1.getName(), item1);
		location3.setItemMap(item2.getName(), item2);
		//System.out.println(location1.getItemNumber());
		
	}
	
}
