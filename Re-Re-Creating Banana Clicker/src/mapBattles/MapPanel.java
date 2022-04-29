package mapBattles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import CountLargeNumbers.NumToWords;
import Panels.PurchaseablePanel;
import objects.Button;
import objects.Player;
import objects.ScoreFont;

public class MapPanel extends JPanel{

	private int screenWidth;
	private int screenHeight;
	
	private int myHeight;
	private int myWidth;
	
	private int myX;
	private int myY;
	
	private MapBattles mapBattle;
	
	private Button startButton;
	
	private Button b;
	
	private int battleDelay = 0;
	
	private int WinOrLoseScreenDelay = 0;
	private boolean showWinOrLoseScreen = false;
	
	private ScoreFont sf = new ScoreFont(16);
	
	private Player player;
	
	public MapPanel(int width, int height, PurchaseablePanel pp, Player p) {
		screenWidth = width;
		screenHeight = height;
		
		myWidth = (int) (width * .47);
		myHeight = (int) (height * .6);
		
		myX = (int) (width * .47);
		
		myX = (int) (width * .5);
		myY = (int) (height * .05);
		
		player = p;
		
		this.setLayout(null);
		this.setBounds(myX, myY, myWidth, myHeight);
		
		mapBattle = new MapBattles(pp.getPurchaseList());
		
		startButton = new Button(myWidth, myHeight, width, height);
		//this.add(startButton);
		//b = new Button(myWidth, myHeight);
		this.add(startButton);
	}
	
	public void update() {
		if(mapBattle.isStarted())
		{
			if(this.battleDelay >= 200)//18)
			{
				battleDelay = 0;
				//mapBattle.determineBattle();
				// passes player through to add or subtract bananas based on win or lose
				mapBattle.endBattle(player);
				//System.out.println("CHEE");
			}
			battleDelay++;
		}
		
		if(mapBattle.getWinOrLose().equals("You Win") || mapBattle.getWinOrLose().equals("You Lose"))
		{
			showWinOrLoseScreen = true;
		}
		
		if(WinOrLoseScreenDelay == 60) 
		{
			WinOrLoseScreenDelay = 0;
			showWinOrLoseScreen = false;
			mapBattle.clearWinLose();
		}
		
		// Checks whether the button is pressed  // 2nd && checks to make sure you arent in a win or lose screen
		if(startButton.getModel().isPressed() && !mapBattle.isStarted() && !(mapBattle.getWinOrLose().equals("You Win") || mapBattle.getWinOrLose().equals("You Lose"))) //(e.getSource() == startButton)
		{
			startButton.setPressed(true);
			// Starts the battle when pressed
			mapBattle.startBattle();
			//System.out.println("CHEESE");
		}
		else if (!startButton.getModel().isPressed())
		{
			startButton.setPressed(false);
		}
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		super.paintComponent(g);
		
		if(showWinOrLoseScreen) {
			ScoreFont sf2 = new ScoreFont(24*(screenWidth/1920));
			g2d.setFont(sf2.getScoreFont());
			//g2d.getFontMetrics().stringWidth(mapBattle.getWinOrLose()
			//sf2.getScoreFont().getStringBounds(mapBattle.getWinOrLose(), null).getWidth())
			g2d.setColor(new Color(0,0,0,60));
			
			g2d.fillRect(0, 0, myWidth, myHeight);
			if(mapBattle.getWinOrLose().equals("You Lose"))
				g2d.setColor(Color.red);
			else
				g2d.setColor(Color.blue);
			WinOrLoseScreenDelay++;
			
			g2d.drawString(mapBattle.getWinOrLose(), (int) (myWidth/2-g2d.getFontMetrics().stringWidth(mapBattle.getWinOrLose())/1.5), myHeight/2);
			g2d.setColor(Color.black);
			
			
		}
		g2d.setFont(sf.getScoreFont());
		g2d.drawString(NumToWords.NumToWord(mapBattle.getNumOfEnemies())+"", 0, 150);
		g2d.drawString(NumToWords.NumToWord(mapBattle.getNumOfFighters())+"", 0, 200);
		
		if(mapBattle.isStarted())
			mapBattle.drawWarriors(g2d);
	}
	
	public void changeResolution(int width, int height) {
		screenWidth = width;
		screenHeight = height;
		myWidth = (int) (width * .47);
		myHeight = (int) (height * .6);
		myX = (int) (width * .5);
		myY = (int) (height * .05);
		
		this.setBounds(myX, myY, myWidth, myHeight);
		
		
		startButton.changeResolution(myWidth, myHeight, width);
		
	}

	
	
}
