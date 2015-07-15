package com.ai.component;


import java.awt.Color;

import com.ai.main.Main;
import com.ai.main.StdDraw;

public class Node {
	
	private int x, y;
	private String nodeChar;
	private Node parent;
	public Node next;
	private int cost=0;
	private int hCost;
	
	public Node(int y, int x, char charAt) {
		this.x = x;
		this.y = y;
		nodeChar = charAt +"";
	}
	public Node() {
	}
    
    public Node (Node n){
    	this.parent=n.getParent();
    	this.cost=n.getCost();
    	this.hCost=n.gethCost();
    	this.nodeChar=n.getNodeChar();
    	this.x=n.getX();
    	this.y=n.getY();
    	this.next=null;
    }
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getNodeChar() {
		return nodeChar;
	}
	public void setNodeChar(String nodeChar) {
		this.nodeChar = nodeChar;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int gethCost() {
		return hCost;
	}
	public void sethCost(int hCost) {	//in this method we can change whether to use an admissible or a non-admissible heuristic
		this.hCost = hCost;
	}
	public void moveRobot(Color color) {
		StdDraw.setPenColor(color);
		StdDraw.filledRectangle((2 * (this.x) + 1) * 1.0 / (2 * (Main.xSize+1)), 1.0
				- (2 * (this.y) + 1) * 1.0 / (2 * (Main.ySize+1)), 1.0 / (2 * (Main.xSize+1)),
				1.0 / (2 * (Main.ySize+1)));		
	}
	
	
	public void EraseCurrentPosition() {
		StdDraw.setPenColor(Color.white);
		StdDraw.filledRectangle((2 * (this.x) + 1) * 1.0 / (2 * (Main.xSize+1)), 1.0
				- (2 * (this.y) + 1) * 1.0 / (2 * (Main.ySize+1)), 0.9 / (2 * (Main.xSize+1)),
				0.9 / (2 * (Main.ySize+1)));

	}

}
