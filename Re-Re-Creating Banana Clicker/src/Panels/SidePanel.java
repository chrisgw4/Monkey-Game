package Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class SidePanel extends JPanel {

	
	private int screenWidth;
	private int screenHeight;
	
	private int myHeight;
	private int myWidth;
	
	private int myX;
	private int myY;
	
	public SidePanel(int width, int height) {
		screenWidth = width;
		screenHeight = height;
		
//		myHeight = (int) (height*.06);
//		myWidth = (int) (width);
//		
//		myX = (int) (width*.90*0);
//		myY = 0;
		
		myHeight = (int) (height*.3);
		myWidth = (int) (width*.04);
		
		myX = (int) (width*.30);
		myY = (int) (height*.08);
		
		this.setBounds(myX, myY, myWidth, myHeight);
		this.setBackground(Color.PINK);
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//super.paintComponent(g);
	}
	
}
