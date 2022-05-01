package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemies extends GlobalPosition{
	
	private Image img;
	
	private int myWidth;
	private int myHeight;
	
	public Enemies(int width, int height) {
		super(width,height);
		
		try {
			img = ImageIO.read(new File("Images/Banana/banana.png"));
		} catch (IOException e) {

			try {
				img = ImageIO.read(new File("Images/Upgrade_Boxes/Blank.png"));
				}
				catch(Exception d) {}

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(img, this.getX(), this.getY(), myWidth, myHeight, null);
	}
	
}
