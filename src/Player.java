import java.util.Scanner;

public class Player {
	private int health, damage, cash, heal;
	private String name, chaName;
	private Inventory inventory;
	
	Scanner sc = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
	}

	public void selectCha() {
		switch (chaMenu()) {
		case 1:
			initCha("Samurai", 21, 5, 15);
			break;
		case 2:
			initCha("Archer", 18, 7, 20);
			break;
		case 3:
			initCha("Chevailer", 24, 8, 5);
			break;
		default:
			initCha("Samurai", 21, 5, 15);
			break;
		}
		System.out.println();
		System.out.println(this.toString());
	}
	
	public int chaMenu() {
		System.out.println("Please choose the your character from the list");
		
		System.out.println("============================================================");		
		System.out.println("1- Samurai \t || Health: 21 \t || Damage: 5 \t || Cash:15$");
		System.out.println("2- Archer \t || Health: 18 \t || Damage: 7 \t || Cash:20$");
		System.out.println("3- Chevailer \t || Health: 24 \t || Damage: 8 \t || Cash:5$");
		System.out.println("============================================================");		

		System.out.print("Please enter the number of character you want to play: ");
		
		int chaID = sc.nextInt();
		
		while(chaID < 1 || chaID > 3) {
			System.out.print("Please enter valid number: ");	
			chaID = sc.nextInt();
		}
		
		return chaID;
	}
	
	public void initCha(String chaName, int health, int damage, int cash) {
		setChaName(chaName);
		setHealth(health);
		setDamage(damage);
		setCash(cash);
		setHeal(health);
	}
	
	public int getHeal() {
		return heal;
	}

	public void setHeal(int heal) {
		this.heal = heal;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChaName() {
		return chaName;
	}

	public void setChaName(String chaName) {
		this.chaName = chaName;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	
	@Override
	public String toString() {
		return "Character: " + getChaName() + ", Health: " + getHealth() + ", Damage: " + getDamage() + ", Cash: " + getCash() +"$";
	}
	
	public int totalDamage() {
		return this.getDamage() + this.getInventory().getDamage();
	}
	
}
