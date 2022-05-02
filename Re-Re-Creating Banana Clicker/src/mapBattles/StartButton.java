package mapBattles;

import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import input.MouseInput;
import objects.ScoreFont;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.SimpleFileVisitor;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.imageio.ImageIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JPanel {
    
    private int myX;
	private int myY;
	private int myWidth;
	private int myHeight;
	private int screenWidth;
	private int screenHeight;
	
	private ScoreFont sf = new ScoreFont(16);
	
	private boolean gotPressed = false;

    private Image myImg;

    private MouseMovement mm = new MouseMovement();
    private MouseClick mc = new MouseClick();

    public StartButton(int width, int height, int baseWidth, int baseHeight) {
		myX = (int) (width*.25);
		myY = (int) (height*.05);
		myWidth = 105*2;
		myHeight = 45*2;
        
		this.setBounds(width/2-myWidth/2,height/2-myHeight, myWidth, myHeight);

		screenWidth = baseWidth;
		screenHeight = baseHeight;

        
		this.addMouseMotionListener(mm);
        this.addMouseListener(mc);

        
		
		try {
            myImg = ImageIO.read(new File("Re-Re-Creating Banana Clicker/Images/MapBattles/Start_Button/Start_Sign.png"));
        } catch(Exception e) {}
        
	}

    public void draw(Graphics2D g2d)
    {
        
        g2d.drawImage(myImg, 0, 0, 100, 40, null);
        g2d.setFont(sf.getScoreFont());
        g2d.setColor(Color.BLACK);
        g2d.drawString("Start", 30, 40);
    }

    public void paintComponent(Graphics g)
    {
        update();
        
        //this.setBackground(Color.white);
        //super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(myImg, 0, 0, myWidth, myHeight, null);
        //g2d.setFont(sf.getScoreFont());
        //g2d.setColor(Color.BLACK);
        //g2d.drawString("Start", 30, 40);
    }

    public void update() {

        if(mc.isClicked() && mc.isInPanel())
        {
            gotPressed = true;
        }
        else
            gotPressed = !true;
        
        //System.out.println(gotPressed);
    }


	
	public boolean getPressed() {
		return gotPressed;
	}

	public void setPressed(boolean b) {
		gotPressed = b;
		
	}

	private boolean stopComparisons = false;
	
	public void changeResolution(int width, int height) {
		myX = (int) (width*.25);
		myY = (int) (height*.05);
		myWidth = (int)(105*2*(width/1920.0));
		myHeight = (int)(45*2*(height/1080.0));
		
		
		
		
		
		if(width != screenWidth)
		{
			//sf = sf2;
			sf = new ScoreFont((int)(16.0*(width/1920.0)));
			
			//System.out.println("Cheee");
			
			stopComparisons = true;
		}
		screenWidth = width;
	}
	
	public void setStopComparisons(boolean b) {
		stopComparisons = b;
	}

    
	
	
}