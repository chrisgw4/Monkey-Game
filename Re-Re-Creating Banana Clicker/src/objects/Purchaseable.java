package objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import CountLargeNumbers.NumToWords;
import Panels.EverythingPanel;
import Panels.PurchaseablePanel;
import input.MouseLocation;
import main.Main;




public class Purchaseable extends GlobalPosition {


	public int multiplier = 1;
	public static int things_per_tick = 0;
	
	private String myName = "";
	private double myPrice;
	private int myLength;
	private int myHeight;
	private int yConstant;
	
	private static int screenHeight;
	
	
	private static int screenWidth;
	
	private int amountOwned = 0;
	
	// To keep track of the normal size of the Boxes
	private int myLengthConstant;
	private int myHeightConstant;
	
	private String myImage;
	
	private String myFlipImage;
	
	private int myFrame;
	
	public static PurchaseablePanel pp;
	
	
	
	
	private ScoreFont sf = new ScoreFont(14);
	private ScoreFont sf2 = new ScoreFont(14);
	
	//private Font scoreFont = sf.getScoreFont();
	
	private Image image;
	
	private InputStream is;
	
	private boolean showStats = false;
	
	private boolean setBlank = false;
	
	private int myDelay;
	private int myDelayCount;
	private boolean showBoard;
	
	private boolean isFlipped = false;
	private boolean mouseOnSelf = false;
	
	private NumberFormat nf;
	
	private DecimalFormat df2 = new DecimalFormat("0.0");
	
	private DecimalFormat df = new DecimalFormat("0");
	
	private Image img;
	
	private Image flip_img;
	
	private ArrayList<Image> flipList = new ArrayList<Image>();
	
	private static int FPS = EverythingPanel.getFPSTarget();
	//private int myY;
	
