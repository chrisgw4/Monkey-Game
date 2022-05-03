package objects;

public class GlobalPosition {
	public double myX;
	public double myY;
	
	public GlobalPosition(double x, double y) {
		this.myX = (int)x;
		this.myY = (int)y;
	}
	
	public double getX() {
		return myX;
	}
	
	public double getY() {
		return myY;
	}
	
	public void setX(double x) {
		myX = x;
	}
	
	public void setY(double y) {
		myY = y;
	}
}
