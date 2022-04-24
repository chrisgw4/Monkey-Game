package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import Panels.PurchaseablePanel;
import objects.Banana;
import objects.Producers;
import objects.Purchaseable;



public class MouseLocation implements MouseMotionListener{

	private int mX = 0;
	private int mY = 0;
	private Banana banana;
	
	private boolean inPurchaseablePanel = false;
	
	private int pastX = -100;
	private int pastY = -100;
	
	private boolean isInBoxNoFlip = false;
	
	private ArrayList<Producers> producerList;
	
	private ArrayList<Purchaseable> purchaseableList;
	
	private MouseInputBuyProducers mibp;
	
	public MouseLocation(int x, int y) {
		mX = x;
		mY = y;
		
	}
	
	public void setBanana(Banana b) {
		banana = b;
	}
	
	public void setProducerList(ArrayList<Producers> p) {
		producerList = p;
	}
	
	public void setPurchaseableList(ArrayList<Purchaseable> p) {
		purchaseableList = p;
	}

	public void setMouseInputProducers(MouseInputBuyProducers m) {
		mibp = m;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//mX = e.getX();
		//mY = e.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mX = e.getX();
		mY = e.getY();
		
		
		//mouseInProducerToFlip(producerList);
		//if (!isInBoxNoFlip)
		//{
		this.mouseInToFlipProducer(producerList);
		this.mouseInToFlipBuyable(purchaseableList);
		
		//System.out.println(this.mouseInBanana());
		//}
		//System.out.println(mX);
		//System.out.println(mY);
		
	}
	
	public int getX() {
		return mX;
	}
	
	public int getY() {
		return mY;
	}
	
	public void setX(int x) {
		mX = x;
	}
	
