package model;

import javafx.scene.image.Image;

public class Item {
	
	private Location location;
	
	private Image itemimage;
	
	private String name;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public Item(String name) {
		
		this.setName(name);
	}
	public Item(Location location, Image image, String name) {
		this.location = location;
		this.itemimage = image;
		this.setName(name);
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Image getItemimage() {
		return itemimage;
	}
	public void setItemimage(Image itemimage) {
		this.itemimage = itemimage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
