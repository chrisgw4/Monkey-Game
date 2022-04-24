package input;

import java.awt.event.MouseEvent;

import Panels.PurchaseablePanel;
import objects.Banana;
import objects.Player;

public class MouseInputBanana extends MouseInput{
	
	public MouseInputBanana() {
		
	}
	
	private Banana banana;
	private MouseLocation ml;
	private Player p;
	
	private boolean inBox = false;
	
	
	public void setMouseLoc(MouseLocation ml) {
		this.ml = ml;
	}
	
	public void setBanana(Banana b) {
		this.banana = b;
	}
	
	public void setPlayer(Player p) {
		this.p = p;
		
	}
	
	
	
    public void mouseClicked(MouseEvent arg0) { 
 		if (ml.mouseInBanana())
 		{
 			p.setCount(1);
 		}
     }
    

    

     @Override
     public void mouseEntered(MouseEvent arg0) { 
    	 //System.out.println("CHEESE");
    	 
    	 inBox = true;
     }

     @Override
     public void mouseExited(MouseEvent arg0) { 
    	 inBox = false;
     }

     @Override
     public void mousePressed(MouseEvent arg0) {
    	 if (ml.mouseInBanana() && inBox)
    	 {
    		//System.out.println("CHeese");
    		banana.setWidth(banana.getWidthConstant()+10);
			banana.setHeight(banana.getHeightConstant()+10);
//			banana.setX(banana.getXConstant()-5);
//			banana.setY(banana.getYConstant()-5);
			banana.setX(banana.getX()-5);
			banana.setY(banana.getY()-5);
    	 }
     }
     
     @Override
     public void mouseReleased(MouseEvent arg0) {
    	 if (ml.mouseInBanana())
 		 {
// 			banana.setX(banana.getXConstant());
// 			banana.setY(banana.getYConstant());
 			banana.setX(banana.getX()+5);
 			banana.setY(banana.getY()+5);
 			banana.setWidth(banana.getWidthConstant());
 			banana.setHeight(banana.getHeightConstant());
 		 }
     }

}
