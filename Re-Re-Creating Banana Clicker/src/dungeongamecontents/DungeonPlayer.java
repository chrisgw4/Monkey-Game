package dungeongamecontents;

public class DungeonPlayer {

	private String myClass;
	private int myInitiative;
	
	public DungeonPlayer(String clas) {
		myClass = clas;
	}
	
	private void rollInitiative() {
		myInitiative = (int) (Math.random()*20+1);
	}
}
