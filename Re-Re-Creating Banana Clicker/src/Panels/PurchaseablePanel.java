package Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import input.MouseInput;
import input.MouseInputBuyMonkeys;
import input.MouseInputBuyProducers;
import input.MouseInputPurchaseables;
import input.MouseLocation;
import input.MouseWheelProducers;
import input.MouseWheelPurchaseables;
import objects.Player;
import objects.Producers;
import objects.Purchaseable;
import objects.Warriors;

public class PurchaseablePanel extends JPanel{

	private int width;
	private int height;
	
	private int myX;
	private int myY;
	
	private int myYConstant;
	
	private int myLength;
	private int myHeight;
	
	private MouseLocation ml;
	private MouseInputPurchaseables mi;
	private MouseWheelPurchaseables mwp;
	private MouseWheelProducers mwpr;
	
	private Purchaseable m;
	private Purchaseable b;
	
	private PurchaseablesButton pbutton;
	
	private ProducersButton prbutton;
	
	private ArrayList<Purchaseable> purchaseList = new ArrayList<Purchaseable>();
	
	private ArrayList<Producers> producerList = new ArrayList<Producers>();
	
	private static boolean mouseInPanel;
	
	private MouseInputBuyMonkeys mibm;
	
	private MouseInputBuyProducers mibp;

	private EverythingPanel ePanel;
	
	

	public PurchaseablePanel(int width, int height, MouseLocation ml, MouseInputPurchaseables mi, PurchaseablesButton pb,
			Player p, ProducersButton prb, EverythingPanel ep) {
		this.width = width;
		this.height = height;
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setSize(new Dimension(600,400));
		
		this.ml = ml;
		this.mi = mi;

		ePanel = ep;
		
		
		myX = (int)(width * .07);
		myY = (int)(height * .4);
		
		myYConstant = myY;
		
		myLength = (int)(width * .3);
		myHeight = (int)(height * .27);
		
		
		
		
		
		this.setBounds(myX, myY, myLength, myHeight);
		
		this.setOpaque(false);
		
		this.addMouseListener(this.mi);
		this.addMouseWheelListener(null);
		this.addMouseMotionListener(ml);
		
		Purchaseable.pp = this;
		pbutton = pb;
		prbutton = prb;

		Purchaseable.setFPS(ePanel.getFPSTarget());
		
		m = new Warriors(0, 0, "Monkey", 10.0, width, height, 1);
		b = new Warriors(0, myHeight*.18, "Orangutan", 10.0, width, height, 5);
		Purchaseable zm = new Warriors(0, myHeight*.36, "Mandrill", 10.0, width, height, 10);
		Purchaseable zb = new Warriors(0, myHeight*.54, "Chimpanzee", 10.0, width, height, 12);
		purchaseList.add(m);
		purchaseList.add(b);
		purchaseList.add(zm);
		purchaseList.add(zb);
		purchaseList.add(new Warriors(0, myHeight*.72, "Gorilla", 10.0, width, height, 15));
		purchaseList.add(new Warriors(0, myHeight*.90, "Orangutan", 10.0, width, height, 0));
		purchaseList.add(new Warriors(0, myHeight*1.08, "Monkey", 10.0, width, height, 0));
		purchaseList.add(new Warriors(0, myHeight*1.26, "Orangutan", 10.0, width, height, 0));
		purchaseList.add(new Warriors(0, myHeight*1.44, "Monkey", 10.0, width, height, 0));
		purchaseList.add(new Warriors(0, myHeight*1.62, "Orangutan", 10.0, width, height, 0));
		purchaseList.add(new Warriors(0, myHeight*1.80, "Monkey", 10.0, width, height, 0));
		
		producerList.add(new Producers(myLength*.45, myHeight*0, "Farmer", 15.0, width, height, .1));
		producerList.add(new Producers(myLength*.45, myHeight*.18, "Orangutan", 100.0, width, height, 1));
		producerList.add(new Producers(myLength*.45, myHeight*.36, "Orangutan", 1_100.0, width, height, 8));
		producerList.add(new Producers(myLength*.45, myHeight*.54, "Orangutan", 12_000.0, width, height, 47));
		producerList.add(new Producers(myLength*.45, myHeight*.72, "Orangutan", 130_000.0, width, height, 260));
		producerList.add(new Producers(myLength*.45, myHeight*.90, "Orangutan", 1_400_000.0, width, height, 1400));
		//producerList.add(new Producers(myLength*.45, myHeight*1.08, "Orangutan", 1_400_000.0, width, height, 1400));
		
		
		
		mwp = new MouseWheelPurchaseables(this.purchaseList, this);
		mwpr = new MouseWheelProducers(this.producerList, this);
		
		mibm = new MouseInputBuyMonkeys(this.purchaseList, ml);
		mibm.setPlayer(p);
		
		mibp = new MouseInputBuyProducers(this.producerList, ml);
		mibp.setPlayer(p);
		
		ml.setMouseInputProducers(mibp);
		ml.setPurchaseableList(purchaseList);
		mwpr.setMouseLocation(ml);
		mwp.setMouseLocation(ml);
		mwp.setLocX(producerList.get(0).getX());
		
		mibp.setButton(prbutton);
		mibm.setButton(pbutton);
		
		this.addMouseListener(mibm);
		this.addMouseListener(mibp);
		this.addMouseWheelListener(mwp);
		this.addMouseWheelListener(mwpr);
	}
	
