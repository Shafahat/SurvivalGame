
public class SafeHouse extends NormalLoc{

	SafeHouse(Player player) {
		super(player, "Safe House");
	}
	
	@Override
	public boolean getLocation() {
		player.setHeal(player.getHeal());
		System.out.println("You are healed");
		System.out.println("You are in safe house now");
		return true;
	}
}
