import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner sc = new Scanner(System.in);

	public void login() {
		System.out.println("Welcome to the Survival Game!");
//		System.out.println("Enter the name: ");
//		String playerName = sc.nextLine();
		player = new Player("A"); 
		player.selectCha();
		start();	
	}
	
	public void start() {
		while(true) {
			System.out.println();
			System.out.println("============================================================");		
			System.out.println();
			System.out.println("Please choose Location from list");
			System.out.println("============================================================");		
			System.out.println("1- Safe House --> Your own safe place, no enemy!");
			System.out.println("2- Cave --> There can be Zombie");
			System.out.println("3- Forest --> There can be Bear");
			System.out.println("4- Lake --> There can be Vampire");
			System.out.println("5- Store --> Buy weapon or shield");
			System.out.println("============================================================");	
			System.out.print("Please enter the number of location you want to play:");
			
			int locID = sc.nextInt();
			
			while(locID < 1 || locID > 5) {
				System.out.print("Please enter valid number: ");	
				locID = sc.nextInt();
			}

			switch (locID) {
			case 1: 
				location = new SafeHouse(player);
				break;
			case 2: 
				location = new Cave(player);
				break;
			case 3: 
				location = new Forest(player);
				break;
			case 4: 
				location = new Lake(player);
				break;
			case 5: 
				location = new Store(player);
				break;
			default:
				location = new SafeHouse(player);
				break;
			}
			
			if(location.getClass().getName().equals("Safe House")) {
				if(player.getInventory().isWood() && player.getInventory().isFood() && player.getInventory().isWater()) {
					System.out.println("Congratilations, You win the game!");
					break;
				}
			}
			
			if(!location.getLocation()) {
				System.out.println("Game Over");
				break;
			}
		}
	}
	
}