	public void changeResolution(int width, int height) {
		myLength = (int)(width * .3);
		myHeight = (int)(height * .27);
		
		myX = (int)(width * .07);
		myY = (int)(height * .4);
		
		this.width = width;
		this.height = height;
		
		// TESTING
		{
		myLength = (int)(width * .3);
		myHeight = (int)(height * .5);
		//myX = (int)(width * .3);
		
		// 2nd Testing
		myX = (int)(width * .22);
		
		myY = (int)(height * .15);
		}
		
		
		myYConstant = myY;
		Purchaseable.setScreenWidth(width);
		
		this.setPreferredSize(new Dimension(myLength, myHeight));
		this.setBounds(myX, myY, myLength, myHeight);
		double i = 0;
		for(Purchaseable p: purchaseList)
		{
			p.setSize(width, height);
			p.setY(myHeight*i);
			//i+=.18;
			i+=.125;
		}
		i=0;
		for(Purchaseable p: producerList)
		{
			p.setSize(width, height);
			p.setY(myHeight*i);
			p.setX(myLength*.45);
			//i+=.18;
			i+=.125;
		}
	}
	
	
	public int getLength() {
		return myLength;
	}
	
	public int getHeight() {
		return myHeight;
	}
	
	public int getX() {
		return myX;
	}
	
	public int getY() {
		return myY;
	}
	
	public static void setMouseInPanel(boolean b) {
		mouseInPanel = b;
	}
	
	public static boolean getMouseInPanel() {
		return mouseInPanel;
	}
	
	public ArrayList<Purchaseable> getPurchaseList() {
		return purchaseList;
	}
	
