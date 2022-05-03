package mapBattles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import CountLargeNumbers.NumToWords;
import Panels.EverythingPanel;
import Panels.PurchaseablePanel;
import objects.Player;
import objects.ScoreFont;

public class MapPanelBorder extends JPanel{
    
    private int myWidth;
    private int myHeight;
    private int myX;
    private int myY;

    private Image mapBorder;

    public MapPanelBorder(int x, int y, int width, int height) {
        myWidth = width;
        myHeight = height;
        myX = x;
        myY = y;

        this.setLayout(null);
        this.setSize(myWidth, myHeight);
        this.setLocation(myX, myY);


        try {
			mapBorder = ImageIO.read(new File("Re-Re-Creating Banana Clicker/Images/MapBattles/Map_Border/map_border.png"));
		} catch (IOException e) {}
		
		try {
			mapBorder = ImageIO.read(new File("Images/MapBattles/Map_Border/map_border.png"));
			}
			catch(Exception d) {}
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(mapBorder, 0, 0,(int) (myWidth),(int) (myHeight), null);
    }

    public void changeResolution(int width, int height, int x, int y)
    {
        if(myWidth != width)
        {
            this.setOpaque(false);
            myWidth = (int)(width*1.005);
            myHeight = (int)(height*1.005);
            myX = x;
            myY = y;
            this.setSize(myWidth, myHeight);
            this.setLocation(myX, myY);
        }
    }
}
