package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Panels.BananaPanel;
import objects.Banana;
import objects.Player;



public class MouseInput implements MouseListener{

	private boolean mouseClicked = false;
	
	MouseLocation ml;
	Player p;
	
	public MouseInput() {

	}
	
	public void setMouseLoc(MouseLocation ml) {
		this.ml = ml;
	}
	
	
	public void setPlayer(Player p) {
		this.p = p;
		
	}
	
    public void mouseClicked(MouseEvent arg0) { 
 		
 		
     }
    

    

     @Override
     public void mouseEntered(MouseEvent arg0) { 
    	 
     }

     @Override
     public void mouseExited(MouseEvent arg0) { }

     @Override
     public void mousePressed(MouseEvent arg0) {
    	
     }
     
     @Override
     public void mouseReleased(MouseEvent arg0) {
    	 
     }

     
     
}

