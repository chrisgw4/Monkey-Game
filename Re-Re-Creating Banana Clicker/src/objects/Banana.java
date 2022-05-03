package objects;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Main;

public class Banana extends GlobalPosition{

	private int myWidth;
	private int myHeight;
	private int myWidthConstant;
	private int myHeightConstant;
	private int myFrame = 0;
//	private String myImage = "/Images/Banana/" + "img" + ".png";
	
//	String fName = "/Images/Banana/img.png";
//	InputStream is = Main.class.getResourceAsStream(fName);
	
	private int myXConstant;
	private int myYConstant;
	
	private int baseY;
	
	private Image img;

	private int myFPS = 1;
	
	public Banana(double x, double y, int width, int height) {
		super(x, y);
		myWidth = (int)(width*.18);
		myHeight = (int)(height*.3);
		myWidthConstant = myWidth;
		myHeightConstant = myHeight;
		myXConstant = (int)(getX());
		myYConstant = (int)(getY());
		
		baseY = (int)(getY());
//		try {
//			image = ImageIO.read(is);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			img = ImageIO.read(new File("Re-Re-Creating Banana Clicker/Images/Banana/banana.png"));
		} catch (IOException e) {

			try {
				img = ImageIO.read(new File("Images/Banana/banana.png"));
				}
				catch(Exception d) {}

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private boolean moveUp = false;
	//private int delayTimer = 3;
	
	private int delayTimer = 12*myFPS;
	private int delayCounter = 0;

	public void updateFPS(int fps) {
		myFPS = fps;
		if(fps >= 30)
			delayTimer = 12*myFPS/60;
	}
	
	public void draw(Graphics2D g2d) {
		if(getY() > baseY-10 && !moveUp && delayCounter >= delayTimer)
		{
			//this.setY(getY()-1 );
			delayCounter = 0;
			this.setY(getYConstant()-10);
		}
		else if ((moveUp || getY() <= baseY-10) && delayCounter >= delayTimer)
		{
//			this.setY(getY()+1 );
//			moveUp = true;
			delayCounter = 0;
			this.setY(getYConstant());
		}
		if(getY() > baseY )
		{
			moveUp = false;
		}
		delayCounter++;
		//System.out.println(delayCounter);
		g2d.drawImage(img, (int)(getX()), (int)(getY()), myWidth, myHeight, null);
		//System.out.println(getY());
		
	}
	
	
	
//	public Image getBananaImage() {
//		ImageIcon i = new ImageIcon(image);
//		return i.getImage();
//		
//	}
	
	public void changeSize(int width, int height) {
		myWidth = (int)(width*.18);
		myHeight = (int)(height*.3);
		myWidthConstant = myWidth;
		myHeightConstant = myHeight;
		
		//System.out.println(myWidth);
		//System.out.println(myHeight);
		
	}
	
	public int getXConstant() {
		return myXConstant;
	}
	
	public int getYConstant() {
		return myYConstant;
	}
	
	
	public int getWidth() {
		return myWidth;
	}

	public int getHeight() {
		return myHeight;
	}
	
	public void setWidth(int x) {
		myWidth = x;
	}

	public void setHeight(int x) {
		myHeight = x;
	}
	
	public int getWidthConstant() {
		return myWidthConstant;
	}

	public int getHeightConstant() {
		return myHeightConstant;
	}
	
}
