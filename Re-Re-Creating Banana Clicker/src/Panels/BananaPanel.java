package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import input.MouseInput;
import input.MouseInputBanana;
import input.MouseLocation;
import objects.Background;
import objects.Banana;
import objects.Button;
import objects.ScoreFont;

public class BananaPanel extends JPanel {

	private int width;
	private int height;
	
	private int myX;
	private int myY;
	private int myLength;
	private int myHeight;
	
	private MouseLocation ml;
	
	private MouseInputBanana mi;
	
	private Banana b;
	
//	private TextPanel showCount = new TextPanel();
	
	//private ScoreFont score_font;
	
	
	
	public BananaPanel(int width, int height, MouseLocation ml, MouseInputBanana mi) {
		this.width = width;
		this.height = height;
		b = new Banana(0,0, this.width, this.height);
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setBounds((int) (width*.1), (int) (height*.07), (int) (width*.18), (int) (height*.3));
		
		//score_font = sF;
		
		myX = (int)(width*.1);
		
		myX = (int)(width*.05);
		myY = (int)(height*.07);
		myLength = (int)(width*.18);
		myHeight = (int)(height*.3);
		
		this.ml = ml;
		this.mi = mi;
		
		
		this.ml.setBanana(b);
		this.mi.setBanana(b);
		
		this.mi.setMouseLoc(ml);
		
		
		this.addMouseMotionListener(ml);
		this.addMouseListener(this.mi);
		
		//this.add(showCount);
		
	}
	
	public void paintComponent(Graphics g) {
		//super.paint(g);
		
		
		Graphics2D g2d = (Graphics2D) g;
		
		
		
//		if (!ml.mouseInBanana())
//		{
//			b.setX(b.getXConstant());
//			b.setY(b.getYConstant());
//			b.setWidth(b.getWidthConstant());
//			b.setHeight(b.getHeightConstant());
//		}
		//super.paintComponent(g);
		b.draw(g2d);
		//showCount.updateLabel(g2d);
		
	}
	
	public void changeResolution(int width, int height) {
		this.width = width;
		this.height = height;
		//myX = (int)(width*.1);
		
		myX = (int)(width*.03);
		
		myY = (int)(height*.07);
		myLength = (int)(width*.18);
		myHeight = (int)(height*.3);
		this.setPreferredSize(new Dimension(myLength, myHeight));
		this.setBounds((int) (myX), (int) (height*.07), (int) (width*.18), (int) (height*.3));
		b.changeSize(width, height);
	}

	public void setBanana(Banana banana) {
		b = banana;
	}
	
	public Banana getBanana() {
		return b;
	}

	public int getX() {
		return myX;
	}
	
	public int getY() {
		return myY;
	}
	
	public int getLength() {
		return myLength;
	}
	
	public int getHeight() {
		return myHeight;
	}
	
}
