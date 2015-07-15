package com.ai.main;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.ai.component.Node;

public class Main {

	public static Node[][] nodes;
	public static Node robot1 = new Node();
	public static Node robot2 = new Node();
	public static int xSize;
	public static int ySize;
	public static int open_count=0;
	public static int closed_count=0;
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String filename= args[0];
		createTable(filename);
		Chaser chaser = new Chaser();
		while(robot1.getX() != robot2.getX() || robot1.getY() != robot2.getY()){
			chaser.moveR2();
			if(robot1.getX() != robot2.getX() || robot1.getY() != robot2.getY())
				chaser.moveR1();
			
		}		
		System.out.println();
		for(int i=0; i<=ySize; i++){
			for(int j=0; j<=xSize; j++){
				System.out.print(nodes[i][j].getNodeChar());
			}
			System.out.println();
		}
		System.out.println("Total moves to catch Robot1:"+robot2.getCost()+"");
		System.out.println("Total nodes added to open list:"+ open_count +"");
		System.out.println("Total nodes added to closed list:"+ closed_count +"");
		long end = System.currentTimeMillis();
		System.out.println("Total time in msec:"+ (end - start));
	}

	private static void DrawMaze() {
		int i, j;
		StdDraw.setPenColor(Color.orange);
		for (i = 0; i <= ySize; i++)
			for (j = 0; j <=  xSize; j++) {
				if (nodes[i][j].getNodeChar().equals("X"))
					StdDraw.filledRectangle((2 * j + 1) * 1.0 / (2 * (xSize+1)), 1.0
							- (2 * i + 1) * 1.0 / (2 * (ySize+1)), 1.0 / (2 * (xSize+1)),
							1.0 / (2 * (ySize+1)));
			}		
	}

	private static void DrawTable() {
		StdDraw.square(0.5, 0.5, 0.5);
		StdDraw.setPenColor(Color.orange);
		double x = 0;
		while (x < 1) {
			StdDraw.line(0, x, 1, x);
			x += 1.0 / (ySize+1);
		}
		x = 0;
		while (x < 1) {
			StdDraw.line(x, 0, x, 1);
			x += 1.0 / (xSize+1);
		}	}

	private static void createTable(String filename) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			String[] line = br.readLine().trim().split(" ");
			xSize = Integer.parseInt(line[0]);
			ySize = Integer.parseInt(line[1]);
			nodes = new Node[ySize][xSize];
			line = br.readLine().trim().split(" ");
			robot1.setX(Integer.parseInt(line[0])-1);
			robot1.setY(Integer.parseInt(line[1])-1);
			robot1.setNodeChar("1");
			line = br.readLine().trim().split(" ");
			robot2.setX(Integer.parseInt(line[0])-1);
			robot2.setY(Integer.parseInt(line[1])-1);
			robot2.setNodeChar("2");
			String table;
			for (int i = 0; i < ySize; i++) {
				table = br.readLine().trim();
				for (int j = 0; j < xSize; j++) {
					nodes[i][j] = new Node(i, j, table.charAt(j));
					if(i==robot1.getY() && j == robot1.getX())
						nodes[i][j].setNodeChar("1");
					if(i==robot2.getY() && j == robot2.getX())
						nodes[i][j].setNodeChar("2");
					//System.out.print(nodes[i][j].getNodeChar());
				}
				//System.out.println();
			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		xSize = xSize-1;
		ySize = ySize-1;
		StdDraw.setCanvasSize(856,700);
		DrawTable();
		DrawMaze();
		robot1.moveRobot(Color.RED);
		robot2.moveRobot(Color.green);		
	}

}
