package model;

import javafx.scene.image.Image;

public class World {
	
	private Location currentLocation;
	
	private Location  location1, location6, location2, location3, location4, location5;
	
	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public void createLocation() {
		
		
		location1 = new Location("corridor1");
		location6 = new Location("corridor2");
		location2 = new Location("room407");
		location3 = new Location("room409");
		location4 = new Location("fireexit");
		location5 = new Location("room412");
		
		
		
		//Image location3_1 = new Image("Location3_2.jpg");

		
		location1 = new Location("corridor1");
		
		
		// put image into hashmap
		
		createLocation1();
		createLocation2();
		createLocation3();
		createLocation4();
		createLocation5();
		createLocation6();
		
		
		
		//Initialize the current location.
		currentLocation = location1;

	}
	public void createLocation1() {
		
		
		Image location111 = new Image("Location1_1_1.jpg");
		Image location112 = new Image("Location1_1_2.jpg");
		Image location113 = new Image("Location1_1_3.jpg");
		Image location114 = new Image("Location1_1_4.jpg");
		
		location1.setImageMap("north", location111);
		location1.setImageMap("east", location112);
		location1.setImageMap("south", location113);
		location1.setImageMap("west", location114);
		
		
		location1.setNextMap("east", location2);
		location1.setNextMap("north", location6);	
		
	}
	public void createLocation6() {
		
		
		Image location121 = new Image("Location1_2_1.jpg");
		Image location122 = new Image("Location1_2_2.jpg");
		Image location123 = new Image("Location1_2_3.jpg");
		Image location124 = new Image("Location1_2_4.jpg");
		
		location6.setImageMap("north", location121);
		location6.setImageMap("east", location122);
		location6.setImageMap("south", location123);
		location6.setImageMap("west", location124);
		
		location6.setNextMap("south", location1);
		location6.setNextMap("north", location4);
		location6.setNextMap("east", location3);
		location6.setNextMap("west", location5);
	}
	public void createLocation2() {
		
		
		Image location21 = new Image("Location2_1.jpg");
		Image location22 = new Image("Location2_2.jpg");
		Image location23 = new Image("Location2_3.jpg");
		Image location24 = new Image("Location2_4.jpg");
		
		location2.setImageMap("north", location21);
		location2.setImageMap("east", location22);
		location2.setImageMap("south", location23);
		location2.setImageMap("west", location24);
		
		location2.setNextMap("west", location1);
	}
	public void createLocation3() {
		
		
		Image location111 = new Image("Location1_1_1.jpg");
		Image location112 = new Image("Location1_1_2.jpg");
		Image location113 = new Image("Location1_1_3.jpg");
		Image location114 = new Image("Location1_1_4.jpg");
		
		location3.setImageMap("north", location111);
		location3.setImageMap("east", location112);
		location3.setImageMap("south", location113);
		location3.setImageMap("west", location114);
		
		location3.setNextMap("west", location6);
	}
	public void createLocation4() {
		
		
		Image location111 = new Image("Location1_1_1.jpg");
		Image location112 = new Image("Location1_1_2.jpg");
		Image location113 = new Image("Location1_1_3.jpg");
		Image location114 = new Image("Location1_1_4.jpg");
		
		location4.setImageMap("north", location111);
		location4.setImageMap("east", location112);
		location4.setImageMap("south", location113);
		location4.setImageMap("west", location114);
		
		location4.setNextMap("south", location6);
	}
	public void createLocation5() {
		
		
		Image location111 = new Image("Location1_1_1.jpg");
		Image location112 = new Image("Location1_1_2.jpg");
		Image location113 = new Image("Location1_1_3.jpg");
		Image location114 = new Image("Location1_1_4.jpg");
		
		location5.setImageMap("north", location111);
		location5.setImageMap("east", location112);
		location5.setImageMap("south", location113);
		location5.setImageMap("west", location114);
		
		location5.setNextMap("east", location6);
	}
	
	
	public void createItem() {
		
		
		Image itemimage1 = new Image("basket.png");
		Image itemimage2 = new Image("chocolate.png");
		Item item1 = new Item();
		Item item2 = new Item();
		
		item1.setItemimage(itemimage1);
		item1.setLocation(location1);
		item2.setItemimage(itemimage2);
		item2.setLocation(location3);
		
		location1.setItemMap(1, itemimage1);
		location3.setItemMap(1, itemimage2);
		//System.out.println(location1.getItemNumber());
	}
	
}
