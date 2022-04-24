package objects;

import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.util.ArrayList;




public class Player extends GlobalPosition{
	
	private static double myCount = 0;
	
	// BigInteger class to help hold a larger number than a double
	//private static BigInteger myCount = new BigInteger("0");
	
	private static double myPassiveCount = 0;
	
	private static int battlesCompleted = 0;
	
	private ArrayList<Purchaseable> myWarriors = new ArrayList<Purchaseable>();
	
	private ArrayList<Producers> myProducers = new ArrayList<Producers>();
	
	
	public Player() {
		super(0,0);
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	
	public static int getCompletedBattles() {
		return battlesCompleted;
	}
	
	// when winning and completing a battle this will increment to allow for scaling to occur
	public static void incrementCompletedBattles() {
		battlesCompleted++;
	}
	
	public static double getCount() {
		return myCount;
		//return myCount.toString();
	}
	
	public void setCount(double num) {
		myCount += num;
		//myCount.add(new BigInteger(""+num));
	}
	
	public static double getPassiveCount() {
		return myPassiveCount/100;
	}
	
	public static void setPassiveCount(double num) {
		myPassiveCount += num;
	}
	
	
	
	public void update() {

	}
	
	public ArrayList<Purchaseable> getWarriorList() {
		return this.myWarriors;
	}
	
	public void addToWarriorList(Purchaseable p) {
		this.myWarriors.add(p);
	}
	
	public ArrayList<Producers> getProducerList() {
		return this.myProducers;
	}
	
	public void addToProducerList(Producers p) {
		this.myProducers.add(p);
		
	}

	
	
}