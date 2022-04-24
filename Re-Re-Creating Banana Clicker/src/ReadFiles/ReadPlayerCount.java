package ReadFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import objects.Player;

public class ReadPlayerCount {

	public ReadPlayerCount(Player p) {

	    try {
	      File mySaveFile = new File("PlayerData.txt");
	      Scanner myReader = new Scanner(mySaveFile);
	      int i = 0;
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        //p.setCount(Double.MAX_VALUE);//Double.parseDouble(data));
	        try {
	        if(i == 0)
	        {
	        	p.setCount(Double.parseDouble(data));
	        	i++;
	        }
	        else
	        	for(double l = Double.parseDouble(data); l>0; l--)
	        	{
	        		Player.incrementCompletedBattles();
	        		System.out.println(Player.getCompletedBattles());
	        	}
	        }
	        catch(Exception e) { 
	        	//e.printStackTrace();
	        }
	        //System.out.println(data);
	       
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
}
