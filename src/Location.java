import java.util.Scanner;

public abstract class Location {
	protected Player player;
	protected String locName;
	
	Scanner sc = new Scanner(System.in);
	
	Location(Player player){
		this.player = player;
	}
	
	public abstract boolean getLocation();

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}
	
}