	public void setY(int y) {
		mY = y;
	}
	
	
	public boolean mouseInPurchaseable(Purchaseable p, boolean check) {
		//System.out.println(pp.getY());
//		System.out.println(mY);
		if (mX >= p.getX() && mX <= p.getX()+p.getLength() && mY >= p.getY() && mY <= p.getY()+p.getHeight() && check)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean mouseInBuyable(ArrayList<Purchaseable> pList, MouseInputBuyMonkeys mibm) {
		for(int i = 0; i<pList.size(); i++)
   	 {
   		 if(getX() > pList.get(i).getX() && getX() < pList.get(i).getX()+pList.get(i).getLength() &&
   				 getY() > pList.get(i).getY() && getY() < pList.get(i).getY()+pList.get(i).getHeight())
   		 {
   			 mibm.setIndex(i);
   			 return true;
   		 }
   	 }
		return false;
	}
	
	public void mouseInToFlipBuyable(ArrayList<Purchaseable> pList) {
		//allows for flip of board when mouse is in board
		for(int i = 0; i<pList.size(); i++)
   	 	{
//			if(!pList.get(0).getMouseInBox())
//			{
//				//System.out.println(getX());
//				//System.out.println(getY());
//				System.out.println(pList.get(0).getMouseInBox());
//			}
			if(getX() >= pList.get(i).getX() && getX() <= pList.get(i).getX()+pList.get(i).getLength() &&
					 getY() >= pList.get(i).getY() && getY() <= pList.get(i).getY()+pList.get(i).getHeight()
					 && mibp.getInsideBox() && !pList.get(i).getMouseInBox())
			{
				pList.get(i).setFrame(0);
				
				for (int l = 0;l<pList.size(); l++)
				{
					pList.get(l).setMouseInBox(false);
					if(l==i)
					{
						pList.get(l).setMouseInBox(true);
					}
				}
			}
			if(!mibp.getInsideBox() || getX() < pList.get(0).getX() 
					|| getX() > pList.get(0).getX()+pList.get(0).getLength()
					|| pList.get(i).getMouseInBox() && ( (getY() < pList.get(i).getY() 
					|| getY() > pList.get(i).getY()+pList.get(i).getHeight())))
			{
				for (int l = 0;l<pList.size(); l++)
				{
					pList.get(l).setMouseInBox(false);
				}
			}
   	 	}
	}
	
//	public void mouseInProducerToFlip(ArrayList<Producers> pList) {
//		for(int i = 0; i<pList.size(); i++)
//   	 {
		 
//   		 if(getX() > pList.get(i).getX() && getX() < pList.get(i).getX()+pList.get(i).getLength() &&
//   				 getY() > pList.get(i).getY() && getY() < pList.get(i).getY()+pList.get(i).getHeight() &&
//   				 pList.get(i).getFlipped() && !isInBoxNoFlip)
//   				 
//   		 {
////   			 if((pastX > pList.get(i).getX() && pastX < pList.get(i).getX()+pList.get(i).getLength() &&
////   				 pastY > pList.get(i).getY() && pastY < pList.get(i).getY()+pList.get(i).getHeight()))
//   			 
//   			 pList.get(i).setShowBoard(true);
//   			 pList.get(i).setFrame(0);
//   			 
//   			 //System.out.println( "psfddsf"+ pList.get(i).getY());
//   			 
//   			 pastY = getX();
//  			 pastX = getY();
//  			 isInBoxNoFlip = true;
//   			 
//   		 }
//		if(getX() < pList.get(i).getX() || getX() > pList.get(i).getX()+pList.get(i).getLength())
//			if(getY() < pList.get(i).getY() || getY() > pList.get(i).getY()+pList.get(i).getHeight()) //&&
//			 //pList.get(i).getFlipped())
//			{
//				System.out.println(pastY);
//				isInBoxNoFlip = false;
//			}
//   	 }
//	 for(int i = 0; i<pList.size(); i++)
//		 if((pastX > pList.get(i).getX() && pastX < pList.get(i).getX()+pList.get(i).getLength() &&
//			 pastY > pList.get(i).getY() && pastY < pList.get(i).getY()+pList.get(i).getHeight()))
//		 {
//			 System.out.println(pastY);
//			 
//		 }
//	}
	
	public void mouseInToFlipProducer(ArrayList<Producers> pList) {
		//allows for flip of board when mouse is in board
		for(int i = 0; i<pList.size(); i++)
   	 	{
//			if(!pList.get(0).getMouseInBox())
//			{
//				//System.out.println(getX());
//				//System.out.println(getY());
//				System.out.println(pList.get(0).getMouseInBox());
//			}
			if(getX() >= pList.get(i).getX() && getX() <= pList.get(i).getX()+pList.get(i).getLength() &&
					 getY() >= pList.get(i).getY() && getY() <= pList.get(i).getY()+pList.get(i).getHeight()
					 && mibp.getInsideBox() && !pList.get(i).getMouseInBox())
			{
				pList.get(i).setFrame(0);
				
				for (int l = 0;l<pList.size(); l++)
				{
					pList.get(l).setMouseInBox(false);
					if(l==i)
					{
						pList.get(l).setMouseInBox(true);
					}
				}
			}
			if(!mibp.getInsideBox() || getX() < pList.get(0).getX() 
					//|| getX() > pList.get(0).getX()+pList.get(0).getLength()
					|| getX() > pList.get(0).getX()+pList.get(0).getLength()*.05+pList.get(0).getLength()
					|| pList.get(i).getMouseInBox() && ((getY() < pList.get(i).getY() 
					|| getY() > pList.get(i).getY()+pList.get(i).getHeight())) )
			{
				for (int l = 0;l<pList.size(); l++)
				{
					pList.get(l).setMouseInBox(false);
				}
			}
   	 	}
	}
	
	public boolean mouseInProducer(ArrayList<Producers> pList, MouseInputBuyProducers mibm) {
		for(int i = 0; i<pList.size(); i++)
   	 {
   		 if(getX() > pList.get(i).getX() && getX() < pList.get(i).getX()+pList.get(i).getLength() &&
   				 getY() > pList.get(i).getY() && getY() < pList.get(i).getY()+pList.get(i).getHeight())
   		 {
   			 mibm.setIndex(i);
   			 return true;
   		 }
   	 }
		return false;
	}
	
	public boolean mouseInBanana() {
		// Checking to make sure that mouse is only able to click if is on banana exactly and not in just whitespace
		//if (getX() >= banana.getX() && getX() <= banana.getX()+banana.getWidth() && getY() >= banana.getY() && getY() <= banana.getY()+banana.getHeight())
		{
			// Each .02 is one pixel on the Banana
			// First Column of pixels from Left to Right
			if (getX() >= banana.getX()+ banana.getWidth()*.04 && 
					getX() <= banana.getX() + banana.getWidth()*.06 && 
					getY() <= banana.getY()+banana.getHeight()*.72 &&
				    getY() >= banana.getY()+banana.getHeight()*.61)
			{
				System.out.println(getY());
				return true;
			}
			
			// Second Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.06 && 
					getX() <= banana.getX() + banana.getWidth()*.08 && 
					getY() <= banana.getY()+banana.getHeight()*.78 &&
				    getY() >= banana.getY()+banana.getHeight()*.596)
			{
				return true;
			}
			
			// Third Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.08 && 
					getX() <= banana.getX() + banana.getWidth()*.1 && 
					getY() <= banana.getY()+banana.getHeight()*.82 &&
				    getY() >= banana.getY()+banana.getHeight()*.58)
			{
				return true;
			}
			
			// Fourth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.1 && 
					getX() <= banana.getX() + banana.getWidth()*.12 && 
					getY() <= banana.getY()+banana.getHeight()*.84 &&
				    getY() >= banana.getY()+banana.getHeight()*.58)
			{
				return true;
			}
			
