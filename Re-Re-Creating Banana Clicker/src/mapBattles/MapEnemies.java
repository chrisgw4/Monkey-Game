package mapBattles;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapEnemies extends MapFighters{

	private String myName;
	
	public MapEnemies(double x, double y, String name, int width, int height) {
		super(x, y, name, width, height);
		myName = name;
		// TODO Auto-generated constructor stub
	}

	public void makeImage() {
		try {
			setImage(ImageIO.read(new File("Re-Re-Creating Banana Clicker/Images/MapBattles/Enemies/" + myName + ".png")));
			//img = ImageIO.read(new File("Images/Background/background.png"));
		} catch (IOException e) {}
		
		try {
			setImage(ImageIO.read(new File("Images/MapBattles/Enemies/" + myName + ".png")));
			}
			catch(Exception d) {}
			// TODO Auto-generated catch block
			//e.printStackTrace();
		
	}

	
}
