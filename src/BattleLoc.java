
public abstract class BattleLoc extends Location {
	protected Enemy enemy;
	protected String award;

	BattleLoc(Player player, Enemy enemy, String name, String award) {
		super(player);
		this.enemy = enemy;
		this.locName = name;
		this.award = award;
	}

	@Override
	public boolean getLocation() {
		int cnt = enemy.enemyCount();
		System.out.println("You are on the " + this.getLocName());
		System.out.println("Be careful, you can encunter " + cnt + " " + enemy.getName() + "s");
		System.out.print("<F>ight or <R>un : ");
		String selCase = sc.nextLine();
		
		if(selCase.equalsIgnoreCase("F")) {
			if(Fight(cnt)) {
				System.out.println("All enemies were defeated!");
				if(this.award.equals("Food") && player.getInventory().isFood() == false) {
					System.out.println("You won " + this.award + "!");
					player.getInventory().setFood(true);		
				}
				else if(this.award.equals("Water") && player.getInventory().isWater() == false) {
					System.out.println("You won " + this.award + "!");
					player.getInventory().setWater(true);		
				}
				else if(this.award.equals("Wood") && player.getInventory().isWood() == false) {
					System.out.println("You won " + this.award + "!");
					player.getInventory().setWood(true);		
				}
				return true;
			}
			if(player.getHealth() <= 0) {
				System.out.println("You were killed at last war!");
				return false;
			}
		}
		return true;
	}
	
	public boolean Fight(int cnt) {
		for (int i = 0; i < cnt; i++) {
			int defEnemyHealth = enemy.getHealth();
			playerStats();
			enemyStats();
			while (player.getHealth() > 0 && enemy.getHealth() > 0) {
				System.out.print("<H>it or <R>un: ");
				String selCase = sc.nextLine();
				if(selCase.equalsIgnoreCase("H")) {
		 			System.out.println("You hit the enemy!");
					enemy.setHealth(enemy.getHealth() - player.totalDamage());
					afterHit();
					if(enemy.getHealth() > 0) {
						System.out.println("Enemy hits you!");
						player.setHealth(player.getHealth() - (enemy.getDamage() - player.getInventory().getArmor()));
						afterHit();
					}
				}
				else {
					return false;
				}
			}
			
			if(enemy.getHealth() <= 0 && player.getHealth() > 0) {
				System.out.println(enemy.getName()+ " was defeated!");
				player.setCash(player.getCash() + enemy.getAward());
				System.out.println("Your budget: " + player.getCash() + "$");
				enemy.setHealth(defEnemyHealth);
			}
			else {
				return false;
			}
			System.out.println("---------------------------------");
		}
		return true;
	}
	
	private void afterHit() {
		System.out.println("Your health: " + player.getHealth());
		System.out.println("Enemy's health: " + enemy.getHealth());
		System.out.println();		
	}

	public void playerStats() {
		System.out.println("---------------------------------");
		System.out.println("Information about Player:\n---------------------------");
		System.out.println("Health: " + player.getHealth());
		System.out.println("Damage: " + player.totalDamage());
		System.out.println("Budget: " + player.getCash() + "$");
		if(player.getInventory().getDamage() > 0) {
			System.out.println("Weapon: " + player.getInventory().getWeapon());
		}
		if(player.getInventory().getArmor() > 0) {
			System.out.println("Armory: " + player.getInventory().getArmory());
		}

	}
	
	public void enemyStats() {
		System.out.println("---------------------------------");
		System.out.println("Information about "+ enemy.getName() +":\n---------------------------");
		System.out.println("Health: " + enemy.getHealth());
		System.out.println("Damage: " + enemy.getDamage());
		System.out.println("Award: " + enemy.getAward() + "$");
	}

}
