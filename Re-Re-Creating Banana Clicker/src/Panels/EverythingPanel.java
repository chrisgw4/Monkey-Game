package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.VolatileImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import CountLargeNumbers.NumToWords;
import ReadFiles.ReadPlayerBuyables;
import ReadFiles.ReadPlayerCount;
import ReadFiles.ReadPlayerProducers;
import SaveFiles.SavePlayerBuyables;
import SaveFiles.SavePlayerCount;
import SaveFiles.SavePlayerProducers;
import dungeongamecontents.DungeonPanel;
import input.MouseInput;
import input.MouseInputBanana;
import input.MouseInputPurchaseables;
import input.MouseLocation;
import mapBattles.MapPanel;
import objects.Button;
import objects.Player;
import objects.Purchaseable;
import objects.ScoreFont;

public class EverythingPanel extends JPanel implements ActionListener{

	private int width;
	private int height;
	
	private BackgroundPanel backgroundp;
	private BananaPanel bananap;
	private PurchaseablePanel purchaseablep;
	
	public static Player player = new Player();
	private FPSCounter fps = new FPSCounter();
	
	private MouseLocation ml = new MouseLocation(0,0);
	private MouseInput mi = new MouseInput();
	
	private MouseInputBanana mib = new MouseInputBanana();
	private MouseInputPurchaseables mip = new MouseInputPurchaseables();
	
	
	private Purchaseable m;
	
	private TextPanel showCount; 
	
	private PurchaseablesButton pButton;
	
	private ProducersButton prbutton;
	
	private static int timer = 15;
	
	private JFrame frame;
	
	private SavePlayerCount spc = new SavePlayerCount();
	
	private ReadPlayerCount rpc;
	
	private SavePlayerBuyables spb;
	
	private SavePlayerProducers spp;
	
	private ReadPlayerProducers rpp;
	
	private ReadPlayerBuyables rpb;
	
	private SidePanel sp;
	
	private MapPanel mp;
	
	
	//private ScoreFont scoreF = new ScoreFont(player);
	
	public EverythingPanel(int width, int height, JFrame frame) {
		this.width = width;
		this.height = height;
		
		this.frame = frame;
		
		NumToWords.setScreenWidth(width);
		
		this.setSize(new Dimension(width, height));
		
		this.setBounds(0,0, width, height);
		
		this.setPreferredSize(new Dimension(width, height));
		
		this.setLayout(null);
		
		rpc = new ReadPlayerCount(player);
		
		
		//this.setBounds(0, 0, width, height);
		
		//this.setPreferredSize(new Dimension(width, height));
		
		//this.setVisible(true);
		
		
		
		backgroundp = new BackgroundPanel(width, height);
		bananap = new BananaPanel(width, height, ml, mib, this);
		
		prbutton = new ProducersButton(bananap.getX(), bananap.getY(), bananap.getLength(), bananap.getHeight(), width, height);
		pButton = new PurchaseablesButton(bananap.getX(), bananap.getY(), bananap.getLength(), bananap.getHeight(), width, height);
		
		purchaseablep = new PurchaseablePanel(width, height, ml, mip, pButton, player, prbutton, this);
		
		pButton.setPPanel(purchaseablep);
		pButton.initializeMouseInput();
		prbutton.setPPanel(purchaseablep);
		prbutton.initializeMouseInput();
		
		showCount = new TextPanel(bananap.getX(), bananap.getY(), bananap.getLength(), bananap.getHeight(), width, height);
		
		this.mi.setPlayer(player);
		this.mip.setPlayer(player);
		this.mib.setPlayer(player);
		
		
		
		
		//this.add(new TextPanel());
		
		sp = new SidePanel(width, height);
		mp = new MapPanel(width, height, purchaseablep, player);
		
		
		//this.add(new DungeonPanel(width, height));
		
		this.add(pButton);
		this.add(prbutton);
		
		
		
		
		
		this.add(showCount);
		
		this.add(fps);
		
		this.add(purchaseablep);
		
		this.add(bananap);
		
		this.add(sp);
		
		this.add(mp);
		
		//this.add(new Button(width, height));
		
		this.add(backgroundp);
		

		
		this.addMouseMotionListener(ml);
		
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
		        changeResolution();
		    }
		});
			
		
		//this.changeResolution();
		
		
		spb = new SavePlayerBuyables(purchaseablep.getPurchaseList());
		spp = new SavePlayerProducers(purchaseablep.getProducerList());
		rpp = new ReadPlayerProducers(purchaseablep.getProducerList(), player);
		rpb = new ReadPlayerBuyables(purchaseablep.getPurchaseList(), player);
		this.setBackground(Color.black);
		
		
		
	}
	
	private long timeStep;
	private long prevTime = System.currentTimeMillis();
	
	public void paint(Graphics g) {
		
		
		super.paint(g);
		spc.updateFile();
		spb.updateFile();
		spp.updateFile();
		
		mp.update();
		
		
	}
	
	public Image createImage() {
		VolatileImage g = createVolatileImage(width, height);
		return g;
	}
	
	
	private long currTime;
	private long lastTime = System.nanoTime();
	private static double targetFPS = 60.0;
	private double ns = 1000000000 / targetFPS;
	private long timers = System.currentTimeMillis();
	private double delta = 0.0;
	private int frames = 0;
	private long timeSinceLast;
	
	// set up timer to check fps
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		currTime = System.nanoTime();
		timeSinceLast = currTime- lastTime;
		delta += (timeSinceLast) /ns;
		lastTime = currTime;
		timers += timeSinceLast;
		//System.out.println(timeSinceLast);
		if (delta >= 1) {
            //tick();
			repaint();
			frames++;
            delta = 0D;
        }
        
        
        // Small fps counter
        if(timers >= 1000000000L) {
        	//System.out.println(System.currentTimeMillis() - timers);
            
            //System.out.println("FPS: " + frames);
            frames = 0;
            timers = 0;
        }
		
//		if(previousTime < currTime)
//		{
//			repaint();
//			previousTime = System.currentTimeMillis();
//		}
		
		
	}

	public long getTPF() {
		return timeSinceLast;
	}

	public int getFPS() {
		if(fps.getFps() >= 30 && targetFPS >= 30)
			return fps.getFps();
		else
			return (int)targetFPS;
	}

	

	public static int getFPSTarget() {
		return (int) targetFPS;
	}
	
	public static int getTimer() {
		return timer;
	}

	public static void setTimer(int timer) {
		EverythingPanel.timer = timer;
	}
	
	public static Player getPlayer() {
		return player;
	}
	
	public void changeResolution() {
		int newwidth = frame.getWidth();
		int newheight = frame.getHeight();
		this.width = newwidth;
		this.height = newheight;
		this.setPreferredSize(new Dimension(width, height));
		this.setBounds(0,0,width, height);
		this.backgroundp.changeResolution(width, height);
		this.bananap.changeResolution(width, height);
		this.purchaseablep.changeResolution(width, height);
		this.showCount.changeResolution(width, height, bananap);
		this.prbutton.changeResolution(width, height, bananap);
		this.pButton.changeResolution(width, height, bananap);
		this.mp.changeResolution(newwidth, newheight);
		NumToWords.changeResolution(width);
	}
	

}
