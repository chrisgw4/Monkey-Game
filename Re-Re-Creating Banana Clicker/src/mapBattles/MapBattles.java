package mapBattles;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;

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

	private EverythingPanel ePanel;
	
	
	public MapBattles(ArrayList<Purchaseable> plist, int width, int height,int pwidth, int pheight, EverythingPanel ep) {
		
		pList = plist;
		scaleEnemies();
		//myImageList = new ArrayList<Image>(plist.size());
		myFightersList = new ArrayList<MapWarriors>(plist.size());
		myEnemiesList = new ArrayList<MapEnemies>(plist.size());

		screenWidth = width;
		screenHeight = height;
		
		panelWidth = pwidth;
		panelHeight = pheight;

		ePanel = ep;
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
					//myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(20*sizeMultiplier), (int)(27*sizeMultiplier)));
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(59*sizeMultiplier), (int)(49*sizeMultiplier)));
					monkeyFighters[0] = monkeyFighters[0]+1;
				}
				else if(pList.get(l).getName().equals("Orangutan") && pList.get(1).getAmountOwned()>0 && monkeyFighters[1] < pList.get(1).getAmountOwned())
				{
					//myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(26*sizeMultiplier), (int)(31*sizeMultiplier)));
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(59*sizeMultiplier), (int)(49*sizeMultiplier)));
					
					monkeyFighters[1] = monkeyFighters[1]+1;
					//System.out.println("BIGGIE CHEESe");
				}
				else if(pList.get(l).getName().equals("Mandrill") && pList.get(2).getAmountOwned()>0 && monkeyFighters[2] < pList.get(2).getAmountOwned())
				{
					//myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(16*sizeMultiplier), (int)(41*sizeMultiplier)));
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(59*sizeMultiplier), (int)(49*sizeMultiplier)));
					
					monkeyFighters[2] = monkeyFighters[2]+1;
				}
				else if(pList.get(l).getName().equals("Chimpanzee") && pList.get(3).getAmountOwned()>0 && monkeyFighters[3] < pList.get(3).getAmountOwned())
				{
					//myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(17*sizeMultiplier), (int)(33*sizeMultiplier)));//pList.get(l).getName()));
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(59*sizeMultiplier), (int)(49*sizeMultiplier)));//pList.get(l).getName()));
					
					monkeyFighters[3] = monkeyFighters[3]+1;
				}
				else if(pList.get(l).getName().equals("Gorilla") && pList.get(4).getAmountOwned()>0 && monkeyFighters[4] < pList.get(4).getAmountOwned())
				{
					//myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(23*sizeMultiplier), (int)(39*sizeMultiplier)));
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(59*sizeMultiplier), (int)(49*sizeMultiplier)));
					
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
		//y = (int)(280*((screenHeight/1080.0)));
		//x = fightersXList.length-1;
		//sizeMultiplier = 1.1;
		
		for(int i = 0; i < myFightersList.size(); i++)
		{
			
			myEnemiesList.add(new MapEnemies(panelWidth*.8, myFightersList.get(i).getY(), "Jaguar", myFightersList.get(i).getWidth(), myFightersList.get(i).getHeight()));
			myEnemiesList.get(i).setSpeed(fightersXMoveList[(int) (Math.random()*fightersXMoveList.length)]);
			//y += myFightersList.get(i).getHeight()-myFightersList.get(i).getHeight()*.6;
			//sizeMultiplier += .3;
		}
		
		
		for(int i = 0; i<myFightersList.size(); i++)
		{
			//myFightersList.get(i).setY(myFightersList.get(i).getY()+20);
			myFightersList.get(i).setX(myFightersList.get(i).getX()-30*i);
			myFightersList.get(i).setSpeed(fightersXMoveList[(int) (Math.random()*fightersXMoveList.length)]);
			//System.out.println("CH");
		}
		for(int i = 0; i<myEnemiesList.size(); i++)
		{
			//myEnemiesList.get(i).setY(myEnemiesList.get(i).getY()-17);
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

	public void drawEnemies(int i, Graphics2D g2d, int[] xList, int[] yList) // i is index
	{
		myEnemiesList.get(i).draw(g2d);
		if(myEnemiesList.get(i).getXIndx() == -1 && myEnemiesList.get(i).getYIndx() == -1)
		{
			myEnemiesList.get(i).setXIndx((int)(Math.random()*xList.length));
			myEnemiesList.get(i).setYIndx((int)(Math.random()*yList.length));
		}
		
		
		if(!myEnemiesList.get(i).isNextToEnemy())
			myEnemiesList.get(i).setX(myEnemiesList.get(i).getX()-myEnemiesList.get(i).getSpeed()*(60.0/ePanel.getFPS()));
		
		if(myEnemiesList.get(i).isNextToEnemy())
		{
			if(!myEnemiesList.get(i).isFinalSaved())
			{
				myEnemiesList.get(i).saveFinalX();
				myEnemiesList.get(i).saveFinalY();
				myEnemiesList.get(i).setFinalSaved(true);
			}
			myEnemiesList.get(i).setX(myEnemiesList.get(i).getFinalX()+(xList[myEnemiesList.get(i).getXIndx()]*3));
			
			myEnemiesList.get(i).setY(myEnemiesList.get(i).getFinalY()+(yList[myEnemiesList.get(i).getYIndx()]*3));

			if(myEnemiesList.get(i).getSpazDelayCounter() >= myEnemiesList.get(i).getSpazDelay()*(ePanel.getFPS()/60.0))
			{
				myEnemiesList.get(i).setXIndx(myEnemiesList.get(i).getXIndx()+1);
				myEnemiesList.get(i).setYIndx(myEnemiesList.get(i).getYIndx()+1);
				myEnemiesList.get(i).resetSpazDelayCounter();
			}
			if(myEnemiesList.get(i).getXIndx() >= xList.length)
				myEnemiesList.get(i).setXIndx(0);
			if(myEnemiesList.get(i).getYIndx() >= yList.length)
			myEnemiesList.get(i).setYIndx(0);
		}
		myEnemiesList.get(i).incrementSpazDelayCounter();
	
		
	}

	public void drawWarriors(int i, Graphics2D g2d, int[] xList, int[] yList) // i is index
	{
		myFightersList.get(i).draw(g2d);
		
		if(myFightersList.get(i).getXIndx() == -1 && myFightersList.get(i).getYIndx() == -1)
		{
			myFightersList.get(i).setXIndx((int)(Math.random()*xList.length));
			myFightersList.get(i).setYIndx((int)(Math.random()*yList.length));
		}
		
		
		
		if(!myFightersList.get(i).isNextToEnemy())
			myFightersList.get(i).setX(myFightersList.get(i).getX()+myFightersList.get(i).getSpeed()*(60.0/ePanel.getFPS()));
		
		if(myFightersList.get(i).isNextToEnemy())
		{
			if(!myFightersList.get(i).isFinalSaved())
			{
				myFightersList.get(i).saveFinalX();
				myFightersList.get(i).saveFinalY();
				myFightersList.get(i).setFinalSaved(true);
			}
			double slopeX = (myFightersList.get(i).getFinalX()+(xList[myFightersList.get(i).getXIndx()]*2) -  myFightersList.get(i).getFinalX());
			double slopeY = (myFightersList.get(i).getFinalY()+(xList[myFightersList.get(i).getYIndx()]*2) -  myFightersList.get(i).getFinalY());
			myFightersList.get(i).setX(myFightersList.get(i).getFinalX()+slopeX*1.2);
			myFightersList.get(i).setY(myFightersList.get(i).getFinalY()+slopeY*1.2);
			// myFightersList.get(i).setX(myFightersList.get(i).getFinalX()+(xList[myFightersList.get(i).getXIndx()]*3));
			
			// myFightersList.get(i).setY(myFightersList.get(i).getFinalY()+(yList[myFightersList.get(i).getYIndx()]*3));

			if(myFightersList.get(i).getSpazDelayCounter() >= myFightersList.get(i).getSpazDelay()*(ePanel.getFPS()/60.0))
				//if((int)(myFightersList.get(i).getX()) == xList[myFightersList.get(i).getXIndx()] + myFightersList.get(i).getFinalX() &&
				   //(int)(myFightersList.get(i).getY()) == yList[myFightersList.get(i).getYIndx()] + myFightersList.get(i).getFinalY())
				{
					myFightersList.get(i).setXIndx(myFightersList.get(i).getXIndx()+1);
					myFightersList.get(i).setYIndx(myFightersList.get(i).getYIndx()+1);
					myFightersList.get(i).resetSpazDelayCounter();
				}
			if(myFightersList.get(i).getXIndx() >= xList.length)
				myFightersList.get(i).setXIndx(0);
			if(myFightersList.get(i).getYIndx() >= yList.length)
				myFightersList.get(i).setYIndx(0);

			// if(xList[myFightersList.get(i).getXIndx()] + myFightersList.get(i).getFinalX() > (int)(myFightersList.get(i).getX()))
			// {
			// 	myFightersList.get(i).setX((int)(myFightersList.get(i).getX())+1);
			// }
			// else if(xList[myFightersList.get(i).getXIndx()] + myFightersList.get(i).getFinalX()< (int)(myFightersList.get(i).getX()))
			// {
			// 	myFightersList.get(i).setX((int)(myFightersList.get(i).getX())-1);
			// }
			// else 
			// {
			// 	myFightersList.get(i).setX(yList[myFightersList.get(i).getXIndx()]+myFightersList.get(i).getX());
			// 	myFightersList.get(i).setXIndx(myFightersList.get(i).getXIndx()+1);
			// }
			// if(yList[myFightersList.get(i).getYIndx()] + myFightersList.get(i).getFinalY()> (int)(myFightersList.get(i).getY()))
			// {
			// 	myFightersList.get(i).setY((int)(myFightersList.get(i).getY())+1);
			// }
			// else if(yList[myFightersList.get(i).getYIndx()] + myFightersList.get(i).getFinalY() < (int)(myFightersList.get(i).getY()))
			// {
			// 	myFightersList.get(i).setY((int)(myFightersList.get(i).getY())-1);
			// }
			// else
			// {
			//  	myFightersList.get(i).setY(yList[myFightersList.get(i).getYIndx()]+myFightersList.get(i).getY());
				
			// 	myFightersList.get(i).setYIndx(myFightersList.get(i).getYIndx()+1);
			// }
			
		}
		myFightersList.get(i).incrementSpazDelayCounter();
	
		
	}
	
	
	public void drawWarriors(Graphics2D g2d) {
		int[] xList = {0, -3, -5, -8, -3,   0,  5,  6, 7, 8,   9};
		int[] yList = {0, -4, -8, -8, -9, -10, -7, -3, 0, -4, -8};

		//int[] xList = {0, -5, -8,   0,  5, 7,  9};
		//int[] yList = {0, -8, -8, -10, -7, 0, -8};
		
		
		for(int i = 0; i < myFightersList.size(); i++)
		{
			
			drawWarriors(i, g2d, xList, yList);
			drawEnemies(i, g2d, xList, yList);
		}
		


		// for(MapEnemies me: myEnemiesList)
		// {
		// 	me.draw(g2d);
		// 	if(me.getXIndx() == -1 && me.getYIndx() == -1)
		// 	{
		// 		me.setXIndx((int)(Math.random()*xList.length));
		// 		me.setYIndx((int)(Math.random()*yList.length));
		// 	}
		// 	//p = (int) (Math.random()*fightersXMoveList.length);
		// 	//System.out.println(p);
		// 	//for(MapFighters mf: myEnemiesList)
		// 	{
		// 		//if(p < this.fightersXMoveList.length && !me.isNextToEnemy())//&& !(mp.getX()+5 > mf.getX()))
		// 		//	me.setX((int)(me.getX()-(this.fightersXMoveList[p])*(60.0/EverythingPanel.getFPSTarget())));
		// 	}
		// 	if(!me.isNextToEnemy())
		// 		me.setX(me.getX()-me.getSpeed()*(60.0/ePanel.getFPS()));
			
		// 	if(me.isNextToEnemy())
		// 	{
		// 		if(!me.isFinalSaved())
		// 		{
		// 			me.saveFinalX();
		// 			me.saveFinalY();
		// 			me.setFinalSaved(true);
		// 		}
		// 		me.setX(me.getFinalX()+(xList[me.getXIndx()]*3));
				
		// 		me.setY(me.getFinalY()+(yList[me.getYIndx()]*3));

		// 		if(me.getSpazDelayCounter() >= me.getSpazDelay()*(ePanel.getFPS()/60.0))
		// 		{
		// 			me.setXIndx(me.getXIndx()+1);
		// 			me.setYIndx(me.getYIndx()+1);
		// 			me.resetSpazDelayCounter();
		// 		}
		// 		if(me.getXIndx() >= xList.length)
		// 			me.setXIndx(0);
		// 		if(me.getYIndx() >= yList.length)
		// 			me.setYIndx(0);
		// 	}
		// 	me.incrementSpazDelayCounter();
		// }
		
		// for(MapFighters mp: myFightersList) 
		// {
		// 	mp.draw(g2d);	
			
		// 	if(mp.getXIndx() == -1 && mp.getYIndx() == -1)
		// 	{
		// 		mp.setXIndx((int)(Math.random()*xList.length));
		// 		mp.setYIndx((int)(Math.random()*yList.length));
		// 	}

		// 	if(!mp.isNextToEnemy())
		// 		mp.setX(mp.getX()+mp.getSpeed()*(60.0/ePanel.getFPS()));
				

		// 	if(mp.isNextToEnemy())
		// 	{
		// 		if(!mp.isFinalSaved())
		// 		{
		// 			mp.saveFinalX();
		// 			mp.saveFinalY();
		// 			mp.setFinalSaved(true);
		// 		}
		// 		mp.setX(mp.getFinalX()+(xList[mp.getXIndx()]*3));
				
		// 		mp.setY(mp.getFinalY()+(yList[mp.getYIndx()]*3));

		// 		if(mp.getSpazDelayCounter() >= mp.getSpazDelay()*(ePanel.getFPS()/60.0))
		// 		{
		// 			mp.setXIndx(mp.getXIndx()+1);
		// 			mp.setYIndx(mp.getYIndx()+1);
		// 			mp.resetSpazDelayCounter();
		// 		}
		// 		if(mp.getXIndx() >= xList.length)
		// 			mp.setXIndx(0);
		// 		if(mp.getYIndx() >= yList.length)
		// 			mp.setYIndx(0);
		// 	}
		// 	mp.incrementSpazDelayCounter();
		// }
		
		for(int g = 0; g < myFightersList.size(); g++)
		{
			if(g < myFightersList.size() && g < myEnemiesList.size())
			{
				if(myFightersList.get(g).getX() >= myEnemiesList.get(g).getX()-myEnemiesList.get(g).getWidth()/2)
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
