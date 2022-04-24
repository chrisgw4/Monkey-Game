package dungeongamecontents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DungeonPanel extends JPanel{

	private int myWidth;
	private int myHeight;
	
	private int screenHeight, screenWidth;
	
	private Dungeon myDungeon;
	
	public DungeonPanel(int width, int height) {
		screenHeight = height;
		screenWidth = width;
		myWidth = (int) (width*.9);
		myHeight = (int) (height*.9);
		//this.setBounds((int)(width*.05), (int)(height*.05), myWidth, myHeight);
		
		this.setBounds(0, 0, screenWidth, screenHeight);
		
		myDungeon = new Dungeon(myWidth, myHeight, (int)(width*.05), (int)(height*.05));
		myDungeon.getImage();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(0,0,0, 150));
		g2d.fillRect(0, 0, screenWidth, screenHeight);
		myDungeon.draw(g2d);
	}
	
}
