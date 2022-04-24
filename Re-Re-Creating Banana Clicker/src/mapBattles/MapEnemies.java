package mapBattles;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapEnemies extends MapFighters{

	
	public MapEnemies(double x, double y, String name, int width, int height) {
		super(x, y, name, width, height);
		// TODO Auto-generated constructor stub
	}

	public void makeImage() {
		try {
			setImage(ImageIO.read(new File("Images/Enemies/" + getName() + ".png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	
}
