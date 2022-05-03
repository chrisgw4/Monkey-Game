package mapBattles;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Panels.EverythingPanel;
import objects.Player;
import objects.Purchaseable;
import objects.Warriors;

public class MapBattles {
	
	private double baseEnemies = 100;
	
	private double numOfEnemies = 0;
	
	private ArrayList<Purchaseable> pList;
	
	private double numOfFighters = 0;
	
	private boolean battleStarted = false;
	
	private String winOrlose = "";
	
	private int[] fightersXList =  {0, 40, 80, 120, 160};//{0, 20, 40, 60, 80};
	
	private int[] fightersYList = {32, 40, 48, 56, 64};//{8, 16, 24, 32, 40};
	
	private int[] fightersXMoveList = {2, 4, 6, 8, 10};
	
	private int[] fightersYMoveList = {8, 16, 24, 32, 40};
	
	//private ArrayList<String> myWarriorsList = new ArrayList<String>();
	
	//private ArrayList<Image> myImageList;
	
	private ArrayList<MapWarriors> myFightersList;
	
	private ArrayList<MapEnemies> myEnemiesList;

	private int screenWidth;
	private int screenHeight;
	
	private int panelWidth;
	private int panelHeight;
	
	
	public MapBattles(ArrayList<Purchaseable> plist, int width, int height,int pwidth, int pheight) {
		
		pList = plist;
		scaleEnemies();
		//myImageList = new ArrayList<Image>(plist.size());
		myFightersList = new ArrayList<MapWarriors>(plist.size());
		myEnemiesList = new ArrayList<MapEnemies>(plist.size());

		screenWidth = width;
		screenHeight = height;
		
		panelWidth = pwidth;
		panelHeight = pheight;
	}
	
	
	public double getNumOfEnemies() {
		return numOfEnemies;
	}
	// resets numOfFighters and recounts to account for changes
	public double getNumOfFighters() {
		numOfFighters = 0;
		int i = 0;
		//makeMonkeyFightersList();
		for (Purchaseable p: pList) 
		{
			numOfFighters += p.getAmountOwned()*((Warriors)(p)).getHitPoints();
			//myWarriorsList.add(i, p.getName());
			
			i++;
		}
		return numOfFighters;
	}
	
	
	// makes list
	public void makeMonkeyFightersList() {
		int x = fightersXList.length-1;
		int y = (int)(280*((screenHeight/1080.0)));//(screenWidth/1920.0)));
		double sizeMultiplier = 1.3;
		int length = 59;
		int height = 49;
		
		int[] monkeyFighters = new int[6];
		
		for(int i = 0; i < fightersXList.length; i++)
		{
			fightersXList[i] = (int) (16*sizeMultiplier);
			sizeMultiplier+=0.3;
		}
		sizeMultiplier = 1.1;
		
		/* resets the list as to not keep adding more and  */
		myFightersList = new ArrayList<MapWarriors>();
		myEnemiesList = new ArrayList<MapEnemies>();
		
		for(int i = 0; i < 20; i++)
		{
			for(int l = 0; /*l < Math.random()*10+6 &&*/ myFightersList.size()<15 && l < pList.size() /*pList.get(l).getAmountOwned()>0 && monkeyFighters[l]<10*/; l++)
			{
				int prevSize = myFightersList.size();
				if(i<fightersXList.length)
				{
					fightersXList[i] = (int) (16*sizeMultiplier);
				}
				x = x-1;
				//System.out.println(i);
				if(x < 0)
					x = 0;
				
				//System.out.println(l);
				/* adds the respective monkey to the list for the battle */
				if(pList.get(l).getName().equals("Monkey") && pList.get(0).getAmountOwned()>0 && monkeyFighters[0] < pList.get(0).getAmountOwned())
				{
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(20*sizeMultiplier), (int)(27*sizeMultiplier)));
					//myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(length*sizeMultiplier), (int)(height*sizeMultiplier)));
					monkeyFighters[0] = monkeyFighters[0]+1;
				}
				else if(pList.get(l).getName().equals("Orangutan") && pList.get(1).getAmountOwned()>0 && monkeyFighters[1] < pList.get(1).getAmountOwned())
				{
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(26*sizeMultiplier), (int)(31*sizeMultiplier)));
					//myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(length*sizeMultiplier), (int)(height*sizeMultiplier)));
					
