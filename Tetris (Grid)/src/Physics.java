//Physics class: makes blocks fall, clears lines, and checks whether there is "fusion"

//Documentation of the methods are in the method
public class Physics {

	public static void dropCall() {
		//loops through all of the squares in the grid, calling Physics.drop() to drop them all
		for (int x = 0; x < Main.gameWidth; x++) {
			for (int y = 0; y < Main.gameHeight; y++) {
				drop(x, y);
			}
		}
	}

	public static void drop(int x, int y) {
		//drops squares if they are either at the bottom, or have a square beneath them
		//drops are done by moving all of the square's information to the square below
		if (Grid.grid[x][y].hasSquare && Grid.grid[x][y].active) {
			if (y-1 >= 0 && !Grid.grid[x][y -1].hasSquare) {
				Square square = Grid.grid[x][y];
				Square belowSquare = Grid.grid[x][y -1];

				belowSquare.hasSquare = true;
				belowSquare.active = true;
				belowSquare.type = Grid.grid[x][y].type;

				removeSquare (square);
			}
		}
	}

	public static void move() {
		
	}
	
	public static void removeSquare(Square square) {
		//removes the square by erasing all of the square's files
		square.hasSquare = false;
		square.active = false;
		square.type = 0;
		square.leftN = false;
		square.rightN = false;
		square.topN = false;
		square.bottomN = false;
	}

	public static void clearLineCheck() {
		int squaresInLine;
		for (int y = 0; y < Main.gameHeight; y++) {
			squaresInLine = 0;
			for (int x = 0; x < Main.gameWidth; x++) {
				if (Grid.grid[x][y].hasSquare) squaresInLine++;
			}
			if (squaresInLine == Main.gameWidth) clearLine(y);
		}
	}

	public static void clearLine(int yclear) {
		for (int x = 0; x < Main.gameWidth; x++) {
			removeSquare(Grid.grid[x][yclear]);
		}
	}

	public static void randomPlace() {
    	// randomize resets the grid with randomly generated cells
        double ranX = Math.random() * Main.gameWidth;
        double ranT = Math.random() * 7;
        double ranId = Math.random() * 100;
        
        int ranXI = (int) ranX;
        int ranTI = (int) ranT;
        int ranIdI = (int) ranId;        
        
        
        Square.setSquare(ranXI, Main.gameHeight-1, ranXI%7, 1);
	}
}
