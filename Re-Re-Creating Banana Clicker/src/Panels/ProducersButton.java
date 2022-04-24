package Panels;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import input.MouseInputProducersButton;
import input.MouseInputPurchaseablesButton;
import objects.Banana;

public class ProducersButton extends JPanel{

	JButton button = new JButton();
	
	private int bananaX, bananaY, bananaLength, bananaHeight;
	
	private int myX, myY, myLenth, myHeight;
	
	private boolean gotClicked = false;
	
	private MouseInputProducersButton mipb; 
	
	private PurchaseablePanel pp;
	
	public ProducersButton(int BananaX, int BananaY, int BananaLength, int BananaHeight, int width, int height) {
		bananaX = BananaX;
		bananaY = BananaY;
		bananaLength = BananaLength;
		bananaHeight = BananaHeight;
		
		myX = (int) (bananaX+bananaLength*.583);
		myY = (int) (bananaY+(bananaHeight*.965));
		
		myX = (int) (bananaX+bananaLength*.583);
		myY = (int) (bananaY+(bananaHeight*.965));
		
		
		this.setBounds(myX, myY, (int)(width*.09), (int)(height*.040));
		this.setLayout(null);
		this.add(button);
		
		
		
	}
	
	public void changeResolution(int width, int height, BananaPanel bp) {
		bananaX = bp.getX();
		bananaY = bp.getY();
		bananaLength = bp.getWidth();
		bananaHeight = bp.getHeight();
		myX = (int) (bananaX+bananaLength*.583);
		myY = (int) (bananaY+(bananaHeight*.965));
		
		myX = (int) (bananaX+width*.325);
		myY = (int) (bananaY+(bananaHeight*0));
		
		
		
		
		//this.setBounds(myX, myY, (int)(width*.09), (int)(height*.040));
		this.setBounds(myX, myY, 215*width/1920, 58*height/1080);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
	}
	
	public void setClicked(boolean b) {
		gotClicked = b;
	}
	
	public boolean getClicked() {
		return gotClicked;
	}

	public void setPPanel(PurchaseablePanel pP) {
		pp = pP;
	}
	
	public void initializeMouseInput() {
		mipb = new MouseInputProducersButton(this);
		mipb.setPPanel(pp);
		this.addMouseListener(mipb);
	}

	public boolean getMoveProducers() {
		return mipb.getMoveProducers();
	}

	public void setMoveProducers(boolean b) {
		mipb.setMoveProdcuers(b);
		
	}

	
	
	
}
