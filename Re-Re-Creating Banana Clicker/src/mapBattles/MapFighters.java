package mapBattles;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import objects.GlobalPosition;

public class MapFighters extends GlobalPosition{

	private Image myImage;
	
	private String myName;
	
	private int myWidth;
	private int myHeight;
	
	private int myStartingX;
	
	
	public MapFighters(double x, double y, String name, int width, int height) {
		super(x, y);
		myName = name;
		myWidth = width;
		myHeight = height;
		// TODO Auto-generated constructor stub
	}
	
	public void setStartingX(int x) {
		myStartingX = x;
	}
	
	public int getHeight() {
		return myHeight;
	}
	
	public void setImage(Image g) {
		this.myImage = g;
	}
	
	public String getName() {
		return myName;
	}

//	public void makeImage() {
//		try {
//			myImage = ImageIO.read(new File("Images/Warriors/" + myName + ".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//		}
//	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(myImage, getX(), getY(), myWidth, myHeight, null);
	}
	
}
