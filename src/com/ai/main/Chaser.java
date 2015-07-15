package com.ai.main;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import com.ai.component.MyList;
import com.ai.component.Node;

public class Chaser {
	
	Set<String> setOpenClosed;
	MyList closed;
	MyList open;

	public void moveR2() {
		setOpenClosed = new HashSet<String>();
		closed = new MyList();
		open = new MyList();
		open.insertSort(Main.robot2);
		Main.open_count++;
		setOpenClosed.add(Main.robot2.getX()+" "+Main.robot2.getY());
		
		while(!open.isEmpty()){
			Node node = open.first;
			open.removeFirst();
			closed.insert(node);
			Main.closed_count++;
			if(node.getX() == Main.robot1.getX() && node.getY() == Main.robot1.getY()){
				changeR2position();
				return;
			}
			if(node.getX()-1>=0 && !Main.nodes[node.getY()][node.getX()-1].getNodeChar().equals("X") ){
				if (!setOpenClosed.contains((node.getX()-1)+" "+node.getY())){
				Node g1 = Main.nodes[node.getY()][node.getX()-1];
				g1.setParent(node);
				g1.setCost(node.getCost()+1);
				g1.sethCost(Math.abs(g1.getX() - Main.robot1.getX())+ Math.abs(g1.getY() - Main.robot1.getY()));
				open.insertSort(g1);
				Main.open_count++;
				setOpenClosed.add(g1.getX()+" "+g1.getY());
				}else{
					if (node.getCost()+1<Main.nodes[node.getY()][node.getX()-1].getCost()){
						Node g1 = Main.nodes[node.getY()][node.getX()-1];
						g1.setParent(node);
						g1.setCost(node.getCost()+1);
						g1.sethCost(Math.abs(g1.getX() - Main.robot1.getX())+ Math.abs(g1.getY() - Main.robot1.getY()));
						open.insertSort(g1);
					}
				}
			}
			if(node.getX()+1<=Main.xSize && !Main.nodes[node.getY()][node.getX()+1].getNodeChar().equals("X") ){
				if (!setOpenClosed.contains((node.getX()+1)+" "+node.getY())){
				Node g2 = Main.nodes[node.getY()][node.getX()+1];
				g2.setParent(node);
				g2.setCost(node.getCost()+1);
				g2.sethCost(Math.abs(g2.getX() - Main.robot1.getX())+ Math.abs(g2.getY() - Main.robot1.getY()));
				open.insertSort(g2);
				Main.open_count++;
				setOpenClosed.add(g2.getX()+" "+g2.getY());
				}else{
				 if (node.getCost()+1<Main.nodes[node.getY()][node.getX()+1].getCost()){
					Node g2 = Main.nodes[node.getY()][node.getX()+1];
					g2.setParent(node);
					g2.setCost(node.getCost()+1);
					g2.sethCost(Math.abs(g2.getX() - Main.robot1.getX())+ Math.abs(g2.getY() - Main.robot1.getY()));
					open.insertSort(g2);
				}
			}
			}
			if(node.getY()-1>=0 && !Main.nodes[node.getY()-1][node.getX()].getNodeChar().equals("X") ){
				if (!setOpenClosed.contains(node.getX()+" "+(node.getY()-1))){
				Node g3 = Main.nodes[node.getY()-1][node.getX()];
				g3.setParent(node);
				g3.setCost(node.getCost()+1);
				g3.sethCost(Math.abs(g3.getX() - Main.robot1.getX())+ Math.abs(g3.getY() - Main.robot1.getY()));
				open.insertSort(g3);
				Main.open_count++;
				setOpenClosed.add(g3.getX()+" "+g3.getY());
				}else{
				if (node.getCost()+1<Main.nodes[node.getY()-1][node.getX()].getCost()){
					Node g3 = Main.nodes[node.getY()-1][node.getX()];
					g3.setParent(node);
					g3.setCost(node.getCost()+1);
					g3.sethCost(Math.abs(g3.getX() - Main.robot1.getX())+ Math.abs(g3.getY() - Main.robot1.getY()));
					open.insertSort(g3);
				}
			}
			}
			if(node.getY()+1<=Main.ySize && !Main.nodes[node.getY()+1][node.getX()].getNodeChar().equals("X")){
				if(!setOpenClosed.contains(node.getX()+" "+(node.getY()+1))){
				Node g4 = Main.nodes[node.getY()+1][node.getX()];
				g4.setParent(node);
				g4.setCost(node.getCost()+1);
				g4.sethCost(Math.abs(g4.getX() - Main.robot1.getX())+ Math.abs(g4.getY() - Main.robot1.getY()));
				open.insertSort(g4);
				Main.open_count++;
				setOpenClosed.add(g4.getX()+" "+g4.getY());
				}else{
				if(node.getCost()+1<Main.nodes[node.getY()+1][node.getX()].getCost()){
					Node g4 = Main.nodes[node.getY()+1][node.getX()];
					g4.setParent(node);
					g4.setCost(node.getCost()+1);
					g4.sethCost(Math.abs(g4.getX() - Main.robot1.getX())+ Math.abs(g4.getY() - Main.robot1.getY()));
					open.insertSort(g4);
				}
			}
			}
		}
	}

