package Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import objects.Background;

public class paenltest extends JPanel{

	private BackgroundPanel bp = new BackgroundPanel(1920, 1080);
	
	public paenltest() 
	{
		this.setBackground(Color.pink);
		this.setPreferredSize(new Dimension(1920, 1080));
		this.setVisible(true);
		//this.add(bp);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		//bp.paintComponent(g);
		
	}
	
}
