package SaveFiles;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

import objects.Player;

public class SavePlayerCount {

	public SavePlayerCount()
	{
		try {
		      File mySaveFile = new File("PlayerData.txt");
		      System.out.println(mySaveFile.getAbsolutePath());
		      if (mySaveFile.createNewFile()) {
		        System.out.println("File created: " + mySaveFile.getName());
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
	    	FileWriter myWriter = new FileWriter("PlayerData.txt");
	    	myWriter.write("Total Bananas:");
	    	myWriter.write(System.getProperty( "line.separator" ));
			myWriter.write(Player.getCount()+"");
			myWriter.write(System.getProperty( "line.separator" ));
			myWriter.write("Completed Battles:");
			myWriter.write(System.getProperty( "line.separator" ));
			myWriter.write(Player.getCompletedBattles()+"");
			//System.out.println(Player.getCompletedBattles());
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	  
	
}
