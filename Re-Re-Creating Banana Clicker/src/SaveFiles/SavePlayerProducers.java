package SaveFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import main.Main;
import objects.Player;
import objects.Producers;
import objects.Purchaseable;

public class SavePlayerProducers {

	private ArrayList<Producers> producerList;
	
	public SavePlayerProducers(ArrayList<Producers> b) {
		producerList = b;
		
		try {
			//String fName= "/SaveTextFiles/PlayerProducers.txt";
			
		      File myProducersFile = new File("PlayerProducers.txt");
		      //InputStream is = Main.class.getResourceAsStream(fName);
		      //File myProducersFile = new File(is);
		      System.out.println(myProducersFile.getAbsolutePath());
		      if (myProducersFile.createNewFile()) {
		        System.out.println("File created: " + myProducersFile.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public void updateFile() {
		try {
	    	FileWriter myWriter = new FileWriter("PlayerProducers.txt");
	    	for (int i = 0; i < producerList.size(); i++) {
	    		myWriter.write(producerList.get(i).getAmountOwned()+"\n");
	    		//myWriter.write("gfgdfg");
	    	}
	    	myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
}
