package objects;

import Panels.EverythingPanel;

public class Producers extends Purchaseable{

	private double productionAmount;
	
	private double myBasePrice;
	
	
	
	public Producers(double x, double y, String name, double cost, int width, int height, double produceAmount) {
		super(x, y, name, cost, width, height);
		productionAmount = produceAmount;
		myBasePrice = cost;
	}
	
	public void update(double FPS) {
		EverythingPanel.getPlayer().setCount((productionAmount/FPS)*this.getAmountOwned());
		//System.out.println(this.productionAmount*this.getAmountOwned());
	}
	
	public double getProductionAmount() {
		return productionAmount;
	}
	
	public void setPrice(double x) {
		super.setPrice(x);
	}
	
	public double getPrice() {
		return super.getPrice();
	}
	
	public double getBasePrice() {
		return myBasePrice;
	}

	

	

}
