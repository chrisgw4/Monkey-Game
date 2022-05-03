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
	
	private int movementSpeed;
	
	private int myStartingX;
	
	private boolean isNextToEnemy;

	private int myFinalX;
	private boolean saveFinalX;
	private int myFinalY;
	
	private int myXIndx;
	private int myYIndx;

	private int mySpazDelay;
	private int mySpazDelayCounter;
	
	public MapFighters(double x, double y, String name, int width, int height) {
		super(x, y);
		myName = name;
		myWidth = width;
		myHeight = height;
		isNextToEnemy = false;
		movementSpeed = 0;

		saveFinalX = false;

		myXIndx = -1;
		myYIndx = -1;

		mySpazDelayCounter = 0;
		mySpazDelay = 3;
		
		// TODO Auto-generated constructor stub
	}

	public int getSpazDelayCounter() {
		return mySpazDelayCounter;
	}

	public void incrementSpazDelayCounter() {
		mySpazDelayCounter++;
	}

	public void resetSpazDelayCounter() {
		mySpazDelayCounter = 0;
	}

	public int getSpazDelay() {
		return mySpazDelay;
	}

	public void setXIndx(int i) {
		myXIndx = i;
	}

	public int getXIndx() {
		return myXIndx;
	}

	public void setYIndx(int i) {
		myYIndx = i;
	}

	public int getYIndx() {
		return myYIndx;
	}

	public boolean isFinalSaved() {
		return saveFinalX;
	}

	public void setFinalSaved(boolean b) {
		saveFinalX = b;
	}

	public void saveFinalX() {
		myFinalX = (int)(getX());
	}

	public int getFinalX() {
		return myFinalX;
	}

	public void saveFinalY() {
		myFinalY = (int)(getY());
	}

	public int getFinalY() {
		return myFinalY;
	}
	
	public int getWidth() {
		return myWidth;
	}
	
	public void setSpeed(int s)
	{
		this.movementSpeed = s;
	}
	
	public int getSpeed() {
		return this.movementSpeed;
	}
	
	public void setNextToEnemy(boolean b)
	{
		isNextToEnemy = b;
	}
	
	public boolean isNextToEnemy() {
		return this.isNextToEnemy;
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
		g2d.drawImage(myImage, (int)(getX()), (int)(getY()), myWidth, myHeight, null);
	}
	
}
