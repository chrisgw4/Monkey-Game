package ReadFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import objects.Player;
import objects.Producers;
import objects.Purchaseable;

public class ReadPlayerBuyables {
	
	private ArrayList<Purchaseable> pList;
	
	public ReadPlayerBuyables(ArrayList<Purchaseable> p, Player player) {
		pList = p;
		
		try {
		      File mySaveFile = new File("PlayerBuyables.txt");
		      Scanner myReader = new Scanner(mySaveFile);
		      int i = 0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        pList.get(i).setAmountOwned((Integer.parseInt(data)));
		        //pList.get(i).setPrice(pList.get(i).getBasePrice() * Math.pow(1.15, pList.get(i).getAmountOwned()));
		        
		        
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
