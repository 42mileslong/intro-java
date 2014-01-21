import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Display extends JComponent{
	BufferedImage background;
	
	//colors picked from http://www.w3schools.com/tags/ref_colorpicker.asp
	//colors are named [tetrimo type] + ["" or "D"]
	//dark colors are 3 levels darker
	private static Color I = new Color(0x00cfcf);
	private static Color ID = new Color(0x009191);
	private static Color J = new Color(0x297acc);
	private static Color JD = new Color(0x1D558F);
	private static Color L = new Color(0xff8000);
	private static Color LD = new Color(0xb25a00);
	private static Color O = new Color(0xfbf579);
	private static Color OD = new Color(0xb0ac55);
	private static Color S = new Color(0x80db70);
	private static Color SD = new Color(0x4e994e);
	private static Color T = new Color(0xad44d6);
	private static Color TD = new Color(0x792496);
	private static Color Z = new Color(0xf94e4e);
	private static Color ZD = new Color(0xae3737);
	
	//Array is I, J, L, O, S, T, Z
	private static Color[][] colors = {{I, J, L, O, S, T, Z}, {ID, JD, LD, OD, SD, TD, ZD}};

	
	public Display() {
		//load image
		try {
			background = ImageIO.read(new File("Board.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void init() {
		setSize(Main.imgwidth, Main.imgheight);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintGame(g);
	}
	
	public void paintGame(Graphics g) {
		for (int w = 0; w < Main.gamewidth; w++) {
			for (int h = 0; h < Main.gameheight - 2; h++) {
				if (Grid.grid[w][h].hastet) paintTetrimo(g, 0, 0);
			}
		}
	}
	
	public void paintTetrimo(Graphics g, int x, int y) {
		//offset of grid is 22 long, 16 high
		g.setColor(colors[Grid.grid[x][y].type][1]);
		g.fillRect(Main.xoffset + x*16, findY(y), Main.xoffset + (x+1)*16, findY(y+1));
	}
	
	//22*16, 38*32
	
	public static int findY(int y) {
		System.out.println(Main.imgheight - Main.yoffset - y*16);
		return Main.imgheight - Main.yoffset - y*16;
	}
}