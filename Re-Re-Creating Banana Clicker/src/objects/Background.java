package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.Main;

public class Background {

	int myWidth;
	int myHeight;
//	private String myImage = "/Images/Background/background.png";
	
	//private Path var = Paths.get(myImage, "background.png");
	
	//private String fName = "/Images/Background/" + "img" + ".png";
	//private String is = Main.class.getResource(fName).toExternalForm();
	//private Image image;
	
	private Image img; 
	
//	private String localdir = System.getProperty("user.dir");
//	File file = new File(myImage);
//	File directory = new File(localdir + "Images/Background/background.png");
	
	
	public Background(int width, int height) {
		myWidth = width;
		myHeight = height;
		//System.out.println(file.isAbsolute());
//		System.out.println(directory.canRead());
//		try {
//			image = ImageIO.read(is);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//System.out.println(directory.getAbsolutePath());
		try {
			img = ImageIO.read(new File("Re-Re-Creating Banana Clicker/Images/Background/background.png"));
			//img = ImageIO.read(new File("Images/Background/background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(img, 0, -39, myWidth, myHeight, null);
		
	}
	
	public void changeSize(int width, int height) {
		myHeight = height;
		myWidth = width;
	}
	
	
	
//	public Image getBackgroundImage() {
//		Image i = new ImageIcon(getClass().getResource(myImage)).getImage();
//		//i = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource(myImage));
//		//File p = new File(is.toString());
//		//System.out.println(file.getPath());
//		return i;
//	}
	
	//public File getFilePath() {
		//File fileToFind = new File(fName);
		//return fileToFind;
	//}

}