	private void changeR2position() {
		Node node = Main.nodes[Main.robot1.getY()][Main.robot1.getX()];
		Node r2 = Main.robot2;
		Boolean flag = false;
		while(!flag){
			if(node.getParent().getX() == r2.getX() && node.getParent().getY() == r2.getY()){
				flag=true;
				Main.nodes[r2.getY()][r2.getX()].setNodeChar("*");
				Main.nodes[node.getY()][node.getX()].setNodeChar("2");
				r2.EraseCurrentPosition();
				r2.setX(node.getX());
				r2.setY(node.getY());
				r2.setCost(node.getCost());
				r2.moveRobot(Color.green); 
				
			}else if(node.getParent().getParent().getX() == r2.getX() && node.getParent().getParent().getY() == r2.getY()){
				flag=true;
				Main.nodes[r2.getY()][r2.getX()].setNodeChar("*");
				Main.nodes[node.getParent().getY()][node.getParent().getX()].setNodeChar("*");	
				Main.nodes[node.getY()][node.getX()].setNodeChar("2");
				r2.EraseCurrentPosition();
				r2.setX(node.getX());
				r2.setY(node.getY());
				r2.setCost(node.getCost());
				Node gialigo=Main.nodes[node.getParent().getY()][node.getParent().getX()];
				gialigo.moveRobot(Color.green);
				gialigo.EraseCurrentPosition();
				r2.moveRobot(Color.green);
				r2.moveRobot(Color.green); 
			}else{
				node = node.getParent();
			}
		}
		
	}

	public void moveR1() {
		
		Node r1 = Main.robot1;
		Node r2 = Main.robot2;
		double apostasi = Math.abs(r1.getX() - r2.getX())+ Math.abs(r1.getY() - r2.getY());
		double tempApostasi;
		int x= r1.getX();
		int y = r1.getY();
		
		if(r1.getX()-1>=0 && !Main.nodes[r1.getY()][r1.getX()-1].getNodeChar().equals("X")){
			tempApostasi = Math.abs(r1.getX()-1 - r2.getX())+ Math.abs(r1.getY() - r2.getY());
			if(tempApostasi>apostasi){
				apostasi = tempApostasi;
				x = r1.getX()-1;
				y = r1.getY();
			}
		}
		if(r1.getX()+1<=Main.xSize && !Main.nodes[r1.getY()][r1.getX()+1].getNodeChar().equals("X")){
			tempApostasi = Math.abs(r1.getX()+1 - r2.getX())+ Math.abs(r1.getY() - r2.getY());
			if(tempApostasi>apostasi){
				apostasi = tempApostasi;
				x = r1.getX()+1;
				y = r1.getY();
			}
		}
		if(r1.getY()-1>=0 && !Main.nodes[r1.getY()-1][r1.getX()].getNodeChar().equals("X")){
			tempApostasi = Math.abs(r1.getX() - r2.getX())+ Math.abs(r1.getY()-1 - r2.getY());
			if(tempApostasi>apostasi){
				apostasi = tempApostasi;
				x = r1.getX();
				y = r1.getY()-1;
			}
		}
		if(r1.getY()+1<=Main.ySize && !Main.nodes[r1.getY()+1][r1.getX()].getNodeChar().equals("X")){
			tempApostasi = Math.abs(r1.getX() - r2.getX())+ Math.abs(r1.getY()+1 - r2.getY());
			if(tempApostasi>apostasi){
				apostasi = tempApostasi;
				x = r1.getX();
				y = r1.getY()+1;
			}
		}
		
		Main.nodes[r1.getY()][r1.getX()].setNodeChar("$");
		r1.EraseCurrentPosition();
		r1.setX(x);
		r1.setY(y);
		Main.nodes[r1.getY()][r1.getX()].setNodeChar("1");
		r1.moveRobot(Color.RED);
		
	}

}
