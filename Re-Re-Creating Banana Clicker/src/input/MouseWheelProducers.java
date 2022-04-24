package input;

import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

import Panels.EverythingPanel;
import Panels.PurchaseablePanel;
import objects.Producers;
import objects.Purchaseable;

public class MouseWheelProducers extends MouseWheelEvents {

	private ArrayList<Producers> p = new ArrayList<>();
	public static int notches = 0;
	private int scrollAmount = 0;
	private int amountScrolled = 0;
	private PurchaseablePanel pPanel;
	
	private boolean scroll_down = false;
	private boolean scroll_up = false;
	
	private MouseLocation ml;
	
	public MouseWheelProducers(ArrayList<Producers> p, PurchaseablePanel pPanel) {
		this.p = p;
		this.pPanel = pPanel;
	}
	
	public void setMouseLocation(MouseLocation m) {
		ml = m;
	}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		//this.movePurchaseables(e);
		if(ml.getX() >= p.get(0).getX())
			this.checkScrollDirection(e);
			
		
	}
	
	// Helps to move the Purchaseable boxes with the scroll wheel up to 12 pixels at a time
	public String checkScrollDirection(MouseWheelEvent e) {
		notches = e.getWheelRotation();
		//System.out.println(notches);
		
		if (notches < 0) {
			if (scrollAmount < 0)
				scrollAmount = 0;
			scrollAmount += 1;
			
			scroll_up = true;
			scroll_down = false;
			return "UP";
		}
		if (notches > 0) {
			if (scrollAmount > 0)
				scrollAmount = 0;
			scrollAmount -= 1;
			
			scroll_up = false;
			scroll_down = true;
			return "DOWN";
		}
		return "NONE";
	}
	
	public void moveProducers(MouseWheelEvent e)
	{
		if (scrollAmount > 7)
			scrollAmount = 7;
		if (scrollAmount < -7)
			scrollAmount = -7;
		if (this.checkScrollDirection(e).equals("UP"))
		{
			if (amountScrolled > 0)
				amountScrolled = 0;
			scroll_up = true;
			scroll_down = false;
			for(Purchaseable d: this.p)
				d.setY(d.getY()+scrollAmount);
			amountScrolled-=1;
		}
		if (this.checkScrollDirection(e).equals("DOWN"))
		{
			if (amountScrolled < 0)
				amountScrolled = 0;
			scroll_down = true;
			scroll_up = false;
			for(Purchaseable d: this.p)
				d.setY(d.getY()+scrollAmount);
			amountScrolled+=1;
		}
	}
	
	// allows for a true scroll feel, smooth instead of jittery
	public void moveProducers() {
		if (scrollAmount > 9)
			scrollAmount = 9;
		if (scrollAmount < -9)
			scrollAmount = -9;
		
		if (amountScrolled >= 16 || amountScrolled <= -16)
		{
			amountScrolled = 0;
			scroll_up = false;
			scroll_down = false;
		}
		
		
		if (scroll_up)
		{
			if (amountScrolled > 0)
				amountScrolled = 0;
			scroll_up = true;
			scroll_down = false;
			for(Purchaseable d: this.p)
				d.setY(d.getY()+scrollAmount);
			amountScrolled-=1;
		}
		if (scroll_down)
		{
			if (amountScrolled < 0)
				amountScrolled = 0;
			scroll_down = true;
			scroll_up = false;
			for(Purchaseable d: this.p)
				d.setY(d.getY()+scrollAmount);
			amountScrolled+=1;
		}
	}
	
	public int getScrollAmount() {
		return scrollAmount;
	}
	
	public void setScrollAmount(int b) {
		scrollAmount = b;
	}

}
