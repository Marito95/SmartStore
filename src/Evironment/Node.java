package Evironment;

import java.util.ArrayList;

import Inventory.Location;

public class Node {
	
	private ArrayList<Node> neighbors;
	private ArrayList<Location> locations;
	private boolean isEntry;
	private boolean isExit;
	private int index;
	
	public Node(int index) {
		super();
		this.neighbors = new ArrayList<>();
		this.isEntry = false;
		this.isExit = false;
		this.index = index;
	}

	public ArrayList<Node> getNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor(Node n) {
		this.neighbors.add(n);
	}

	public ArrayList<Location> getLocations() {
		return locations;
	}

	public boolean isEntry() {
		return isEntry;
	}

	public void setEntry(boolean isEntry) {
		this.isEntry = isEntry;
	}

	public boolean isExit() {
		return isExit;
	}

	public void setExit(boolean isExit) {
		this.isExit = isExit;
	}

	public int getIndex() {
		return index;
	}

	public void setindex(int index) {
		this.index = index;
	}
	
}
