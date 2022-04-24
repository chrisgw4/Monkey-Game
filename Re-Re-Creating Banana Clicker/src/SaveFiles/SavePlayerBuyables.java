package SaveFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import objects.Player;
import objects.Purchaseable;

public class SavePlayerBuyables {

	private ArrayList<Purchaseable> buyableList;
	
	public SavePlayerBuyables(ArrayList<Purchaseable> b) {
		buyableList = b;
		
		try {
		      File myBuyablesFile = new File("PlayerBuyables.txt");
		      System.out.println(myBuyablesFile.getAbsolutePath());
		      if (myBuyablesFile.createNewFile()) {
		        System.out.println("File created: " + myBuyablesFile.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public void updateFile() 
	{
	    try {
	    	FileWriter myWriter = new FileWriter("PlayerBuyables.txt");
	    	for (int i = 0; i < buyableList.size(); i++) {
	    		myWriter.write(buyableList.get(i).getAmountOwned()+"\n");
	    		//myWriter.write("gfgdfg");
	    	}
	    	myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