			// Fifth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.12 && 
					getX() <= banana.getX() + banana.getWidth()*.14 && 
					getY() <= banana.getY()+banana.getHeight()*.86 &&
				    getY() >= banana.getY()+banana.getHeight()*.58)
			{
				return true;
			}
			
			// Sixth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.14 && 
					getX() <= banana.getX() + banana.getWidth()*.16 && 
					getY() <= banana.getY()+banana.getHeight()*.86 &&
				    getY() >= banana.getY()+banana.getHeight()*.6)
			{
				
				return true;
			}
			
			// Seventh Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.16 && 
					getX() <= banana.getX() + banana.getWidth()*.18 && 
					getY() <= banana.getY()+banana.getHeight()*.86 &&
				    getY() >= banana.getY()+banana.getHeight()*.6)
			{
				return true;
			}

			// Eighth-Ninth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.18 && 
					getX() <= banana.getX() + banana.getWidth()*.22 && 
					getY() <= banana.getY()+banana.getHeight()*.9 &&
				    getY() >= banana.getY()+banana.getHeight()*.6)
			{
				return true;
			}
			
			// Tenth-Twelfth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.22 && 
					getX() <= banana.getX() + banana.getWidth()*.28 && 
					getY() <= banana.getY()+banana.getHeight()*.92 &&
				    getY() >= banana.getY()+banana.getHeight()*.62)
			{
				return true;
			}
			
			// Thirteenth-Sixteenth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.28 && 
					getX() <= banana.getX() + banana.getWidth()*.36 && 
					getY() <= banana.getY()+banana.getHeight()*.94 &&
				    getY() >= banana.getY()+banana.getHeight()*.64)
			{
				return true;
			}
			
			// Seventeenth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.36 && 
					getX() <= banana.getX() + banana.getWidth()*.38 && 
					getY() <= banana.getY()+banana.getHeight()*.94 &&
				    getY() >= banana.getY()+banana.getHeight()*.66)
			{
				return true;
			}
			
			// Eighteenth-Twentieth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.38 && 
					getX() <= banana.getX() + banana.getWidth()*.44 && 
					getY() <= banana.getY()+banana.getHeight()*.96 &&
				    getY() >= banana.getY()+banana.getHeight()*.66)
			{
				return true;
			}
			
			// Twenty-first-TwentySecond Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.44 && 
					getX() <= banana.getX() + banana.getWidth()*.48 && 
					getY() <= banana.getY()+banana.getHeight()*.96 &&
				    getY() >= banana.getY()+banana.getHeight()*.64)
			{
				return true;
			}
			
			// TwentyFirst-TwentyThird Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.48 && 
					getX() <= banana.getX() + banana.getWidth()*.54 && 
					getY() <= banana.getY()+banana.getHeight()*.94 &&
				    getY() >= banana.getY()+banana.getHeight()*.64)
			{
				return true;
			}
			
			// TwentyFourth-TwentyFifth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.54 && 
					getX() <= banana.getX() + banana.getWidth()*.58 && 
					getY() <= banana.getY()+banana.getHeight()*.94 &&
				    getY() >= banana.getY()+banana.getHeight()*.62)
			{
				return true;
			}
			
			// TwentySixth-TwentySeventh Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.58 && 
					getX() <= banana.getX() + banana.getWidth()*.62 && 
					getY() <= banana.getY()+banana.getHeight()*.92 &&
				    getY() >= banana.getY()+banana.getHeight()*.60)
			{
				return true;
			}
			
			// TwentyEighth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.62 && 
					getX() <= banana.getX() + banana.getWidth()*.64 && 
					getY() <= banana.getY()+banana.getHeight()*.92 &&
				    getY() >= banana.getY()+banana.getHeight()*.56)
			{
				return true;
			}
			
			// TwentyNinth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.64 && 
					getX() <= banana.getX() + banana.getWidth()*.66 && 
					getY() <= banana.getY()+banana.getHeight()*.92 &&
				    getY() >= banana.getY()+banana.getHeight()*.54)
			{
				//System.out.print("BALLS");
				return true;
			}
			
			// Thirtieth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.66 && 
					getX() <= banana.getX() + banana.getWidth()*.68 && 
					getY() <= banana.getY()+banana.getHeight()*.90 &&
				    getY() >= banana.getY()+banana.getHeight()*.52)
			{
				return true;
			}
			
			// ThrityFirst Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.68 && 
					getX() <= banana.getX() + banana.getWidth()*.70 && 
					getY() <= banana.getY()+banana.getHeight()*.90 &&
				    getY() >= banana.getY()+banana.getHeight()*.50)
			{
				return true;
			}
			
			// ThirtySecond Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.70 && 
					getX() <= banana.getX() + banana.getWidth()*.72 && 
					getY() <= banana.getY()+banana.getHeight()*.88 &&
				    getY() >= banana.getY()+banana.getHeight()*.46)
			{
				return true;
			}
			
			// ThirtyThird Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.72 && 
					getX() <= banana.getX() + banana.getWidth()*.74 && 
					getY() <= banana.getY()+banana.getHeight()*.88 &&
				    getY() >= banana.getY()+banana.getHeight()*.40)
			{
				return true;
			}
			
			// ThirtyFourth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.74 && 
					getX() <= banana.getX() + banana.getWidth()*.76 && 
					getY() <= banana.getY()+banana.getHeight()*.86 &&
				    getY() >= banana.getY()+banana.getHeight()*.36)
			{
				return true;
			}
			
			// ThirtyFifth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.76 && 
					getX() <= banana.getX() + banana.getWidth()*.78 && 
					getY() <= banana.getY()+banana.getHeight()*.84 &&
				    getY() >= banana.getY()+banana.getHeight()*.34)
			{
				return true;
			}
			
			// ThirtySixth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.78 && 
					getX() <= banana.getX() + banana.getWidth()*.80 && 
					getY() <= banana.getY()+banana.getHeight()*.82 &&
				    getY() >= banana.getY()+banana.getHeight()*.30)
			{
				return true;
			}
			
			// ThirtySeventh Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.80 && 
					getX() <= banana.getX() + banana.getWidth()*.82 && 
					getY() <= banana.getY()+banana.getHeight()*.80 &&
				    getY() >= banana.getY()+banana.getHeight()*.10)
			{
				return true;
			}
			
			// ThirtyEighth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.82 && 
					getX() <= banana.getX() + banana.getWidth()*.84 && 
					getY() <= banana.getY()+banana.getHeight()*.78 &&
				    getY() >= banana.getY()+banana.getHeight()*.06)
			{
				return true;
			}
			
			// ThirtyNinth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.84 && 
					getX() <= banana.getX() + banana.getWidth()*.86 && 
					getY() <= banana.getY()+banana.getHeight()*.76 &&
				    getY() >= banana.getY()+banana.getHeight()*.04)
			{
				return true;
			}
			
			// Fortieth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.86 && 
					getX() <= banana.getX() + banana.getWidth()*.88 && 
					getY() <= banana.getY()+banana.getHeight()*.74 &&
				    getY() >= banana.getY()+banana.getHeight()*.02)
			{
				return true;
			}
			
			// FortyFirst Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.88 && 
					getX() <= banana.getX() + banana.getWidth()*.90 && 
					getY() <= banana.getY()+banana.getHeight()*.72 &&
				    getY() >= banana.getY()+banana.getHeight()*.02)
			{
				return true;
			}
			
			// FortySecond Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.90 && 
					getX() <= banana.getX() + banana.getWidth()*.92 && 
					getY() <= banana.getY()+banana.getHeight()*.68 &&
				    getY() >= banana.getY()+banana.getHeight()*.02)
			{
				return true;
			}
			
			// FortyThird Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.92 && 
					getX() <= banana.getX() + banana.getWidth()*.94)
					
			{
				if (getY() <= banana.getY()+banana.getHeight()*.16 &&
					    getY() >= banana.getY()+banana.getHeight()*.04)
						return true;
				if (getY() <= banana.getY()+banana.getHeight()*.66 &&
					    getY() >= banana.getY()+banana.getHeight()*.32)
						return true;
			}
			
			// FortyForth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.94 && 
					getX() <= banana.getX() + banana.getWidth()*.96 && 
					getY() <= banana.getY()+banana.getHeight()*.62 &&
				    getY() >= banana.getY()+banana.getHeight()*.34)
			{
				return true;
			}
			
			// FortySixth Column of Pixels from Left to Right
			else if (getX() >= banana.getX()+ banana.getWidth()*.96 && 
					getX() <= banana.getX() + banana.getWidth()*.98 && 
					getY() <= banana.getY()+banana.getHeight()*.56 &&
				    getY() >= banana.getY()+banana.getHeight()*.38)
			{
				return true;
			}

			else if (getX() >= banana.getX()+banana.getWidth()*.08 && 
					getX() <= banana.getX()+banana.getWidth()*.14 && 
					getY() <= banana.getY()+banana.getHeight() &&
					getY() >= banana.getY()+banana.getHeight()*.58)
			{
				//System.out.print("BALLS");
				return true;
			}
		}
		
		return false;
	
	}
	
	
}
