package input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import objects.Purchaseable;


public class MouseWheelEvents implements MouseWheelListener{
	
	private int notches = 0;
	
	public MouseWheelEvents() {
		
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
			
		
	}
	
	public String checkScrollDirection(MouseWheelEvent e) {
		notches = e.getWheelRotation();
		if (notches < 0) {
			return "UP";
		}
		if (notches > 0) {
			return "DOWN";
		}
		return "NONE";
	}
	
	public void movePurchaseables(MouseWheelEvent e, ArrayList<Purchaseable> p)
	{
		
	
	}
}
