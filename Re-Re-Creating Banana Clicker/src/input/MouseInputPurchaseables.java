package input;

import java.awt.event.MouseEvent;

import Panels.PurchaseablePanel;

public class MouseInputPurchaseables extends MouseInput{

	
	
	public MouseInputPurchaseables() {
		
	}
	
	@Override
    public void mouseEntered(MouseEvent arg0) { 
   	 
		PurchaseablePanel.setMouseInPanel(true); 
    }

    @Override
    public void mouseExited(MouseEvent arg0) { 
    	PurchaseablePanel.setMouseInPanel(false); 
    	
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
   	 
    	
    }
    
    @Override
    public void mouseReleased(MouseEvent arg0) {
   	
    	
    }
	
}
