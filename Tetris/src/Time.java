
public class Time implements Runnable {
	//each level time is decreased as such:
	//0, 50, 75, 100, 125, 150, 175, 200, 225, 250
	
	//how much time the game should wait between levels
	private static int[] levwait = {1700, 1450, 1375, 1275, 1150, 1000, 825, 625, 325, 125}; 
	
	Thread time;

	
	public static void threadtimestart() {
		Thread time = new Thread(new Time());
		time.start();
	}
	
	public static void timekeeping() {
		while (Main.gameon) {
			long starttime = System.currentTimeMillis();
			Main.display.repaint();
						
			try {
				Thread.sleep(levwait[Levels.level -1]-(starttime-System.currentTimeMillis()));
			} catch (InterruptedException e) {
				System.out.println("Time thread died");
				e.printStackTrace();
			}
		}
	}

	//makes as time thread, that keeps track of time
	public void run() {
		timekeeping();
	}
}