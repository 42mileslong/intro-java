/*
 * Tetris Fusion
 * 
 * Made by Rafi Long
 * Based on the Tetris Worlds game
 * 
 */


//Documentation of the methods are in the method

//http://en.wikipedia.org/wiki/Binomial_coefficient
//probability of of blocks landing in a configuration

import javax.swing.JFrame;

public class Main {
	//image dimensions for the background
	public static int imgWidth = 204;
	public static int imgHeight = 406;

	//game dimensions - how many squares make up the game
	public static int gameWidth = 10;
	public static int gameHeight = 24;

	//makes the game fullscreen (these variables will be the size of the screen)
	public static int currentWinX = 0;
	public static int currentWinY = 0;

	//game variables
	public static boolean gameOn = false;
	static int currentId = 0;

	public static Display display = new Display();


	public static void main(String[] args) {
		//initializes game (starts the boolean)
		gameOn = true;

		//makes the frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(imgWidth + 16, imgHeight + 38);
		frame.setLocation(200, 100);
		frame.setVisible(true);

		//adds the display to the frame
		frame.add(display);

		//fills the grid with squares
		Square.createSquares();

		//initializes the grid
		display.init();

		//for the devs - runs the testing stuffs
//		testingSuite();

		//comment out when you don't want blocks to fall
		Time.threadTimeStart();		
	}

	public static void testingSuite() {
		//sets squares to values (x, y, type, tetrimoId)
	}

	private static void testCase() {
		//these variables keep track of how many succeses there are - successes are printed to the console
		int success = 0;
		int methodSuccess = 0;

		System.out.println("Method documentation is found in the method");
		newLine();
		newLine();

		//test cases for method 1 - Display.findY()
		System.out.println("Method 1 Test Cases");
		System.out.println("calls Display.findY(), which takes a y value in the grid of Squares, and translates it into the y value taken by the Java draw methods, taking into account square width and the offset created by the image");
		newLine();

		System.out.println("Method 1 Test 1: (1) -> (374)");
		System.out.println("Return: " + Display.findY(1));
		if (Display.findY(1) == 374) {
			success++;
			methodSuccess++;
			System.out.println("Method 1 Test 1 succeeded");
		} else {
			System.out.println("Method 1 Test 1 failed");
		}
		newLine();

		System.out.println("Method 1 Test 2: (5) -> (310)");
		System.out.println("Test 2 Return: " + Display.findY(5));
		if (Display.findY(5) == 310) {
			success++;
			methodSuccess++;
			System.out.println("Method 1 Test 2 succeeded");
		} else {
			System.out.println("Method 1 Test 2 failed");
		}
		newLine();

		System.out.println("Method 1 Test 3: (42) -> (-282)");
		System.out.println("Test 3 Return: " + Display.findY(42));
		if (Display.findY(42) == -282) {
			success++;
			methodSuccess++;
			System.out.println("Method 1 Test 3 succeeded");
		} else {
			System.out.println("Method 1 Test 3 failed");
		}
		newLine();

		System.out.println(methodSuccess + " successes, " + (3-methodSuccess) + " failures in method 2");
		methodSuccess = 0;

		newLine();
		newLine();


		//test cases for method 2 - Square.neighborfind()
		System.out.println("Method 2 Test Cases");
		System.out.println("calls Square.neighborfind(), which takes an x value, y value, and a side as arguments. It then searches the side indicated for whether it has a square, and whether the square shares the same tetrimoid. It returns a boolean for true if the tetrimo id is the same for the neighbor and the neighbor has a square");
		newLine();

		System.out.println("Method 2 Test 1: Squares in [1][1] and [1][2] with the same id; (1, 1, 'top') -> true");
		Square.setSquare(1, 1, 1, 1);
		Square.setSquare(1, 2, 1, 1);
		System.out.println("Return: " + Square.neighborFind(1, 1, "top"));
		if (Square.neighborFind(1, 1, "top")) {
			success++;
			methodSuccess++;
			System.out.println("Method 2 Test 1 succeeded");
		} else {
			System.out.println("Method 2 Test 1 failed");
		}
		newLine();

		System.out.println("Method 2 Test 2: Squares in [4][1] and [5][1] with the same id; (4, 1, 'right') -> true");
		Square.setSquare(4, 1, 2, 4);
		Square.setSquare(5, 1, 2, 4);
		System.out.println("Test 2 Return: " + Square.neighborFind(4, 1, "right"));
		if (Square.neighborFind(4, 1, "right")) {
			success++;
			methodSuccess++;
			System.out.println("Method 2 Test 2 succeeded");
		} else {
			System.out.println("Method 2 Test 2 failed");
		}
		newLine();

		System.out.println("Method 2 Test 3: Squares in [5][5] and [4][5] with the same id; (5, 5, 'left') -> true");
		Square.setSquare(5, 5, 3, 42);
		Square.setSquare(4, 5, 3, 42);
		System.out.println("Test 3 Return: " + Square.neighborFind(5, 5, "left"));
		if (Square.neighborFind(5, 5, "left")) {
			success++;
			methodSuccess++;
			System.out.println("Method 2 Test 3 succeeded");
		} else {
			System.out.println("Method 2 Test 3 failed");
		}
		newLine();

		System.out.println(methodSuccess + " successes, " + (3-methodSuccess) + " failures in method 3");
		methodSuccess = 0;

		newLine();
		newLine();

		//test cases for method 3 - Display.colors
		System.out.println("Method 3 Test Cases");
		System.out.println("Display.colors is a 2-dimensional array with the purpose of storing colors for the tetrimos - light colors go on one row, which are used for the body of the squares, and dark colors go on another, which are used for the outlines");
		newLine();

		System.out.println("Method 3 Test 1: Display.colors[0][0] == Display.I -> true");
		System.out.println("Return: " + (Display.colors[0][0] == Display.I));
		if (Display.colors[0][0] == Display.I) {
			success++;
			methodSuccess++;
			System.out.println("Method 3 Test 1 succeeded");
		} else {
			System.out.println("Method 3 Test 1 failed");
		}
		newLine();

		System.out.println("Method 3 Test 2: Display.colors[0][3] == Display.O -> true");
		System.out.println("Test 2 Return: " + (Display.colors[0][3] == Display.O));
		if (Display.colors[0][3] == Display.O) {
			success++;
			methodSuccess++;
			System.out.println("Method 3 Test 2 succeeded");
		} else {
			System.out.println("Method 3 Test 2 failed");
		}
		newLine();

		System.out.println("Method 3 Test 2: Display.colors[1][4] == Display.SD -> true");
		System.out.println("Test 3 Return: " + (Display.colors[1][4] == Display.SD));
		if (Display.colors[1][4] == Display.SD) {
			success++;
			methodSuccess++;
			System.out.println("Method 3 Test 3 succeeded");
		} else {
			System.out.println("Method 3 Test 3 failed");
		}
		newLine();

		System.out.println(methodSuccess + " successes, " + (3-methodSuccess) + " failures in method 3");

		newLine();
		newLine();

		System.out.println(success + " total successes, " + (9-success) + " failures in total");
	}

	private static void newLine() {
		System.out.println();
	}
}
