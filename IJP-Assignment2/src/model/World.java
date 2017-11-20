package model;

import java.net.URL;

import javafx.scene.image.Image;

/**
 * This class is used to initialise all the location and item
 * @author xueqi zhao
 * @version 3.2
 */
public class World {
	
	//storage current location
	private Location currentLocation;
	
	//create locations
	private Location  location1, location6, location2, location3, location5, location7;
	
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
		
		
		location1 = new Location("corridor1");
		location6 = new Location("corridor2");
		location7 = new Location("corridor3");
		location2 = new Location("room407");
		location3 = new Location("room409");
		location5 = new Location("room412");
		
		
		
		//Image location3_1 = new Image("Location3_2.jpg");

		
		location1 = new Location("corridor1");
		
		
		// put image into hashmap
		
		createLocation1();
		createLocation2();
		createLocation3();
		createLocation5();
		createLocation6();
		createLocation7();
		
		
		//Initialize the current location.
		currentLocation = location1;

	}
	public void createLocation1() {
		
		URL url1 = this.getClass().getResource("/resources/1_1.jpg");
		URL url2 = this.getClass().getResource("/resources/1_2.jpg");
		URL url3 = this.getClass().getResource("/resources/1_3.jpg");
		URL url4 = this.getClass().getResource("/resources/1_4.jpg");
		Image location111 = new Image(url1.toString());
		Image location112 = new Image(url2.toString());
		Image location113 = new Image(url3.toString());
		Image location114 = new Image(url4.toString());
		
		location1.setImageMap("north", location111);
		location1.setImageMap("east", location112);
		location1.setImageMap("south", location113);
		location1.setImageMap("west", location114);
		
		
		location1.setNextMap("east", location2);
		location1.setNextMap("north", location6);	
		
	}
	public void createLocation6() {
		
		URL url1 = this.getClass().getResource("/resources/6_1.jpg");
		URL url2 = this.getClass().getResource("/resources/6_2.jpg");
		URL url3 = this.getClass().getResource("/resources/6_3.jpg");
		URL url4 = this.getClass().getResource("/resources/6_4.jpg");
		Image location121 = new Image(url1.toString());
		Image location122 = new Image(url2.toString());
		Image location123 = new Image(url3.toString());
		Image location124 = new Image(url4.toString());
		
		
		location6.setImageMap("north", location121);
		location6.setImageMap("east", location122);
		location6.setImageMap("south", location123);
		location6.setImageMap("west", location124);
		
		location6.setNextMap("south", location1);	
		location6.setNextMap("east", location3);
		location6.setNextMap("west", location7);
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
		
		location3.setNextMap("west", location6);
	}
	
	public void createLocation5() {
		
		
		URL url1 = this.getClass().getResource("/resources/5_1.jpg");
		URL url2 = this.getClass().getResource("/resources/5_2.jpg");
		URL url3 = this.getClass().getResource("/resources/5_3.jpg");
		URL url4 = this.getClass().getResource("/resources/5_4.jpg");
		Image location51 = new Image(url1.toString());
		Image location52 = new Image(url2.toString());
		Image location53 = new Image(url3.toString());
		Image location54 = new Image(url4.toString());
		
		location5.setImageMap("north", location51);
		location5.setImageMap("east", location52);
		location5.setImageMap("south", location53);
		location5.setImageMap("west", location54);
		
		location5.setNextMap("north", location7);
	}
	
	public void createLocation7() {
		
		
		URL url1 = this.getClass().getResource("/resources/7_1.jpg");
		URL url2 = this.getClass().getResource("/resources/7_2.jpg");
		URL url3 = this.getClass().getResource("/resources/7_3.jpg");
		URL url4 = this.getClass().getResource("/resources/7_4.jpg");
		Image location71 = new Image(url1.toString());
		Image location72 = new Image(url2.toString());
		Image location73 = new Image(url3.toString());
		Image location74 = new Image(url4.toString());
		
		location7.setImageMap("north", location71);
		location7.setImageMap("east", location72);
		location7.setImageMap("south", location73);
		location7.setImageMap("west", location74);
		
		location7.setNextMap("south", location5);	
		location7.setNextMap("east", location6);
	}
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
