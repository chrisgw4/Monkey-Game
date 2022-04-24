package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import Panels.BackgroundPanel;
import Panels.BananaPanel;
import Panels.EverythingPanel;
import Panels.paenltest;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width = 1920;
		int height = 1080;
		
		//System.out.println((double)width/(double)height);
		
		JFrame frame = new JFrame();
		
		
		
		
		
		//frame.setPreferredSize(new Dimension((int)(width+width*.0085), (int)(height+height*.037)));
		//frame.setBounds(0,0,(int)(width+width*.0085), (int)(height+height*.037));
		
		
		frame.setResizable(true);
		
		//frame.setLocation(0,0);
		//frame.setLayout(null);
		frame.setSize(new Dimension((int)(width), (int)(height)));
		//frame.setSize(new Dimension((int)(width+width*.0085), (int)(height+height*.037)));
		
		//frame.setBounds(0, 0,(int)(width+width*.0085), (int)(height+height*.037));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLocationRelativeTo(null);
		
		//frame.add(new BananaPanel(width, height));
		
		//frame.add(new BackgroundPanel(width, height));
		
		//frame.add(new paenltest());
		//frame.add(new EverythingPanel(width,height));
		EverythingPanel p = new EverythingPanel(width,height, frame);
		frame.setContentPane(p);
		
		frame.setVisible(true);
		
		frame.pack();
		while(true)
		{
			p.actionPerformed(null);
		}
		
	}
	
	

	
	
}
