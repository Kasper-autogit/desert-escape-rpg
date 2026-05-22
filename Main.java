import java.util.Scanner;

// Main class runs the RPG game
public class Main {



    // Main method starts program
    public static void main(String[] args) {

      // Create scanner for player input
      Scanner input = new Scanner(System.in);


        // Welcome message
        System.out.println("Good luck, find some water!");

                // Display game intro
        System.out.println("You awaken alone in the desert...");
        System.out.println("The sun burns overhead.");
        System.out.println("You must survive and find a way out!");


        // Create player object
        Player hero = new Player();

        // Set player stats
        hero.name = "Wanderer";
        hero.hp = 125;
        hero.attack = 25;

        // Display player stats
        System.out.println("Hero Name: " + hero.name);
        System.out.println("Hero HP: " + hero.hp);
        System.out.println("Hero Attack: " + hero.attack);


        // Battle message
        System.out.println("A Sand Raider attacks!");

        // Display battle options
System.out.println("Choose an action:");

System.out.println("1. Attack");

System.out.println("2. Heal");

System.out.println("3. Run");

// Store player choice
int choice = input.nextInt();

        // Create enemy object
        Enemy goblin = new Enemy();

        // Set enemy stats
        goblin.name = "Sand Raider";
        goblin.hp = 75;
        goblin.attack = 10;

        // Display enemy stats
        System.out.println("Enemy Name: " + goblin.name);
        System.out.println("Enemy HP: " + goblin.hp);
        System.out.println("Enemy Attack: " + goblin.attack);

        // Player attacks goblin
        goblin.hp = goblin.hp - hero.attack;

        // Display updated goblin health
        System.out.println("Goblin HP after attack: " + goblin.hp);


        // Attack option
if (choice == 1) {

    goblin.hp = goblin.hp - hero.attack;

    System.out.println("You attack the enemy!");

    System.out.println("Enemy HP: " + goblin.hp);

}

    }

}
