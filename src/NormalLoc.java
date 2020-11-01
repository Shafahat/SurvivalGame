
public abstract class NormalLoc extends Location{

	NormalLoc(Player player, String name) {
		super(player);
		this.locName = name;
	}

	@Override
	public boolean getLocation() {
		return true;
	}

}
