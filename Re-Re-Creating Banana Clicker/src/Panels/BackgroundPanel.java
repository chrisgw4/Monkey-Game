package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.JPanel;

import main.Main;
import objects.Background;

public class BackgroundPanel extends JPanel{

	private int width;
	private int height;
	
	Background b;
	
	
	
	public BackgroundPanel(int width, int height) {
		this.width = width;
		this.height = height;
		b = new Background(width, height);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.black);
		this.setBounds(0, 0, width, height);
		this.setPreferredSize(new Dimension(width, height));
		
	}
	
	public void paintComponent(Graphics g) {
		//super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		b.draw(g2d);
	}

	public void changeResolution(int width, int height) {
		this.width = width;
		this.height = height;
		this.setPreferredSize(new Dimension(width,height));
		this.setBounds(0,0, width, height);
		b.changeSize(width, height);
	}
	
	
	
}