	public ArrayList<Producers> getProducerList() {
		return producerList;
	}
	
	
	public void paintComponent(Graphics g)
	{
		
		Graphics2D g2d = (Graphics2D) g;
		
//		this.setOpaque(true);
//		this.setBackground(Color.black);
//		super.paintComponent(g2d);
		
		mwp.movePurchaseables();
		mwpr.moveProducers();
		
		if(pbutton.getClicked() && pbutton.getMovePurchaseables())
		{
			this.movePurchaseablesDownFast(this.purchaseList);
		}
		else
		{
			this.movePurchaseablesUp(this.purchaseList);
			this.movePurchaseablesDown(this.purchaseList);
		}
		
		if(pbutton.getClicked())
		{
			for(Purchaseable d: purchaseList)
			{
				d.update(ml);
				d.draw(g2d);
			}
		}
		else 
		{
			
		}
		if(prbutton.getClicked() && prbutton.getMoveProducers())
		{
			this.moveProducersDownFast(producerList);
			//System.out.println(prbutton.getMoveProducers());
		}
		else
		{
			this.moveProducersUp(producerList);
			this.moveProducersDown(producerList);
		}
		if(prbutton.getClicked())
		{
			for(Producers p: producerList)
			{
				p.update(ml);
				p.draw(g2d);
			}
		}
		
		
		for(Producers p: getProducerList())
		{
			if(ePanel.getFPS() >= 30)
			{
				//System.out.println(ePanel.getFPS());
				p.update(ePanel.getFPS());
			}
			else
				;
		}
		
	}
	
	// sets the scrollamount to 0 to stop scrolling for purchaseables
	public void resetScrollAmountMWP() {
		mwp.setScrollAmount(0);
	}
	
	// FOr producers
	public void resetScrollAmountMWPR() {
		mwpr.setScrollAmount(0);
	}
	
	public void movePurchaseablesUp(ArrayList<Purchaseable> pList) {
		if (pList.get(0).getY() > 0 && pList.get(0).getY() <= 20)
		{
			for(Purchaseable d: pList)
				d.setY((int)(d.getY()-1*(60.0/ePanel.getFPS())));
			
		}
		if (pList.get(0).getY() >= 20 && pList.get(0).getY() <= 100)
		{
			for(Purchaseable d: pList)
				d.setY((int)(d.getY()-3*(60.0/ePanel.getFPS())));
			
		}
		if (pList.get(0).getY() > 100 && pList.get(0).getY() <= myHeight)
		{
			for(Purchaseable d: pList)
				d.setY((int)(d.getY()-5*(60.0/ePanel.getFPS())));
			this.resetScrollAmountMWP();
		}
		if (pList.get(0).getY() > myHeight)
		{
			for(Purchaseable d: pList)
				d.setY((int) (d.getY()-15*(60.0/ePanel.getFPS())));
			this.resetScrollAmountMWP();
		}
	}
	
	public void movePurchaseablesDown(ArrayList<Purchaseable> pList) {
		int fps = ePanel.getFPSTarget();

		/*if (pList.get(pList.size()-1).getY() <= -25) //&& 
				//this.purchaseList.get(purchaseList.size()-1).getY() >= -30)
		{
			for(Purchaseable d: pList)
				d.setY((int)(d.getY()+15*(60.0/fps)));
			this.resetScrollAmountMWP();
		}
		else if (pList.get(pList.size()-1).getY() <= myHeight*.4 && 
		 		pList.get(pList.size()-1).getY() > -25)
		{
		 	for(Purchaseable d: pList)
		 		d.setY((int)(d.getY()+6*(60.0/fps)));
		 	this.resetScrollAmountMWP();
		}
		else if (pList.get(pList.size()-1).getY() >= myHeight*.4 && 
				pList.get(pList.size()-1).getY() <= myHeight*.7)
		{
			for(Purchaseable d: pList)
				d.setY((int)(d.getY()+5*(60.0/fps)));
			
		}
		else if (pList.get(pList.size()-1).getY() >= myHeight*.7 && 
				pList.get(pList.size()-1).getY() <= myHeight*.8)
		{
			for(Purchaseable d: pList)
				d.setY((int)(d.getY()+3*(60.0/fps)));
			
		} */
		if (pList.get(pList.size()-1).getY() <= -25)
		{
			this.resetScrollAmountMWP();
			pList.get(pList.size()-1).setY(pList.get(pList.size()-1).getY()+10);
			for(int i = 0; i < pList.size()-1; i++)
			{
				pList.get(i).setY(pList.get(i).getY() + 10);
			}
		}

		else if (pList.get(pList.size()-1).getY() <= myHeight*.4 && 
			pList.get(pList.size()-1).getY() > -25)
		{
			//this.resetScrollAmountMWP();
			pList.get(pList.size()-1).setY((int)(pList.get(pList.size()-1).getY() + 7*60/fps));
			for(int i = 0; i < pList.size()-1; i++)
			{
				pList.get(i).setY((int)(pList.get(i).getY() + 7*60/fps));
			}
		}
		
		else if (pList.get(pList.size()-1).getY() >= myHeight*.4 && 
				pList.get(pList.size()-1).getY() <= myHeight*.7)
		{
			pList.get(pList.size()-1).setY((int)(pList.get(pList.size()-1).getY() + 9*60/fps));
			for(int i = 0; i < pList.size()-1; i++)
			{
				pList.get(i).setY((int)(pList.get(i).getY() + 9*60/fps));
			}
		}
	}
	
