package objects;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton{

	JButton jb = new JButton();
	
	private int myX;
	private int myY;
	private int myWidth;
	private int myHeight;
	private int screenWidth;
	private int screenHeight;
	
	private ScoreFont sf = new ScoreFont(16);
	
	private boolean gotPressed = false;
	
	public Button(int width, int height, int baseWidth, int baseHeight) {
		myX = (int) (width*.25);
		myY = (int) (height*.05);
		myWidth = (int) (width*.13);
		myHeight = (int) (height*.07);
		
		screenWidth = baseWidth;
		screenHeight = baseHeight;
		
		this.setBounds(myX, myY, myWidth, myHeight);
		this.setFont(sf.getScoreFont());
		this.setText("Start");
		this.setFocusable(false);
		this.setBackground(Color.white);
		
        
	}

	
	public boolean getPressed() {
		return gotPressed;
	}

	public void setPressed(boolean b) {
		gotPressed = b;
		
	}

	private boolean stopComparisons = false;
	
	public void changeResolution(int width, int height, int baseWidth) {
		myX = (int) (width*.25);
		myY = (int) (height*.05);
		myWidth = (int) (width*.13);
		myHeight = (int) (height*.07);
		
		
		this.setBounds(myX, myY, myWidth, myHeight);
		
		
		if(this.getFont() == sf.getScoreFont() && baseWidth != screenWidth)
		{
			//sf = sf2;
			sf = new ScoreFont((int)(16.0*(baseWidth/1920.0)));
			this.setFont(sf.getScoreFont());
			//System.out.println("Cheee");
			
			stopComparisons = true;
		}
		screenWidth = baseWidth;
	}
	
	public void setStopComparisons(boolean b) {
		stopComparisons = b;
	}
	
	
}
