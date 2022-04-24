package ReadFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import objects.Player;
import objects.Producers;

public class ReadPlayerProducers {

	private ArrayList<Producers> producerList;
	
	public ReadPlayerProducers(ArrayList<Producers> p, Player player) {
		producerList = p;
		
		try {
		      File mySaveFile = new File("PlayerProducers.txt");
		      Scanner myReader = new Scanner(mySaveFile);
		      int i = 0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        producerList.get(i).setAmountOwned((Integer.parseInt(data)));
		        producerList.get(i).setPrice(producerList.get(i).getBasePrice() * Math.pow(1.15, producerList.get(i).getAmountOwned()));
		        //for(int l = 0; l < Integer.parseInt(data); l++)
		        {
		        	//player.addToProducerList(producerList.get(i));
		        	Player.setPassiveCount(producerList.get(i).getProductionAmount()*100*Integer.parseInt(data));
		        }
		        
		        //System.out.println(data);
		        i++;
		        //System.out.println(i);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      //System.out.println("An error occurred.");
		      //e.printStackTrace();
		    }
	}
	
	
	
}