	//Purchaseable m = new Purchaseable(width*.3, height*.3, "Monkey", 10.0, 172*width/1920, 46*height/1080);
	public Purchaseable(double x, double y, String name, double cost, int width, int height) {
		super(x, y);
		//myY = (int) y;
		
		
		screenWidth = width;
		screenHeight = height;
		
		myLength = 172*width/1920;
		myHeight = 46*height/1080;
		myLengthConstant = myLength;
		myHeightConstant = myHeight;
		
		myPrice = (float) cost;
		
		myName = name;
		
		//myImage = "/Images/Upgrade_Boxes/" + myName + ".png";
		//myFlipImage = "/Images/Upgrade_Boxes/Board_Flip/flip_" + myFrame + ".png";
		myFrame = 4;
		myDelay = 5*(FPS/60);
		myDelayCount = 0;
		showBoard = false;
		
		nf = NumberFormat.getInstance(new Locale("sk", "SK"));
		nf.setMaximumIntegerDigits(6);
		
		df2.setGroupingUsed(true);
		df2.setGroupingSize(3);
		
		try {
			img = ImageIO.read(new File("Images/Upgrade_Boxes/" + myName + ".png"));
			//flip_img = ImageIO.read(new File("Images/Upgrade_Boxes/Board_Flip/flip_0.png"));
			//flipList.add(flip_img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < 4; i++)
		{
			try {
				flip_img = ImageIO.read(new File("Images/Upgrade_Boxes/Board_Flip/flip_"+ i +".png"));
				flipList.add(flip_img);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	
	public void update(MouseLocation m) {
		if (m.mouseInPurchaseable(this, PurchaseablePanel.getMouseInPanel())) 
		{
			myLength = (int) (myLengthConstant + myLengthConstant*.05);
			myHeight = (int) (myHeightConstant + myHeightConstant*.05);
		}
		else
		{
			myLength = myLengthConstant;
			myHeight = myHeightConstant;
		}
		
		
//		if (m.getX() >= this.getX() && m.getX() <= this.getX()+myLength && 
//				m.getY() >= this.getY() && m.getY() <= this.getY()+myHeight)
//		{
//			myLength = (int) (myLengthConstant + myLengthConstant*.1);
//			myHeight = (int) (myHeightConstant + myHeightConstant*.1);
//		}
//		else 
//		{
//			myLength = myLengthConstant;
//			myHeight = myHeightConstant;
//		}
		
		
	}
	
	public boolean getMouseInBox() {
		
		// TODO Auto-generated method stub
		return mouseOnSelf;
	}
	
	public void setMouseInBox(boolean b) {
		
		// TODO Auto-generated method stub
		mouseOnSelf = b;
	}
	
	public boolean getFlipped() {
		return isFlipped;
	}
	
	public boolean getShowBoard() {
		return showBoard;
	}
	
	public void draw(Graphics2D g2d) {
		if (!showStats)
		{
			
			g2d.drawImage(getFlipImage(), getX(), getY(), myLength, myHeight, null);
			if(myFrame >3)
			{
				showBoard = true;
			}
			else
				showBoard = false;
		}
		if (showBoard)
		{
			if(myFrame > 3)
			{
				isFlipped = true;
			}
//			if (isFlipped)
			g2d.drawImage(img, getX(), getY(), myLength, myHeight, null);
		}
		else if (showStats && myFrame <= 3)
		{
			g2d.drawImage(getFlipImage(), getX(), getY(), myLength, myHeight, null);
		}
		
		
		
		//g2d.setFont(scoreFont);
		g2d.setFont(sf.getScoreFont());
		//g2d.setFont();
		g2d.setColor(Color.white);
		
		g2d.drawString(NumToWords.truncateNumberThousands(amountOwned)+"",(int) (myX+myLength+myLength*.01), myY+myHeight);
		
		if (showStats)
		{
			//myFrame = 0;
			if(myFrame > 3)
			{
				
				g2d.setFont(sf2.getScoreFont());
				g2d.drawImage(getBackBoardImage(), getX(), getY(), myLength, myHeight, null);
				//g2d.drawString((int)myPrice+"",(int) (myX+myLength*.04), (int)(myY+myHeight*.7));
				//g2d.drawString(nf.format(myPrice)+"",(int) (myX+myLength*.04), (int)(myY+myHeight*.7));
				//g2d.drawString(printPrice+"",(int) (myX+myLength*.04), (int)(myY+myHeight*.45));
				//if (myPrice >= 1_000_000)
				if(myPrice<1_000_000_000_000_000D)
				{
					//sf2 = new ScoreFont(16*screenWidth/1920);
					//g2d.setFont(sf2.getScoreFont());
					g2d.setFont(new ScoreFont(16*screenWidth/1920).getScoreFont());
				}
				else
				{
					//sf2 = new ScoreFont(11*screenWidth/1920);
					g2d.setFont(sf2.getScoreFont());
				}
				g2d.drawString(NumToWords.NumToWord(myPrice)+"",(int) (myX+myLength*.04), (int)(myY+myHeight*.7));
				//else
					//g2d.drawString(df.format(myPrice)+"",(int) (myX+myLength*.04), (int)(myY+myHeight*.7));
			}
		}
	}
	
	public String getName() {
		return myName;
	}
	
	public void setShowBoard(boolean b) {
		showBoard = b;
	}
	
	public int getFrame() {
		return myFrame;
	}
	
	public void setFrame(int num) {
		myFrame = num;
	}
	
	public void setShowStats(boolean t) {
		showStats = t;
	}
	
	public boolean getShowStats() {
		return showStats;
	}
	
//	public void setImage(String name) {
//		myImage = "/Images/Upgrade_Boxes/" + name + ".png";
//	}
//	
//	public void resetImage() {
//		myImage = "/Images/Upgrade_Boxes/Board_Flip/flip_" + myFrame + ".png";
//	}
	
	
//	public Image getPurchaseableImage() {
//		ImageIcon i = new ImageIcon(getClass().getResource(myImage));
//		return i.getImage();
//	}
	
	
	public Image getFlipImage() {
		if (myFrame <= 3)
		{
//			myFlipImage = "/Images/Upgrade_Boxes/Board_Flip/flip_" + myFrame + ".png";
//			try {
//				flip_img = ImageIO.read(new File("Images/Upgrade_Boxes/Board_Flip/flip_" + myFrame + ".png"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			myDelayCount++;
			//System.out.println(myFrame);
			if (myDelayCount >= myDelay)
			{
				myFrame++;
				//System.out.println(myFrame);
				myDelayCount = 0;
			}
			if(myFrame > 0)
				return flipList.get(myFrame-1);
			
				
		}
		else if (showStats)
			myFrame = 0;
		//ImageIcon i = new ImageIcon(getClass().getResource(myFlipImage));
		
		return flipList.get(0);
		
		//return i.getImage();
	}
	
	public Image getBackBoardImage() {
//		ImageIcon i = new ImageIcon(getClass().getResource(myFlipImage));
//		myFlipImage = "/Images/Upgrade_Boxes/Blank" + ".png";
//		return i.getImage();
		try {
			flip_img = ImageIO.read(new File("Images/Upgrade_Boxes/Blank.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flip_img;
	}
	
	public double getLength() {
		return myLength;
	}
	
	public double getHeight() {
		return myHeight;
	}


	public double getPrice() {
		// TODO Auto-generated method stub
		return myPrice;
	}


	public void setAmountOwned(int i) {
		amountOwned = i;
	}
	
	public int getAmountOwned() {
		return amountOwned;
	}


	public void setPrice(double x) {
		myPrice = (double) x;
		
	}
	
	public void setSize(int width, int height) {
		myLength = 172*width/1920;
		myHeight = 46*height/1080;
		
		// TESTING
		{
			myLength = 215*width/1920;
			myHeight = 58*height/1080;
			//myLength = 241*width/1920;
			//myHeight = 64*height/1080;
			//setY(0);
			//System.out.println(myY);
			
			//yConstant = 10;
//			System.out.println(getY());
			
			sf = new ScoreFont(14*screenWidth/1920);
			sf2 = new ScoreFont(11*screenWidth/1920);
		}
		
		myLengthConstant = myLength;
		myHeightConstant = myHeight;
		
		setScreenWidth(width);
		setScreenHeight(height);
		//sf = new ScoreFont(14*screenWidth/1920);
		//sf2 = new ScoreFont(10*screenWidth/1920);
	}
	
	public static void setScreenWidth(int width) {
		screenWidth = width;	
		
	}
	
	public static void setScreenHeight(int height) {
		screenHeight = height;	
		
	}
	public static int getScreenHeight() {
		return screenHeight;	
		
	}
	
	//private String printPrice;
	
//	public String truncateNumber(double floatNumber) {
//		double million = 1000000L;
//		double billion = 1000000000L;
//		double trillion = 1_000_000_000_000L;
//	    double quadrillion = 1_000_000_000_000_000L;
//	    double quintillion = 1_000_000_000_000_000_000L;
//	    double sextillion = 1_000_000_000_000_000_000_000D;
//	    double septillion = 1_000_000_000_000_000_000_000_000D;
//	    double octillion = 1_000_000_000_000_000_000_000_000_000D;
//	    double nonillion = 1_000_000_000_000_000_000_000_000_000_000D;
//	    double decillion = 1_000_000_000_000_000_000_000_000_000_000_000D;
//	    double undecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double duodecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double tredecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double quattuordecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double quindecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double sexdecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;//17 sets
//	    double septendecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;//18 sets of 0s
//	    double octodecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;// 19
//	    double novemdecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;//20
//	    double vigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double unvigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double duovigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double trevigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double quattuorvigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double quinvigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double sexvigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double septenvigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double octovigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double novemvigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//	    double trigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
//		
//	    
//	    double number = floatNumber; //Math.round(floatNumber);
//	    if ((number >= million) && (number < billion)) {
//	    	double fraction = calculateFraction(number, million);
//	    	sf2 = new ScoreFont(16*screenWidth/1920);
//	        return df2.format(fraction) + " Million";
//	        //return Double.toString(fraction) + "M";
//	    }
//	    else if ((number >= billion) && (number < trillion)) {
//	    	double fraction = calculateFraction(number, billion);
//	    	sf2 = new ScoreFont(16*screenWidth/1920);
//	        return df2.format(fraction) + " Billion";
//	        //return Double.toString(fraction) + "B";
//	    }
//	    else if ((number >= trillion) && (number < quadrillion)) {
//	        double fraction = calculateFraction(number, trillion);
//	        sf2 = new ScoreFont(16*screenWidth/1920);
//	        return df2.format(fraction) + " Trillion";
//	    }
//	    else if ((number >= quadrillion) && (number < quintillion)) {
//	        double fraction = calculateFraction(number, quadrillion);
//	        return df2.format(fraction) + " Quadrillion";
//	    }
//	    else if ((number >= quintillion) && (number < sextillion)) {
//	        double fraction = calculateFraction(number, quintillion);
//	        return df2.format(fraction) + " Quintillion";
//	    }
//	    else if ((number >= sextillion) && (number < septillion)) {
//	        double fraction = calculateFraction(number, sextillion);
//	        //System.out.println(number + "C");
//	        //System.out.println(number + "C");
//	        return df2.format(fraction) + " Sextillion";
//	    }
//	    else if ((number >= septillion) && (number < octillion)) {
//	        double fraction = calculateFraction(number, septillion);
//	        //System.out.println(number + "C");
//	        //System.out.println(number + "C");
//	        return df2.format(fraction) + " Septillion";
//	    }
//	    else if ((number >= octillion) && (number < nonillion)) {
//	        double fraction = calculateFraction(number, octillion);
//	        //System.out.println(number + "C");
//	        //System.out.println(number + "C");
//	        return df2.format(fraction) + " Octillion";
//	    }
//	    else if ((number >= nonillion) && (number < decillion)) {
//	        double fraction = calculateFraction(number, nonillion);
//	        return df2.format(fraction) + " Nonillion";
//	    }
//	    else if ((number >= nonillion) && (number < decillion)) {
//	        double fraction = calculateFraction(number, nonillion);
//	        return df2.format(fraction) + " Nonillion";
//	    }
//	    else if ((number >= decillion) && (number < undecillion)) {
//	        double fraction = calculateFraction(number, decillion);
//	        return df2.format(fraction) + " Decillion";
//	    }
//	    else if ((number >= undecillion) && (number < duodecillion)) {
//	        double fraction = calculateFraction(number, undecillion);
//	        return df2.format(fraction) + " Undecillion";
//	    }
//	    else if ((number >= duodecillion) && (number < tredecillion)) {
//	        double fraction = calculateFraction(number, duodecillion);
//	        return df2.format(fraction) + " Duodecillion";
//	    }
//	    else if ((number >= tredecillion) && (number < quattuordecillion)) {
//	        double fraction = calculateFraction(number, tredecillion);
//	        return df2.format(fraction) + " Tredecillion";
//	    }
//	    else if ((number >= quattuordecillion) && (number < quindecillion)) {
//	        double fraction = calculateFraction(number, quattuordecillion);
//	        return df2.format(fraction) + " Quattuordecillion";
//	    }
//	    else if ((number >= quindecillion) && (number < sexdecillion)) {
//	        double fraction = calculateFraction(number, quindecillion);
//	        return df2.format(fraction) + " Quindecillion";
//	    }
//	    else if ((number >= sexdecillion) && (number < septendecillion)) {
//	        double fraction = calculateFraction(number, sexdecillion);
//	        return df2.format(fraction) + " Sexdecillion";
//	    }
//	    else if ((number >= septendecillion) && (number < octodecillion)) {
//	        double fraction = calculateFraction(number, septendecillion);
//	        return df2.format(fraction) + " Septendecillion";
//	    }
//	    else if ((number >= octodecillion) && (number < novemdecillion)) {
//	        double fraction = calculateFraction(number, octodecillion);
//	        return df2.format(fraction) + " Octodecillion";
//	    }
//	    else if ((number >= novemdecillion) && (number < vigintillion)) {
//	        double fraction = calculateFraction(number, novemdecillion);
//	        return df2.format(fraction) + " Novemdecillion";
//	    }
//	    else if ((number >= vigintillion) && (number < unvigintillion)) {
//	        double fraction = calculateFraction(number, vigintillion);
//	        //printPrice = df2.format(fraction);
//	        
//	        return df2.format(fraction) + " Vigintillion";
//	    }
//	    else if ((number >= unvigintillion) && (number < duovigintillion)) {
//	        double fraction = calculateFraction(number, unvigintillion);
//	        return df2.format(fraction) + " Unvigintillion";
//	    }
//	    else if ((number >= duovigintillion) && (number < trevigintillion)) {
//	        double fraction = calculateFraction(number, duovigintillion);
//	        return df2.format(fraction) + " Duovigintillion";
//	    }
//	    else if ((number >= trevigintillion) && (number < quattuorvigintillion)) {
//	        double fraction = calculateFraction(number, trevigintillion);
//	        return df2.format(fraction) + " Trevigintillion";
//	    }
//	    else if ((number >= quattuorvigintillion) && (number < quinvigintillion)) {
//	        double fraction = calculateFraction(number, quattuorvigintillion);
//	        return df2.format(fraction) + " Quattuorvigintillion";
//	    }
//	    else if ((number >= quinvigintillion) && (number < sexvigintillion)) {
//	        double fraction = calculateFraction(number, quinvigintillion);
//	        return df2.format(fraction) + " Quinvigintillion";
//	    }
//	    else if ((number >= sexvigintillion) && (number < septenvigintillion)) {
//	        double fraction = calculateFraction(number, sexvigintillion);
//	        return df2.format(fraction) + " Sexvigintillion";
//	    }
//	    else if ((number >= septenvigintillion) && (number < octovigintillion)) {
//	        double fraction = calculateFraction(number, septenvigintillion);
//	        return df2.format(fraction) + " Septenvigintillion";
//	    }
//	    else if ((number >= octovigintillion) && (number < novemvigintillion)) {
//	        double fraction = calculateFraction(number, octovigintillion);
//	        return df2.format(fraction) + " Octovigintillion";
//	    }
//	    else if ((number >= novemvigintillion) && (number < trigintillion)) {
//	        double fraction = calculateFraction(number, novemvigintillion);
//	        return df2.format(fraction) + " Novemvigintillion";
//	    }
//	    
//	    sf2 = new ScoreFont(16*screenWidth/1920);
//	    //return Double.toString(number);
//	    return df.format(number);
//	}
//	
//	public String truncateNumberThousands(double floatNumber) {
//		int thousand = 1000;
//		int million = 1_000_000;
//		
//		double number = floatNumber; //Math.round(floatNumber);
//	    if ((number >= thousand) && (number < million)) {
//	    	double fraction = calculateFraction(number, thousand);
//	    	return df2.format(fraction) + "k";
//	        //return Double.toString(fraction) + "M";
//	    }
//	    
//		return df.format(number);
//	
//	}
//	
//	public double calculateFraction(double number, double divisor) {
//	    float truncate = (float) ((number * 10F + (divisor / 2F)) / divisor);
//	    double fraction = truncate * 0.1D;
//	    return fraction;
//	}


	


	
}
