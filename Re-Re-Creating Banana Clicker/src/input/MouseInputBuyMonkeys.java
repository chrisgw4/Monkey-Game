package input;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Panels.ProducersButton;
import Panels.PurchaseablesButton;
import objects.Player;
import objects.Purchaseable;

public class MouseInputBuyMonkeys extends MouseInput {

	private boolean onPurchaseable = false;
	private int indexOfPurchaseable = 0;
	
	private MouseLocation ml;
	
	private ArrayList<Purchaseable> pList;
	
	private PurchaseablesButton pbutton;
	
	public MouseInputBuyMonkeys(ArrayList<Purchaseable> plist, MouseLocation ml)
	{
		pList = plist;
		this.ml = ml;
	
	}
	
	public void setButton(PurchaseablesButton pbutton) {
		this.pbutton = pbutton;
	}
	
    public void mouseClicked(MouseEvent arg0) { 
 		
     }

     @Override
     public void mouseEntered(MouseEvent arg0) { 
    	 
     }

     @Override
     public void mouseExited(MouseEvent arg0) { 
    	 
     }

     @Override
     public void mousePressed(MouseEvent arg0) {
    	if(ml.mouseInBuyable(pList, this) && getPlayer().getCount() >= pList.get(indexOfPurchaseable).getPrice() &&
    			arg0.getButton() == MouseEvent.BUTTON1 && pbutton.getClicked())
    	{
    		//System.out.println(pList.get(indexOfPurchaseable).getPrice());
    		p.setCount(-pList.get(indexOfPurchaseable).getPrice());
    		pList.get(indexOfPurchaseable).setAmountOwned(pList.get(indexOfPurchaseable).getAmountOwned()+1);
    		p.addToWarriorList(pList.get(indexOfPurchaseable));
    		//System.out.println(p.getWarriorList().size());
    	}
    	if(ml.mouseInBuyable(pList, this) &&
    			arg0.getButton() == MouseEvent.BUTTON3 )
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
	
}
