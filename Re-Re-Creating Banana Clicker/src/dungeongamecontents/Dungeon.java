package dungeongamecontents;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Dungeon {

	private Image dungeonImage;
	
	private int myWidth;
	private int myHeight;
	
	private int myX;
	private int myY;
	
	public Dungeon(int width, int height, int x, int y) {
		myWidth = width;
		myHeight = height;
		myX = x;
		myY = y;
	}
	
	public void getImage() {
		try {
			dungeonImage = ImageIO.read(new File("Images/Dungeon/" + "dungeon" + 1 + ".png"));
		}
		catch(Exception e) { }
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(dungeonImage, myX, myY, myWidth, myHeight, null);
	}
}
