package model;

import java.util.HashMap;

public class Direction {
	
	private HashMap<String, String> rightDirectionMap = new HashMap<>();
	private HashMap<String, String> leftDirectionMap = new HashMap<>();
	
	public void setMap() {
		rightDirectionMap.put("north", "east");
		rightDirectionMap.put("east", "south");
		rightDirectionMap.put("south", "west");
		rightDirectionMap.put("west", "north");
		
		leftDirectionMap.put("north", "west");
		leftDirectionMap.put("west", "south");
		leftDirectionMap.put("south", "east");
		leftDirectionMap.put("east", "north");
		
	}
	public String turnRight(String direction) {
		setMap();
		return rightDirectionMap.get(direction);
	}
	
	public String turnLeft(String direction) {
		setMap();
		return leftDirectionMap.get(direction);
	}
	
}
