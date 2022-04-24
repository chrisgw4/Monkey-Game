package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Warriors extends Purchaseable{

	private double myHitPoints;
	
	private Image myImage;
	
	private int tempNumOwned;
	
	
	public Warriors(double x, double y, String name, double cost, int width, int height, double hitpoints) {
		super(x, y, name, cost, width, height);
		myHitPoints = hitpoints;
	}

	public void updateTempOwned() {
		tempNumOwned = getAmountOwned();
	}
	
	public int getTempOwned() {
		return tempNumOwned;
	}
	
	public void countDeaths() {
		
	}
	
	public double getHitPoints() {
		return myHitPoints;
	}
	
	
	
	
}
