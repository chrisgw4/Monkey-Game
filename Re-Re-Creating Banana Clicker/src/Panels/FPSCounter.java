package Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import objects.Player;

public class FPSCounter extends JPanel{

	
	private static long lastFPSCheck = 0;
	private static int currentFPS = 0;
	private static int totalFrames = 0;
	
	
	public FPSCounter()
	{
		
		this.setBounds(0, 0, 100, 100);
		
	}
	
	public static int getFps() {
		return currentFPS;
	}
	
	public void paintComponent(Graphics g) {
		totalFrames++;
		if (System.nanoTime() > lastFPSCheck+1000000000) {
			lastFPSCheck = System.nanoTime();
			currentFPS = totalFrames;
			totalFrames = 0;
			//System.out.println("FPS " + currentFPS);
		}
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		
		g2d.drawString(String.valueOf(currentFPS), 0, 10);
		
		//System.out.println();
		
	}

	
}
