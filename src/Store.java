
public class Store extends NormalLoc {

	Store(Player player) {
		super(player, "Store");
	}

	@Override
	public  boolean getLocation() {
		System.out.println("Budget: " + player.getCash() + "$");
		System.out.println("1. Weapon");
		System.out.println("2. Armory");
		System.out.println("3. Exit");
		System.out.print("Select: ");
		int selTool = sc.nextInt();
		int selItemID; 
		switch (selTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = armoryMenu();
			buyArmory(selItemID);
			break;
		default:
			break;
		}
		return true;
	}

	public void buyWeapon(int selItemID) {
		String weapon = null;
		int damage = 0, price = 0;
		
		switch (selItemID) {
		case 1:
			damage = 2;
			weapon = "Colt";
			price = 25;
			break;
		case 2:
			damage = 3;
			weapon = "Sword";
			price = 25;
			break;
		case 3:
			damage = 7;
			weapon = "Rifle";
			price = 45;
			break;
		case 4:
			System.out.println("Exiting");
			break;
		default:
			System.out.println("Wrong transaction!");			
			break;
		}
		
		if(price > 0) {
			if(player.getCash() > price) {
				player.getInventory().setDamage(damage);
				player.getInventory().setWeapon(weapon);
				player.setCash(player.getCash() - price);
				System.out.println("New damage: " + player.totalDamage());
				System.out.println("Budget: " + player.getCash());
			}
			else {
				System.out.println("Unsifficient budget");
			}
		}
		
	}
	
	public void buyArmory(int selItemID) {
		String armory = null;
		int avoid = 0, price = 0;
		
		switch (selItemID) {
		case 1:
			avoid = 1;
			armory = "Light";
			price = 15;
			break;
		case 2:
			avoid = 3;
			armory = "Middle";
			price = 25;
			break;
		case 3:
			avoid = 5;
			armory = "Heavy";
			price = 40;
			break;
		case 4:
			System.out.println("Exiting");
			break;
		default:
			System.out.println("Wrong transaction!");			
			break;
		}
		
		if(price > 0) {
			if(player.getCash() >= price) {
				player.getInventory().setArmor(avoid);
				player.getInventory().setArmory(armory);
				player.setCash(player.getCash() - price);
				System.out.println("Prevented damage: " + player.getInventory().getArmor());
				System.out.println("Budget: " + player.getCash());
			}
			else {
				System.out.println("Unsifficient budget");
			}
		}
	}

	public int weaponMenu() {
		System.out.println("1- Colt \t <value: 25$ - damage: 2>");
		System.out.println("2- Sword\t <value: 35$ - damage: 3>");
		System.out.println("3- Rifle\t <value: 45$ - damage: 7>");
		System.out.println("4- Exit");
		System.out.print("Choose weapon: ");
		int selWeapon = sc.nextInt();
		return selWeapon;
	}
	
	public int armoryMenu() {
		System.out.println("1- Light Armory \t <value: 15$ - avoid: 1>");
		System.out.println("2- Middle Armory\t <value: 25$ - avoid: 3>");
		System.out.println("3- Heavy Armory\t <value: 40$ - avoid: 5>");
		System.out.println("4- Exit");
		System.out.print("Choose armory: ");
		int selArmory = sc.nextInt();
		return selArmory;
	}
	
	
}
