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

    private int height;
    private int width;

    private int myWidthConstant;
    private int myHeightConstant;

	private int screenWidth;
	private int screenHeight;
	
	private ScoreFont sf = new ScoreFont(16);
	
	private boolean gotPressed = false;

    private Image myImg;

    private MouseMovement mm = new MouseMovement();
    private MouseClick mc = new MouseClick();

    private boolean mapBattleRunning = false;

    public StartButton(int width, int height, int baseWidth, int baseHeight) {
		myX = (int)(width/2.0-myWidth/2.0);
		myY = (int) (height/2-myHeight);
		myWidth = 105*2;
		myHeight = 45*2;
        myWidthConstant = myWidth;
        myHeightConstant = myHeight;
        this.height = height;
        this.width = width;
        
		this.setBounds((int)(width/2.0-myWidth/2.0),height/2-myHeight, myWidth, myHeight);

		screenWidth = baseWidth;
		screenHeight = baseHeight;

        
		this.addMouseMotionListener(mm);
        this.addMouseListener(mc);

        
		
		try {
            myImg = ImageIO.read(new File("Re-Re-Creating Banana Clicker/Images/MapBattles/Start_Button/Start_Sign.png"));
        } catch(Exception e) {}
        
	}


    public void paintComponent(Graphics g)
    {
        update();
        
        //this.setBackground(Color.white);
        //super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        if(!mapBattleRunning)
            g2d.drawImage(myImg, 0, 0, myWidth, myHeight, null);

        //g2d.setFont(sf.getScoreFont());
        //g2d.setColor(Color.BLACK);
        //g2d.drawString("Start", 30, 40);
    }

    public void setBattleRunning(boolean b) {
        mapBattleRunning = b;
    }

    public void update() {

        if(mc.isClicked() && mc.isInPanel())
        {
            gotPressed = true;
        }
        else
            gotPressed = !true;
        
        if(mc.isInPanel())
        {
            myWidth = (int)(myWidthConstant*1.2);
            myHeight = (int)(myHeightConstant*1.2);
            this.setSize(myWidth, myHeight);
            this.setLocation((int)(width/2.0-myWidth/2.3), height/2-myHeight);
            //this.setBounds((int)(width/2.0-myWidth/2.0), height/2-myHeight, myWidth, myHeight);
        }
        else
        {
            myWidth = (int)(myWidthConstant);
            myHeight = (int)(myHeightConstant);
            this.setBounds((int)(width/2.0-myWidth/2.3),height/2-myHeight, myWidth, myHeight);
        }
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