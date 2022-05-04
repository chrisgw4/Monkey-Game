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
	
	private int startDelay = 0;
	
	private boolean startMapBattleDelay = false;
	
	private int WinOrLoseScreenDelay = 0;
	private boolean showWinOrLoseScreen = false;
	
	private ScoreFont sf = new ScoreFont(16);
	
	private Player player;
	
	private EverythingPanel ePanel;
	
	private Image myBackgroundImg;
	private Image myFightSignImg;
	private Image myStartScreen;
	
	private ArrayList<Image> screen_wipe_imgs;
	private boolean screenWiping = false;
	private int screen_wipe_delay;
	private int screen_wipe_delay_counter;
	private int screen_wipe_frame;

	private Image mapBorder;


	private ArrayList<Image> fight_sign_imgs;
	private int fight_sign_frame;
	private int fight_sign_frame_delay;
	private int fight_sign_frame_delay_counter;

	private boolean drawBackground = false;

	private StartButton sButton;

	
	
	public MapPanel(int width, int height, PurchaseablePanel pp, Player p, EverythingPanel ep) {
		screenWidth = width;
		screenHeight = height;
		
		myWidth = (int) (width * .46);//.51/*.49.47*/);
		myHeight = (int) (height * .6);//.63/*.6*/);
		
		ePanel = ep;
		
		myX = (int) (width * .47);
		
		myX = (int) (width * .47/*.5*/);
		myY = (int) (height * .47/*.05*/);
		
		player = p;
		
		this.setLayout(null);
		this.setBounds(myX, myY, myWidth, myHeight);
		
		mapBattle = new MapBattles(pp.getPurchaseList(), screenWidth, screenHeight, myWidth, myHeight, ep);
		
		startButton = new Button(myWidth, myHeight, width, height);
		sButton = new StartButton(myWidth,myHeight,screenWidth,screenHeight);

		

		

		//this.add(startButton);
		//b = new Button(myWidth, myHeight);
		//this.add(startButton);

		//this.add(mpb);

		this.add(sButton);
		
		
		startButton.setBounds(0, 0, 100, 100);
		
		screen_wipe_imgs = new ArrayList<Image>(14);
		screen_wipe_frame = 0;
		screen_wipe_delay = 2;
		screen_wipe_delay_counter = 0;

		fight_sign_imgs = new ArrayList<Image>(37);
		fight_sign_frame = 0;
		fight_sign_frame_delay = 4;
		fight_sign_frame_delay_counter = 0;
		
		try {
			myBackgroundImg = ImageIO.read(new File("Re-Re-Creating Banana Clicker/Images/MapBattles/Background/background.png"));
		} catch (IOException e) {}
		
		try {
			myBackgroundImg = ImageIO.read(new File("Images/MapBattles/Background/background.png"));
			}
			catch(Exception d) {}
		

		try {
			myFightSignImg = ImageIO.read(new File("Re-Re-Creating Banana Clicker/Images/MapBattles/Fight_Sign/fight_sign.png"));
		} catch (IOException e) {}
		try {
			myFightSignImg = ImageIO.read(new File("Images/MapBattles/Fight_sign/fight_sign.png"));
			} catch(Exception d) {}

		try {
			for(int i = 1; i < 38; i++)
			{
				fight_sign_imgs.add(ImageIO.read(new File("Re-Re-Creating Banana Clicker/Images/MapBattles/Fight_Sign/Fight_Sign0-" + i + ".png")));
			}
		} catch (IOException e) {}
		try {
			for(int i = 1; i < 38; i++)
			{
				fight_sign_imgs.add(ImageIO.read(new File("Images/MapBattles/Fight_Sign/Fight_Sign0-" +  i + ".png")));
			}
			} catch(Exception d) {}

		try {
			myStartScreen = ImageIO.read(new File("Re-Re-Creating Banana Clicker/Images/MapBattles/Start_Screen/Start_Screen.png"));
		} catch(Exception e) {}

		try {
			myStartScreen = ImageIO.read(new File("Images/MapBattles/Start_Screen/Start_Screen.png"));
		} catch(Exception e) {}

		try {
			for(int i = 1; i < 15; i++)
			{
				screen_wipe_imgs.add(ImageIO.read(new File("Re-Re-Creating Banana Clicker/Images/MapBattles/Screen_Wipe/Screen_Wipe0-" +  i + ".png")));
			}
			} catch(Exception d) {}

		try {
			for(int i = 1; i < 15; i++)
			{
				screen_wipe_imgs.add(ImageIO.read(new File("Images/MapBattles/Screen_Wipe/Screen_Wipe0-" +  i + ".png")));
			}
			} catch(Exception d) {}

		try {
			mapBorder = ImageIO.read(new File("Re-Re-Creating Banana Clicker/Images/MapBattles/Map_Border/map_border.png"));
		} catch (IOException e) {}
		
		try {
			mapBorder = ImageIO.read(new File("Images/MapBattles/Map_Border/map_border.png"));
			}
			catch(Exception d) {}
	
	}
	
	public void update() {
		if(mapBattle.isStarted())
		{
			//System.out.println(ePanel.getFPS());
			if(this.battleDelay >= 900*(ePanel.getFPS()/60.0))//18)
			{
				//System.out.println(200*(ePanel.getFPS()/60));
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
		
		if(WinOrLoseScreenDelay == 60*(ePanel.getFPS()/60.0)) 
		{
			WinOrLoseScreenDelay = 0;
			showWinOrLoseScreen = false;
			mapBattle.clearWinLose();
			sButton.setBattleRunning(false);
			drawBackground = false;
		}
		
		// Checks whether the button is pressed  // 2nd && checks to make sure you arent in a win or lose screen
		if(sButton.getPressed() && !mapBattle.isStarted() && !(mapBattle.getWinOrLose().equals("You Win") || mapBattle.getWinOrLose().equals("You Lose")))//(startButton.getModel().isPressed() && !mapBattle.isStarted() && !(mapBattle.getWinOrLose().equals("You Win") || mapBattle.getWinOrLose().equals("You Lose"))) //(e.getSource() == startButton)
		{
			fight_sign_frame = 0;
			//startButton.setPressed(true);
			sButton.setPressed(false);
			startMapBattleDelay = true;
			mapBattle.makeMonkeyFightersList();
			//drawBackground = true;
			sButton.setBattleRunning(true);

			screenWiping = true;

			mapBattle.determineBattle();
			
			// Starts the battle when pressed
			
			
		}
		else if (!startButton.getModel().isPressed())
		{
			startButton.setPressed(false);
		}
		
		// checks to make sure that button was clicked and screen wiping has finished
		if(startMapBattleDelay && !screenWiping)
		{
			startDelay++;
			fight_sign_frame_delay_counter++;

			if(fight_sign_frame_delay_counter >= fight_sign_frame_delay*(ePanel.getFPS()/60.0))
			{
				fight_sign_frame++;
				fight_sign_frame_delay_counter = 0;
			}
			if(fight_sign_frame >= 38)
			{
				fight_sign_frame = 0;
			}
		}
		if(startDelay >= 120*(ePanel.getFPS()/60.0) && (fight_sign_frame >= 37 || fight_sign_frame == 0) && !mapBattle.isStarted()) /* make it 125 to keep the top part of the sign "the wire" broken*/
		{
			mapBattle.startBattle();
			
			startMapBattleDelay = false;
			startDelay = 0;
		}
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		
		//sButton.draw(g2d);
		
		
		
		if(drawBackground)
			g2d.drawImage(myBackgroundImg, (int)(myWidth*.01), (int)(myHeight*.011),(int) (myWidth),(int) (myHeight), null);
		else 
			g2d.drawImage(myStartScreen,(int)(myWidth*.01), (int)(myHeight*.011),(int) (myWidth),(int) (myHeight), null);
		
		if(screenWiping)
		{
			g2d.drawImage(screen_wipe_imgs.get(screen_wipe_frame), 0, 0, myWidth, myHeight, null);
			screen_wipe_delay_counter++;

			if(screen_wipe_delay_counter >= screen_wipe_delay*(ePanel.getFPS()/60.0))
			{
				screen_wipe_frame++;
				screen_wipe_delay_counter = 0;
			}
			if(screen_wipe_frame >= 14)
			{
				screenWiping = false;
				screen_wipe_frame = 0;
			}
			if(screen_wipe_frame == 4)
			{
				drawBackground = true;
			}
		}


		if(startMapBattleDelay && !screenWiping)
		{
			//g2d.drawImage(myFightSignImg, 100, 100, myWidth/2, myHeight/2, null);
			g2d.drawImage(fight_sign_imgs.get(fight_sign_frame), (int)(myWidth*.36), 0, (int)(267*(screenWidth/1920.0)), (int)(683*(screenHeight/1080.0)), null);
		}
					
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
			//System.out.println(screenWidth);
			//g2d.drawString(mapBattle.getWinOrLose(), (int) (myWidth/2-(g2d.getFontMetrics().stringWidth(mapBattle.getWinOrLose())/1.5)*(screenWidth/1920.0)), myHeight/2); //(int) (myWidth/2-g2d.getFontMetrics().stringWidth(mapBattle.getWinOrLose())/1.5), myHeight/2);
			g2d.drawString(mapBattle.getWinOrLose(), (int)(myWidth*.25), (int)(myHeight*.5));
			
			g2d.setColor(Color.black);
			
			
		}
		
		
		//g2d.drawString(mapBattle.getWinOrLose(), 20, 20);
		g2d.setFont(sf.getScoreFont());
		g2d.drawString(NumToWords.NumToWord(mapBattle.getNumOfEnemies())+"", 0+(int)(myWidth*.02), 150);
		g2d.drawString(NumToWords.NumToWord(mapBattle.getNumOfFighters())+"", 0+(int)(myWidth*.02), 200);
		
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

		mapBattle.changeResolution(width, height, myWidth, myHeight);
		
		
		startButton.changeResolution(myWidth, myHeight, width);
		sButton.changeResolution(width, height, myWidth, myHeight);
		
		
	}

	
	
}
