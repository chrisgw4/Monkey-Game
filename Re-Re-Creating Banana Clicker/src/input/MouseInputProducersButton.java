package input;

import java.awt.Color;
import java.awt.event.MouseEvent;

import Panels.ProducersButton;
import Panels.PurchaseablePanel;
import Panels.PurchaseablesButton;
import objects.Purchaseable;

public class MouseInputProducersButton extends MouseInput{
	
	private boolean mouseInside = false;
	
	private ProducersButton pb;
	
	private PurchaseablePanel pp;
	
	private boolean moveProducersFast = false;
	
	public MouseInputProducersButton(ProducersButton pb) {
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
//   	 		if (pp.getProducerList().get(0).getY()>-200)
//		   	 	for(Purchaseable d: pp.getProducerList())
//				{
//					d.setY(d.getY()-pp.getHeight()*1.75);
//				}
   	 		while (pp.getProducerList().get(pp.getProducerList().size()-1).getY() > 0)
   	 		{
   	 			for(Purchaseable d: pp.getProducerList())
				{
					d.setY(d.getY()-100);
				}
   	 		}
	   	 	this.moveProducersFast = true;
	   	 	
   	 		//System.out.println("LOP");
   	 		pb.setClicked(!pb.getClicked());
   	 	}
    	
    }
    
    @Override
    public void mouseReleased(MouseEvent arg0) {
    	
    	
    }
    
    public boolean getMoveProducers() {
    	return moveProducersFast;
    }

	public void setMoveProdcuers(boolean b) {
		moveProducersFast = b;
		
	}
	
}

