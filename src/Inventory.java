
public class Inventory {
	private boolean water, food, wood;
	private String weapon, armory;
	private int damage, armor; 
	
	Inventory(){
		this.water = false;
		this.food = false;
		this.wood = false;
		this.damage = 0;
		this.armor = 0;
		this.weapon = null;
		this.armory = null;
	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean isWood() {
		return wood;
	}

	public void setWood(boolean wood) {
		this.wood = wood;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public String getArmory() {
		return armory;
	}

	public void setArmory(String armory) {
		this.armory = armory;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
	
}
