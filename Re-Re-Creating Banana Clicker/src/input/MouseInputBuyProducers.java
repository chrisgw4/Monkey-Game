package input;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Panels.ProducersButton;
import objects.Player;
import objects.Producers;
import objects.Purchaseable;

public class MouseInputBuyProducers extends MouseInput {

	
	private boolean onPurchaseable = false;
	private int indexOfPurchaseable = 0;
	
	private MouseLocation ml;
	
	private ArrayList<Producers> pList;
	
	private boolean insideBox = false;
	
	private ProducersButton prbutton;
	
	public MouseInputBuyProducers(ArrayList<Producers> plist, MouseLocation ml) {
		pList = plist;
		this.ml = ml;
		ml.setProducerList(plist);
	}
	
	public void setMouseLoc(MouseLocation ml) {
		this.ml = ml;
	}
	
	
	public void setPlayer(Player p) {
		this.p = p;
	}
	
	public boolean getInsideBox() {
		return insideBox;
	}
	
    public void mouseClicked(MouseEvent arg0) { 
 		
 		
     }
    


     @Override
     public void mouseEntered(MouseEvent arg0) { 
    	 //System.out.println("CHEEse");
    	 insideBox = true;
     }

     @Override
     public void mouseExited(MouseEvent arg0) {
    	 insideBox = false;
     }

     @Override
     public void mousePressed(MouseEvent arg0) {
    	if(ml.mouseInProducer(pList, this) && getPlayer().getCount() >= pList.get(indexOfPurchaseable).getPrice() &&
    			arg0.getButton() == MouseEvent.BUTTON1 && prbutton.getClicked())
     	{
     		//System.out.println(pList.get(indexOfPurchaseable).getPrice());
     		p.setCount(-pList.get(indexOfPurchaseable).getPrice());
     		pList.get(indexOfPurchaseable).setAmountOwned(pList.get(indexOfPurchaseable).getAmountOwned()+1);
     		
     		// Changes price on a set scale
     		
     		pList.get(indexOfPurchaseable).setPrice(pList.get(indexOfPurchaseable).getBasePrice() * Math.pow(1.15, pList.get(indexOfPurchaseable).getAmountOwned()));
//     		// Checks to round up price if it is higher than the normal int, EX: 19.25 = 20
//     		if((int)pList.get(indexOfPurchaseable).getPrice() < pList.get(indexOfPurchaseable).getPrice())
//     			pList.get(indexOfPurchaseable).setPrice((int)pList.get(indexOfPurchaseable).getPrice()+1);
     		
     		pList.get(indexOfPurchaseable).setPrice((double)pList.get(indexOfPurchaseable).getPrice()+1);
     		//System.out.println(pList.get(indexOfPurchaseable).getPrice());
     		p.addToProducerList(pList.get(indexOfPurchaseable));
     		getPlayer().setPassiveCount(pList.get(indexOfPurchaseable).getProductionAmount()*100);
     		//System.out.println(pList.get(indexOfPurchaseable).getPrice());
     	}
    	if(ml.mouseInProducer(pList, this) &&
    			arg0.getButton() == MouseEvent.BUTTON3)
    	{
    		//pList.get(indexOfPurchaseable).setImage("Blank");
    		pList.get(indexOfPurchaseable).setShowStats(!pList.get(indexOfPurchaseable).getShowStats());
    		pList.get(indexOfPurchaseable).setFrame(0);
    		pList.get(indexOfPurchaseable).setShowBoard(false);
    		//System.out.println(pList.get(indexOfPurchaseable).getShowStats());
    	}
     }
     
     @Override
     public void mouseReleased(MouseEvent arg0) {
    	 
     }

     public void setIndex(int i) {
 		this.indexOfPurchaseable = i;
 		
 	}

 	public Player getPlayer() {
 		return this.p;
 	}

	public void setButton(ProducersButton prbutton) {
		this.prbutton = prbutton;
		
	}

}
