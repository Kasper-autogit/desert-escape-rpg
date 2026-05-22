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

        // =========================
        // WANDERER CLASS
        // =========================

        hero.name = "Wanderer";

        // Starting HP
        hero.hp = 75;

        // Random attack range
        hero.minAttack = 20;
        hero.maxAttack = 35;

        // Display class information
        System.out.println("\nClass Buff: Desert Survivor");
        System.out.println("Special Ability: Enhanced Water Foraging");

        // Display player stats
        System.out.println("\nHero Name: " + hero.name);
        System.out.println("Hero HP: " + hero.hp);
        System.out.println("Hero Attack Range: "
                + hero.minAttack + " - " + hero.maxAttack);

        // =========================
        // FIRST ENEMY
        // =========================

        Enemy SandRaider = new Enemy();

        SandRaider.name = "Sand Raider";
        SandRaider.hp = 75;

        // Sand Raider damage range
        SandRaider.minAttack = 8;
        SandRaider.maxAttack = 16;

        System.out.println("\nA Sand Raider attacks!");

        // =========================
        // FIRST BATTLE LOOP
        // =========================

        while (hero.hp > 0 && SandRaider.hp > 0) {

            // Display enemy stats
            System.out.println("\nEnemy Name: " + SandRaider.name);
            System.out.println("Enemy HP: " + SandRaider.hp);

            System.out.println("Enemy Attack Range: "
                    + SandRaider.minAttack + " - "
                    + SandRaider.maxAttack);

            // Player choices
            System.out.println("\nChoose an action:");

            System.out.println("1. Attack");
            System.out.println("2. Search for Water");
            System.out.println("3. Run");

            int choice = input.nextInt();

            // =========================
            // ATTACK OPTION
            // =========================

            if (choice == 1) {

                // Chance to miss attack
                int missChance = (int)(Math.random() * 100);

                // Player misses
                if (missChance < 20) {

                    System.out.println("\nYou go to attack and slip in the hot sand!");

                    System.out.println("*** MISS ***");

                }

                else {

                    // Enemy dodge chance
                    int dodgeChance = (int)(Math.random() * 100);

                    // Enemy dodges
                    if (dodgeChance < 15) {

                        System.out.println("\nThe Sand Raider dodges your attack!");

                    }

                    else {

                        // Random player damage
                        int damage = (int)(Math.random()
                                * (hero.maxAttack - hero.minAttack + 1))
                                + hero.minAttack;

                        // Crit chance
                        int critChance = (int)(Math.random() * 100);

                        // Critical hit
                        if (critChance < 15) {

                            damage = damage * 2;

                            System.out.println("\nCRITICAL HIT!");

                        }

                        SandRaider.hp = SandRaider.hp - damage;

                        // Prevent negative HP
                        if (SandRaider.hp < 0) {

                            SandRaider.hp = 0;

                        }

                        System.out.println("\nYou strike the Sand Raider!");

                        System.out.println("You deal "
                                + damage + " damage!");

                        System.out.println("Enemy HP: "
                                + SandRaider.hp);

                    }

                }

            }

            // =========================
            // SEARCH FOR WATER
            // =========================

            else if (choice == 2) {

                // 50/50 water chance
                int waterChance = (int)(Math.random() * 100);

                if (waterChance < 50) {

                    hero.hp = hero.hp + 12;

                    System.out.println("\nYou discover a hidden water flask!");

                    System.out.println("+12 HP");

                    System.out.println("Hero HP: " + hero.hp);

                }

                else {

                    System.out.println("\nYou search the desert but find no water...");

                }

            }

            // =========================
            // RUN OPTION
            // =========================

            else if (choice == 3) {

                int runChance = (int)(Math.random() * 100);

                // 50% escape chance
                if (runChance < 50) {

                    System.out.println("\nYou successfully escape!");

                    // Ends current battle only
                    SandRaider.hp = 0;

                }

                else {

                    System.out.println("\nYou slip in the burning sand!");

                    System.out.println("The Sand Raider blocks your escape!");

                }

            }

            // Invalid input
            else {

                System.out.println("\nInvalid choice!");

            }

            // =========================
            // SAND RAIDER TURN
            // =========================

            if (SandRaider.hp > 0) {

                // Random enemy move
                int enemyMove = (int)(Math.random() * 100);

                // SPECIAL MOVE
                if (enemyMove < 30) {

                    System.out.println("\nSPECIAL MOVE: Sand Storm!");

                    hero.hp = hero.hp - 3;

                    System.out.println("The swirling sand cuts your skin!");

                    System.out.println("-3 chip damage!");

                    System.out.println("Hero HP: " + hero.hp);

                }

                // NORMAL ATTACK
                else {

                    // Random miss chance
                    int enemyMiss = (int)(Math.random() * 100);

                    // Enemy misses
                    if (enemyMiss < 20) {

                        System.out.println("\nThe Sand Raider swings wildly!");

                        System.out.println("*** ENEMY MISS ***");

                    }

                    else {

                        // Player dodge chance
                        int playerDodge = (int)(Math.random() * 100);

                        // Player dodges
                        if (playerDodge < 15) {

                            System.out.println("\nYou dodge the Sand Raider attack!");

                        }

                        else {

                            // Random enemy damage
                            int enemyDamage = (int)(Math.random()
                                    * (SandRaider.maxAttack
                                    - SandRaider.minAttack + 1))
                                    + SandRaider.minAttack;

                            // Enemy crit chance
                            int enemyCrit = (int)(Math.random() * 100);

                            // Enemy critical hit
                            if (enemyCrit < 10) {

                                enemyDamage = enemyDamage * 2;

                                System.out.println("\nSAND RAIDER CRITICAL HIT!");

                            }

                            hero.hp = hero.hp - enemyDamage;

                            System.out.println("\nThe Sand Raider strikes you!");

                            System.out.println("The attack deals "
                                    + enemyDamage + " damage!");

                            System.out.println("Hero HP: " + hero.hp);

                        }

                    }

                }

            }

            // =========================
            // SUN DAMAGE
            // =========================

            hero.hp = hero.hp - 5;

            System.out.println("\nThe burning desert sun drains your energy!");

            System.out.println("-5 HP from heat.");

            System.out.println("Hero HP: " + hero.hp);

        }

        // =========================
        // FIRST ENEMY DEFEATED
        // =========================

        if (hero.hp > 0) {

            System.out.println("\nYou defeated the Sand Raider!");

            System.out.println("You inch closer toward safety...");

            // Victory reward heal
            hero.hp = hero.hp + 20;

            System.out.println("\nYou recover 20 HP after the battle!");

            System.out.println("Hero HP: " + hero.hp);

            // =========================
            // SECOND ENEMY
            // =========================

            Enemy SandSlug = new Enemy();

            SandSlug.name = "Giant Sand Slug";
            SandSlug.hp = 90;

            // Slug damage range
            SandSlug.minAttack = 6;
            SandSlug.maxAttack = 14;

            System.out.println("\nA Giant Sand Slug emerges from beneath the sand!");

            // =========================
            // SECOND BATTLE LOOP
            // =========================

            while (hero.hp > 0 && SandSlug.hp > 0) {

                System.out.println("\nEnemy Name: " + SandSlug.name);
                System.out.println("Enemy HP: " + SandSlug.hp);

                System.out.println("\nChoose an action:");

                System.out.println("1. Attack");
                System.out.println("2. Search for Water");
                System.out.println("3. Run");

                int choice = input.nextInt();

                // =========================
                // ATTACK
                // =========================

                if (choice == 1) {

                    // Player miss chance
                    int missChance = (int)(Math.random() * 100);

                    if (missChance < 20) {

                        System.out.println("\nYou swing and slip in the sand!");

                        System.out.println("*** MISS ***");

                    }

                    else {

                        // Enemy dodge chance
                        int dodgeChance = (int)(Math.random() * 100);

                        if (dodgeChance < 15) {

                            System.out.println("\nThe Giant Sand Slug dodges!");

                        }

                        else {

                            int damage = (int)(Math.random()
                                    * (hero.maxAttack - hero.minAttack + 1))
                                    + hero.minAttack;

                            // Crit chance
                            int critChance = (int)(Math.random() * 100);

                            if (critChance < 15) {

                                damage = damage * 2;

                                System.out.println("\nCRITICAL HIT!");

                            }

                            SandSlug.hp = SandSlug.hp - damage;

                            if (SandSlug.hp < 0) {

                                SandSlug.hp = 0;

                            }

                            System.out.println("\nYou slash the Giant Sand Slug!");

                            System.out.println("You deal "
                                    + damage + " damage!");

                            System.out.println("Enemy HP: " + SandSlug.hp);

                        }

                    }

                }

                // =========================
                // SEARCH WATER
                // =========================

                else if (choice == 2) {

                    int waterChance = (int)(Math.random() * 100);

                    if (waterChance < 50) {

                        hero.hp = hero.hp + 12;

                        System.out.println("\nYou discover hidden moisture beneath the sand!");

                        System.out.println("+12 HP");

                        System.out.println("Hero HP: " + hero.hp);

                    }

                    else {

                        System.out.println("\nYou fail to find water...");

                    }

                }

                // =========================
                // RUN
                // =========================

                else if (choice == 3) {

                    int runChance = (int)(Math.random() * 100);

                    if (runChance < 50) {

                        System.out.println("\nYou escape from the Giant Sand Slug!");

                        // End current battle only
                        SandSlug.hp = 0;

                    }

                    else {

                        System.out.println("\nThe sticky slime slows your movement!");

                    }

                }

                // =========================
                // GIANT SAND SLUG TURN
                // =========================

                if (SandSlug.hp > 0) {

                    // Random miss chance
                    int slugMiss = (int)(Math.random() * 100);

                    // Slug misses
                    if (slugMiss < 15) {

                        System.out.println("\nThe Giant Sand Slug misses!");

                    }

                    else {

                        // Player dodge chance
                        int playerDodge = (int)(Math.random() * 100);

                        // Player dodges
                        if (playerDodge < 15) {

                            System.out.println("\nYou dodge the slime attack!");

                        }

                        else {

                            // Random slug damage
                            int slugDamage = (int)(Math.random()
                                    * (SandSlug.maxAttack
                                    - SandSlug.minAttack + 1))
                                    + SandSlug.minAttack;

                            // Slug crit chance
                            int slugCrit = (int)(Math.random() * 100);

                            // Critical hit
                            if (slugCrit < 10) {

                                slugDamage = slugDamage * 2;

                                System.out.println("\nGIANT SAND SLUG CRITICAL HIT!");

                            }

                            hero.hp = hero.hp - slugDamage;

                            System.out.println("\nThe Giant Sand Slug slams into you!");

                            System.out.println("The attack deals "
                                    + slugDamage + " damage!");

                            // Goo chip damage
                            hero.hp = hero.hp - 2;

                            System.out.println("You are covered in burning slime!");

                            System.out.println("-2 Goo Damage!");

                            System.out.println("Hero HP: " + hero.hp);

                        }

                    }

                }

                // =========================
                // SUN DAMAGE
                // =========================

                hero.hp = hero.hp - 5;

                System.out.println("\nThe desert heat continues to burn you!");

                System.out.println("-5 HP from heat.");

                System.out.println("Hero HP: " + hero.hp);

            }

        }

        // =========================
        // PLAYER DEFEAT
        // =========================

        if (hero.hp <= 0) {

            System.out.println("\nYou collapse beneath the brutal desert sun...");

        }

        input.close();

    }

}
