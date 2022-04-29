package mapBattles;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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
	
	private int[] fightersXList = {0, 20, 40, 60, 80};
	
	private int[] fightersYList = {8, 16, 24, 32, 40};
	
	private int[] fightersXMoveList = {2, 4, 6, 8};
	
	private int[] fightersYMoveList = {8, 16, 24, 32, 40};
	
	//private ArrayList<String> myWarriorsList = new ArrayList<String>();
	
	//private ArrayList<Image> myImageList;
	
	private ArrayList<MapWarriors> myFightersList;
	
	private ArrayList<MapEnemies> myEnemiesList;
	
	
	public MapBattles(ArrayList<Purchaseable> plist) {
		
		pList = plist;
		scaleEnemies();
		//myImageList = new ArrayList<Image>(plist.size());
		myFightersList = new ArrayList<MapWarriors>(plist.size());
		
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
		int x = 0;
		int y = 100;
		double sizeMultiplier = 1.3;
		
		int[] monkeyFighters = new int[6];
		
		for(int i = 0; i < fightersXList.length; i++)
		{
			fightersXList[i] = (int) (16*sizeMultiplier);
			sizeMultiplier+=0.3;
		}
		sizeMultiplier = 1.1;
		
		// resets the list as to not keep adding more and more
		myFightersList = new ArrayList<MapWarriors>();
		
		for(int i = 0; i < 20; i++)
		{
			for(int l = 0; /*l < Math.random()*10+6 &&*/ myFightersList.size()<20 && pList.get(l).getAmountOwned()>0 && monkeyFighters[l]<10; l++)
			{
				if(i<fightersXList.length)
				{
					fightersXList[i] = (int) (16*sizeMultiplier);
				}
				x = x+1;
				//System.out.println(i);
				if(x >= fightersXList.length)
					x = 0;

				if(pList.get(l).getName().equals("Monkey") && pList.get(0).getAmountOwned()>0 && monkeyFighters[0] < pList.get(0).getAmountOwned())
				{
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(20*sizeMultiplier), (int)(27*sizeMultiplier)));
					monkeyFighters[0] = monkeyFighters[0]+1;
				}
				else if(pList.get(l).getName().equals("Orangutan") && pList.get(1).getAmountOwned()>0 && monkeyFighters[1] < pList.get(1).getAmountOwned())
				{
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(26*sizeMultiplier), (int)(31*sizeMultiplier)));
					monkeyFighters[1] = monkeyFighters[1]+1;
				}
				else if(pList.get(l).getName().equals("Mandrill") && pList.get(2).getAmountOwned()>0 && monkeyFighters[2] < pList.get(2).getAmountOwned())
				{
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(16*sizeMultiplier), (int)(41*sizeMultiplier)));
					monkeyFighters[2] = monkeyFighters[2]+1;
				}
				else if(pList.get(l).getName().equals("Chimpanzee") && pList.get(3).getAmountOwned()>0 && monkeyFighters[3] < pList.get(3).getAmountOwned())
				{
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(17*sizeMultiplier), (int)(33*sizeMultiplier)));//pList.get(l).getName()));
					monkeyFighters[3] = monkeyFighters[3]+1;
				}
				else if(pList.get(l).getName().equals("Gorilla") && pList.get(4).getAmountOwned()>0 && monkeyFighters[4] < pList.get(4).getAmountOwned())
				{
					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(23*sizeMultiplier), (int)(39*sizeMultiplier)));
					monkeyFighters[4] = monkeyFighters[4]+1;
				}
				
				if(i<myFightersList.size())
					y += myFightersList.get(i).getHeight()-myFightersList.get(i).getHeight()*.6;
				sizeMultiplier+= .2;
				//x += myFightersList.get(i).getHeight()/1.5;
//				if (x > myFightersList.get(i).getHeight()/1.5) 
//				{
//					x = 0;
//				}
				
			}

		}
		System.out.println(myFightersList.size() + "FKJOFJSD");
		
		
		
//		for (int l = 0; l < pList.size() && myFightersList.size() <= 40; l++) 
//		{
//			
//			
//			for(int i = l; i < pList.get(l).getAmountOwned() && myFightersList.size() <= 10*(l+1); i++)
//			{
//				//System.out.println("SDD");
//				if(i<fightersXList.length)
//				{
//					fightersXList[i] = (int) (16*sizeMultiplier);
//				}
//				x = x+1;
//				//System.out.println(i);
//				if(x >= fightersXList.length)
//					x = 0;
//
//				if(pList.get(l).getName().equals("Monkey"))
//					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(20*sizeMultiplier), (int)(27*sizeMultiplier)));
//				else if(pList.get(l).getName().equals("Orangutan"))
//					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(26*sizeMultiplier), (int)(31*sizeMultiplier)));
//				else if(pList.get(l).getName().equals("Mandrill"))
//					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(16*sizeMultiplier), (int)(41*sizeMultiplier)));
//				else if(pList.get(l).getName().equals("Gorilla"))
//					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(23*sizeMultiplier), (int)(39*sizeMultiplier)));
//				else if(pList.get(l).getName().equals("Chimpanzee"))
//					myFightersList.add(new MapWarriors(fightersXList[x], y, pList.get(l).getName(), (int)(17*sizeMultiplier), (int)(33*sizeMultiplier)));//pList.get(l).getName()));
//				if(i<myFightersList.size())
//					y += myFightersList.get(i).getHeight()-myFightersList.get(i).getHeight()*.6;
//				sizeMultiplier+= .2;
//				//x += myFightersList.get(i).getHeight()/1.5;
////				if (x > myFightersList.get(i).getHeight()/1.5) 
////				{
////					x = 0;
////				}
//				
//			}
//		}
		for(MapWarriors mp: myFightersList) 
		{
			mp.makeImage();
		}
	}
	
	
	public void drawWarriors(Graphics2D g2d) {
//		for(String str: myWarriorsList)
//		{
//			try {
//				g2d.drawImage(null, 0, 0, 0, 0, null, null);
//			}
//			catch(Exception e) {
//				
//			}
//		}
		int i = 0;
		int p = 0;
		for(MapFighters mp: myFightersList) 
		{
			mp.draw(g2d);
			if(i<fightersYList.length && mp.getY() <= fightersYList[i])
			{
				mp.setY(mp.getY()+fightersYList[i]);
				i++;
			}
			else if (mp.getY() <= fightersYList[i])
				mp.setY(mp.getY()+ fightersYList[i-1]+fightersYList[0]);
			//System.out.println("CHS");
			p = (int) (Math.random()*fightersXMoveList.length);
			System.out.println(p);
			//for(MapFighters mf: myEnemiesList)
			{
				if(p < this.fightersXMoveList.length )//&& !(mp.getX()+5 > mf.getX()))
					mp.setX(mp.getX()+this.fightersXMoveList[p]);
			}
			
			
//			else
//			{
//				//p = 0;
//				mp.setX(mp.getX()+this.fightersXMoveList[p]);
//			}
			//p++;
		}
		
	}
	
	public void startBattle() {
		numOfFighters = 0;
		if(!battleStarted)
		{
			makeMonkeyFightersList();
			for (Purchaseable p: pList) 
			{
				numOfFighters += p.getAmountOwned()*((Warriors)(p)).getHitPoints();
				((Warriors)p).updateTempOwned();
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
		System.out.println(numOfEnemies);
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

	

	
}
