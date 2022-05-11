package Power_Ups;


import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Power_up {
    

    private Image myImg;

    public Power_up()
    {


        try {
			myImg = ImageIO.read(new File("Re-Re-Creating Banana Clicker/Images/Power_Ups/The_Blue_Stuff.png"));
		} catch (IOException e) {}
        try {
			myImg = ImageIO.read(new File("Images/Power_Ups/The_Blue_Stuff.png"));
		} catch (IOException e) {}
    }

    public void paint(Graphics2D g2d) {
        g2d.drawImage(myImg, 20, 100, 27*3, 44*3, null);
    }





}
