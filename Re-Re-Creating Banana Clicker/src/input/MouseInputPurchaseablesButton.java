package input;

import java.awt.Color;
import java.awt.event.MouseEvent;

import Panels.PurchaseablePanel;
import Panels.PurchaseablesButton;
import objects.Purchaseable;

public class MouseInputPurchaseablesButton extends MouseInput{
	
	private boolean mouseInside = false;
	
	private PurchaseablesButton pb;
	
	private PurchaseablePanel pp;
	
	private boolean movePurchaseablesFast = false;
	
	public MouseInputPurchaseablesButton(PurchaseablesButton pb) {
		this.pb = pb;
		
	}
	
	public void setPPanel(PurchaseablePanel pP) {
		this.pp = pP;
	}
	
	@Override
    public void mouseEntered(MouseEvent arg0) { 
		mouseInside = true;
		pb.setBackground(Color.black);
		 
    }

    @Override
    public void mouseExited(MouseEvent arg0) { 
    	mouseInside = false;
    	pb.setBackground(Color.white);
    	
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
   	 	if (mouseInside) 
   	 	{
   	 		while (pp.getPurchaseList().get(pp.getPurchaseList().size()-1).getY() > 0)
		   	 	for(Purchaseable d: pp.getPurchaseList())
				{
		   	 		d.setY(d.getY()-100);
					//d.setY(d.getY()-Purchaseable.getScreenHeight()*(.1*pp.getPurchaseList().size()));//pp.getHeight()*2);
				}
	   	 	this.movePurchaseablesFast = true;
	   	 	
   	 		//System.out.println("LOP");
   	 		pb.setClicked(!pb.getClicked());
   	 	}
    	
    }
    
    @Override
    public void mouseReleased(MouseEvent arg0) {
    	
    	
    }
    
    public boolean getMovePurchaseables() {
    	return movePurchaseablesFast;
    }

	public void setMovePurchaseables(boolean b) {
		movePurchaseablesFast = b;
		
	}
	
}

