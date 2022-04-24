package objects;

public class GlobalPosition {
	public int myX;
	public int myY;
	
	public GlobalPosition(double x, double y) {
		this.myX = (int)x;
		this.myY = (int)y;
	}
	
	public int getX() {
		return myX;
	}
	
	public int getY() {
		return myY;
	}
	
	public void setX(double x) {
		myX = (int) x;
	}
	
	public void setY(double y) {
		myY = (int) y;
	}
}