					monkeyFighters[1] = monkeyFighters[1]+1;
					//System.out.println("BIGGIE CHEESe");
				}
				else if(pList.get(l).getName().equals("Mandrill") && pList.get(2).getAmountOwned()>0 && monkeyFighters[2] < pList.get(2).getAmountOwned())
				{
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(16*sizeMultiplier), (int)(41*sizeMultiplier)));
					//myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(length*sizeMultiplier), (int)(height*sizeMultiplier)));
					
					monkeyFighters[2] = monkeyFighters[2]+1;
				}
				else if(pList.get(l).getName().equals("Chimpanzee") && pList.get(3).getAmountOwned()>0 && monkeyFighters[3] < pList.get(3).getAmountOwned())
				{
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(17*sizeMultiplier), (int)(33*sizeMultiplier)));//pList.get(l).getName()));
					//myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(length*sizeMultiplier), (int)(height*sizeMultiplier)));//pList.get(l).getName()));
					
					monkeyFighters[3] = monkeyFighters[3]+1;
				}
				else if(pList.get(l).getName().equals("Gorilla") && pList.get(4).getAmountOwned()>0 && monkeyFighters[4] < pList.get(4).getAmountOwned())
				{
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(23*sizeMultiplier), (int)(39*sizeMultiplier)));
					//myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(length*sizeMultiplier), (int)(height*sizeMultiplier)));
					
					monkeyFighters[4] = monkeyFighters[4]+1;
				}
				
				/* checks to see if any monkey was added to list to determine if it has to change the Y location and size */
				if(i<myFightersList.size() && prevSize < myFightersList.size())
				{
					
					
					y += myFightersList.get(i).getHeight()-myFightersList.get(i).getHeight()*.6;
					sizeMultiplier += .3;
					
					//myEnemiesList.add(new MapEnemies(300,myFightersList.get(0).getY(), "Jaguar", 64, 64));
				}
				
			
				
			}
			

		}
		y = (int)(280*((screenHeight/1080.0)));
		//x = fightersXList.length-1;
		sizeMultiplier = 1.1;
		
		for(int i = 0; i < myFightersList.size(); i++)
		{
			
			myEnemiesList.add(new MapEnemies(panelWidth*.8, myFightersList.get(i).getY()*.99, "Jaguar", (int)(59*sizeMultiplier), (int)(49*sizeMultiplier)));
			myEnemiesList.get(i).setSpeed(fightersXMoveList[(int) (Math.random()*fightersXMoveList.length)]);
			y += myEnemiesList.get(i).getHeight()*.4;
			sizeMultiplier += .3;
		}
		
		
		for(int i = 0; i<myFightersList.size(); i++)
		{
			myFightersList.get(i).setY(myFightersList.get(i).getY()+20);
			myFightersList.get(i).setX(myFightersList.get(i).getX()-30*i);
			myFightersList.get(i).setSpeed(fightersXMoveList[(int) (Math.random()*fightersXMoveList.length)]);
			//System.out.println("CH");
		}
		for(int i = 0; i<myEnemiesList.size(); i++)
		{
			myEnemiesList.get(i).setY(myEnemiesList.get(i).getY()-17);
			myEnemiesList.get(i).setX(myEnemiesList.get(i).getX()+32*i);
		}
		
		
		

		for(MapEnemies me: myEnemiesList)
		{
			me.makeImage();
		}
		
		for(MapWarriors mp: myFightersList) 
		{
			mp.makeImage();
		}

		for (Purchaseable p: pList) 
		{
			((Warriors)p).updateTempOwned();
		}
	}
	
	
	public void drawWarriors(Graphics2D g2d) {
		int i = 0;
		int p = 0;
		
		for(MapEnemies me: myEnemiesList)
		{
			me.draw(g2d);
			//p = (int) (Math.random()*fightersXMoveList.length);
			//System.out.println(p);
			//for(MapFighters mf: myEnemiesList)
			{
				//if(p < this.fightersXMoveList.length && !me.isNextToEnemy())//&& !(mp.getX()+5 > mf.getX()))
				//	me.setX((int)(me.getX()-(this.fightersXMoveList[p])*(60.0/EverythingPanel.getFPSTarget())));
			}
			if(!me.isNextToEnemy())
				me.setX(me.getX()-me.getSpeed());
			
			if(me.isNextToEnemy())
			{
				
			}
		}
		
		for(MapFighters mp: myFightersList) 
		{
			mp.draw(g2d);		

			if(!mp.isNextToEnemy())
				mp.setX(mp.getX()+mp.getSpeed());
		}
		
		for(int g = 0; g < myFightersList.size(); g++)
		{
			if(g < myFightersList.size() && g < myEnemiesList.size())
			{
				if(myFightersList.get(g).myX >= myEnemiesList.get(g).getX()-15)
				{
					myFightersList.get(g).setNextToEnemy(true);
					myEnemiesList.get(g).setNextToEnemy(true); 
				}
			}
		}
		
	}
	
	public void startBattle() {
		numOfFighters = 0;
		if(!battleStarted)
		{
			//makeMonkeyFightersList();
			for (Purchaseable p: pList) 
			{
				numOfFighters += p.getAmountOwned()*((Warriors)(p)).getHitPoints();
				//((Warriors)p).updateTempOwned();
			}
			battleStarted = true;
		}
	}
	
	public boolean determineBattle() {
		if(numOfFighters >= numOfEnemies)
		{
			return true;
		}
		return false;
	}
	
	public void endBattle(Player player) {
		if(determineBattle())
		{
			//for(double l = numOfEnemies; l>0;)
			// adds a bonus to player for winning the match
			player.setCount(numOfEnemies*2.5);
			while(numOfEnemies > 0)
			{
				for (Purchaseable p: pList) 
				{
					if(p.getAmountOwned()>0)
					{
						if(numOfEnemies > ((Warriors)p).getHitPoints())
							p.setAmountOwned(p.getAmountOwned()-1);
						numOfEnemies -= ((Warriors)p).getHitPoints();
						
					}
				}
			}
			this.winOrlose = "You Win";
			// adds to player the amount of wins
			Player.incrementCompletedBattles();
			// adds to players count of bananas
			
			scaleEnemies();
		}
		else if(!determineBattle()) {
			for (Purchaseable p: pList) 
			{
				//p.setAmountOwned((int)(p.getAmountOwned()-p.getAmountOwned()*.4));
				((Warriors)p).setAmountOwned((int)(p.getAmountOwned()-((Warriors)p).getTempOwned()*.4));
				
			}
			this.winOrlose = "You Lose";
			if(player.getCount() > numOfEnemies*1.5 && numOfFighters >= numOfEnemies*.6)
				player.setCount(numOfEnemies*-1.5);
		}
		//System.out.println(this.numOfFighters);
		//System.out.println(numOfEnemies);
		numOfFighters = 0;
		battleStarted = false;
		if(numOfEnemies < 0)
		{
			numOfEnemies = 0;
		}
		
	}
	
	public String getWinOrLose() {
		return this.winOrlose;
	}
	// sets string to blank "" to prevent forever loop of displaying You Lose/You Win
	public void clearWinLose() {
		winOrlose = "";
	}
	
	public void scaleEnemies() {
		numOfEnemies = baseEnemies*Math.pow(1.08, Player.getCompletedBattles());
	}
	
	public boolean isStarted() {
		return battleStarted;
	}

	public void changeResolution(int width, int height, int pwidth, int pheight) {
		screenWidth = width;
		screenHeight = height;
		panelWidth = pwidth;
		panelHeight = pheight;
	}

	
}