	public void movePurchaseablesDownFast(ArrayList<Purchaseable> pList) {
		if (purchaseList.get(0).getY() < 0) //&& 
			//this.purchaseList.get(purchaseList.size()-1).getY() >= -30)
		{
			for(Purchaseable d: pList)
				d.setY(d.getY()+(int)(35*(height/1080.0)*(60.0/ePanel.getFPS())));
		}
		else
		{
			
			pbutton.setMovePurchaseables(false);
		}
		
	}
	public void moveProducersUp(ArrayList<Producers> pList) {
		if (pList.get(0).getY() > 0 && pList.get(0).getY() <= 30)
		{
			for(Purchaseable d: pList)
				d.setY(d.getY()-2);
			
		}
		else if (pList.get(0).getY() > 30 && pList.get(0).getY() <= 100)
		{
			for(Purchaseable d: pList)
				d.setY(d.getY()-3);
			
		}
		else if (pList.get(0).getY() > 100 && pList.get(0).getY() <= myHeight)
		{
			for(Purchaseable d: pList)
				d.setY(d.getY()-5);
			this.resetScrollAmountMWPR();
		}
		else if (pList.get(0).getY() > myHeight)
		{
			for(Purchaseable d: pList)
				d.setY(d.getY()-15);
			this.resetScrollAmountMWPR();
		}
	}
	
	public void moveProducersDown(ArrayList<Producers> pList) {
		if (pList.get(pList.size()-1).getY() <= -25) //&& 
				//this.purchaseList.get(purchaseList.size()-1).getY() >= -30)
		{
			for(Purchaseable d: pList)
				d.setY(d.getY()+15);
			this.resetScrollAmountMWPR();
		}
		else if (pList.get(pList.size()-1).getY() <= myHeight*.4 && 
				pList.get(pList.size()-1).getY() >= -25)
		{
			for(Purchaseable d: pList)
				d.setY(d.getY()+6);
			this.resetScrollAmountMWPR();
		}
		else if (pList.get(pList.size()-1).getY() >= myHeight*.4 && 
				pList.get(pList.size()-1).getY() <= myHeight*.5) // .7 normally
		{
			for(Purchaseable d: pList)
				d.setY(d.getY()+5);
			
		}
		else if (pList.get(pList.size()-1).getY() >= myHeight*.5 && // .6 normally
				pList.get(pList.size()-1).getY() <= myHeight*.6) // .8 normally
		{
			for(Purchaseable d: pList)
				d.setY(d.getY()+3);
			
		}
	}
	
	public void moveProducersDownFast(ArrayList<Producers> pList) {
		if (pList.get(0).getY() < 0) //&& 
			//this.purchaseList.get(purchaseList.size()-1).getY() >= -30)
		{
			for(Purchaseable d: pList)
			{
				d.setY(d.getY()+(int)(35*(height/1080.0)*(60.0/ePanel.getFPS())));//*(height/1080.0));

			}
		}
		else
		{
			
			prbutton.setMoveProducers(false);
		}
		
	}

	
	


	
}
