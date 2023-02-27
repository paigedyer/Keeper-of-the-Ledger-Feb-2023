import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.*;

import static java.lang.System.exit;

public class Main {

    private static ArrayList<NPC> NPCList = new ArrayList<NPC>();
    private static List<Item> inventoryList = new ArrayList<>();

    // Variables
    public static boolean winFight = false;

    public static boolean characterCreation = true;


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userIn = "-1";

        // Create character objects
        Self self = new Self(3,3,3,false);
        Oliver oliver = new Oliver(1, 1, 1, 200, 400, "Oliver the Upright Hog");
        Mortas mortas = new Mortas(6, 3, 8, 400, 400, "Mortas Sanguine the Vampiric Lord");
        enemy dominique = new enemy(5, 2, 6, 400, 600, "Dominique the Succubus");
        friendly cinder = new friendly(2, 3, 9, 200, 400, "Cinder the Eternal Fire");
        friendly blossom = new friendly(5,3,12,300, 500, "Blossom the Nymph Queen");
        enemy dray = new enemy(25,4,10, 600, 600, "Dray the Bottomless Pit");

        // Create shard objects
        Shards shard1 = new Shards(false, 1, "Shard 1: Irony");
        Shards shard2 = new Shards(false, 1, "Shard 2: Love and Desire");
        Shards shard3 = new Shards(false, 1, "Shard 3: Consequence");
        Shards shard4 = new Shards(false, 1, "Shard 4: Fear");
        Shards shard5 = new Shards(false, 1, "Shard 5: The Plants and Animals");
        Shards shard6 = new Shards(false, 1, "Shard 6: The After");


        String currentLocation = "null";

        while (userIn == "-1") {
            System.out.println("Welcome to the Keeper of the Ledger. Start a new game? (y/n)");
            userIn = scnr.nextLine();
            if ((userIn.equalsIgnoreCase("no") || (userIn.equalsIgnoreCase("n")))) {
                quit();
            }
            if ((userIn.equalsIgnoreCase("yes")) || (userIn.equalsIgnoreCase("y"))) {
                System.out.println("Welcome to my game! This is still in development and for the time being is only\n" +
                                "a text based game. I love feedback, so if you have it message me on discord at:\n" +
                                "          ItPongu#2845\n");
                gameStarting();
                //initializeShards();

                initializeSelf(self);
                initializeOliver(oliver);

                // Character creation screen
                while (characterCreation) {
                    characterCreation(self);
                }

                currentLocation = "Courtyard";

                // GAME LOOP HERE
                while (userIn != "QUIT") {
                    if (self.getLevelUp() == true) {
                        loop: while (self.getLevelUp() == true) {
                            System.out.printf("You have leveled up, pick an attribute to add a point to:\n" +
                                    "Endurance: %s\n" +
                                    "Strength: %s\n" +
                                    "Charisma: %s\n", self.getEndurance(), self.getStrength(), self.getCharisma());
                            userIn = scnr.nextLine();
                            switch (userIn) {
                                case "endurance":
                                    System.out.printf("Level up Endurance to %s? (y/n)", (self.getEndurance() + 1));
                                    userIn = scnr.nextLine();
                                    if (userIn.equalsIgnoreCase("y")) {
                                        self.setEndurance(self.getEndurance() + 1);
                                        System.out.printf("Attributes:\n" +
                                                "Endurance: %s\n" +
                                                "Strength: %s\n" +
                                                "Charisma: %s\n", self.getEndurance(), self.getStrength(), self.getCharisma());
                                        self.setLevelUp(false);
                                        while (userIn.length() > 0) {
                                            System.out.println("[Press enter]");
                                            userIn = scnr.nextLine();
                                        }
                                        userIn = "null";
                                        break loop;
                                    }
                                    else if (userIn.equalsIgnoreCase("n")) {
                                        break;
                                    }
                                case "strength":
                                    System.out.printf("Level up Strength to %s? (y/n)", (self.getStrength() + 1));
                                    userIn = scnr.nextLine();
                                    if (userIn.equalsIgnoreCase("y")) {
                                        self.setStrength(self.getStrength() + 1);
                                        System.out.printf("Attributes:\n" +
                                                "Endurance: %s\n" +
                                                "Strength: %s\n" +
                                                "Charisma: %s\n", self.getEndurance(), self.getStrength(), self.getCharisma());
                                        self.setLevelUp(false);
                                        while (userIn.length() > 0) {
                                            System.out.println("[Press enter]");
                                            userIn = scnr.nextLine();
                                        }
                                        userIn = "null";
                                        break loop;
                                    }
                                    else if (userIn.equalsIgnoreCase("n")) {
                                        break;
                                    }
                                case "charisma":
                                    System.out.printf("Level up Charisma to %s? (y/n)", (self.getCharisma() + 1));
                                    userIn = scnr.nextLine();
                                    if (userIn.equalsIgnoreCase("y")) {
                                        self.setCharisma(self.getCharisma() + 1);
                                        System.out.printf("Attributes:\n" +
                                                "Endurance: %s\n" +
                                                "Strength: %s\n" +
                                                "Charisma: %s\n", self.getEndurance(), self.getStrength(), self.getCharisma());
                                        self.setLevelUp(false);
                                        while (userIn.length() > 0) {
                                            System.out.println("[Press enter]");
                                            userIn = scnr.nextLine();
                                        }
                                        userIn = "null";
                                        break loop;
                                    }
                                    else if (userIn.equalsIgnoreCase("n")) {
                                        break;
                                    }

                            }
                        }
                    }
                    System.out.printf("You are in the %s, where would you like to go?\n", currentLocation);
                    userIn = scnr.nextLine();
                    switch (userIn) {
                        case "go north":
                            //System.out.println("This has not been implemented yet");
                            switch (currentLocation) {
                                case "Courtyard":
                                    currentLocation = "Barn";
                                    System.out.println("[You travel down a rocky northern path and follow a familiar scent that reminds you of home.]\n");
                                    courtyard(self, oliver, shard1);
                                    break;

                                case "Barn":
                                    currentLocation = "Cave";
                                    System.out.println("[You walk down a wooded path, that at first has fireflies and woodland rodents scurrying about.\n" +
                                            "But the further you travel, the path darkens, and the wildlife disperses.\n");
                                    cave(self, mortas, shard4);
                                    break;

                                case "Wardrobe":
                                    currentLocation = "Burning Forest";
                                    System.out.printf("You are in the %s\n", currentLocation);
                                    forest(self, cinder, shard3);
                                    break;

                                case "Burning Forest":
                                    System.out.println("You cannot go that way.");
                                    break;

                                case "Cave":
                                    System.out.println("You cannot go that way.\n");
                                    break;

                                case "Meadow":
                                    System.out.println("You cannot go that way.");
                                    break;

                                case "Pit":
                                    System.out.println("You cannot go that way.");
                                    break;

                                case "Final":
                                    System.out.println("The door out won't open.");
                                    break;

                                default:
                                    System.out.println("This has not been implemented yet.");
                                    break;
                            }
                            break;

                        case "go south":
                            switch (currentLocation) {
                                case "Courtyard":
                                    currentLocation = "Courtyard";
                                    System.out.println("You cannot go that way.");
                                    break;

                                case "Barn":
                                    currentLocation = "Courtyard";
                                    System.out.println("You are entering the Courtyard.");
                                    break;

                                case "Wardrobe":
                                    System.out.println("You cannot go that way.");
                                    break;

                                case "Burning Forest":
                                    currentLocation = "Wardrobe";
                                    System.out.printf("You are in the %s\n", currentLocation);
                                    wardrobe(self, dominique, shard2);
                                    break;

                                case "Cave":
                                    currentLocation = "Barn";
                                    System.out.printf("You are in the %s\n", currentLocation);
                                    courtyard(self, oliver, shard1);
                                    break;

                                case "Meadow":
                                    System.out.println("You cannot go that way.");
                                    break;

                                case "Pit":
                                    currentLocation = "Final";
                                    System.out.printf("You are in the %s\n", currentLocation);
                                    System.out.println("The boss fight at the end of this adventure has not been implemented yet...\n" +
                                            "so....\n");
                                    while (userIn.length() > 0) {
                                        System.out.println("Press enter to continue");
                                        userIn = scnr.nextLine();
                                    }
                                    System.out.println("You win! Congratulations!");
                                    System.exit(0);
                                    break;

                                case "Final":
                                    System.out.println("This has not been implemented yet.");
                                    break;

                                default:
                                    System.out.println("This has not been implemented yet.");
                                    break;
                            }
                            break;

                        case "go east":
                            switch (currentLocation) {
                                case "Courtyard":
                                    System.out.println("You cannot go that way.");
                                    break;

                                case "Barn":
                                    currentLocation = "Meadow";
                                    System.out.println("You are entering the Meadow");
                                    meadow(self, blossom, shard5);
                                    break;

                                case "Wardrobe":
                                    currentLocation = "Barn";
                                    System.out.println("You are entering the Barn");
                                    courtyard(self, oliver, shard1);
                                    break;

                                case "Burning Forest":
                                    currentLocation = "Cave";
                                    System.out.println("You are entering the Cave");
                                    cave(self, mortas, shard4);
                                    break;

                                case "Cave":
                                    System.out.println("You cannot go that way.");
                                    break;

                                case "Meadow":
                                    currentLocation = "Pit";
                                    System.out.println("You are entering the Pit.");
                                    pit(self, dray, shard6);
                                    break;

                                case "Pit":
                                    System.out.println("You cannot go that way.");
                                    break;

                                case "Final":
                                    System.out.println("You cannot leave this room");
                                    break;

                                default:
                                    System.out.println("Invalid input");
                                    break;
                            }
                            break;

                        case "go west":
                            switch (currentLocation) {
                                case "Courtyard":
                                    System.out.println("You cannot go that way.");
                                    break;

                                case "Barn":
                                    currentLocation = "Wardrobe";
                                    System.out.println("You are entering the Wardrobe");
                                    wardrobe(self, dominique, shard2);
                                    break;

                                case "Wardrobe":
                                    System.out.println("You cannot go that way.");
                                    break;

                                case "Burning Forest":
                                    System.out.println("You cannot go that way.");
                                    break;

                                case "Cave":
                                    currentLocation = "Burning Forest";
                                    System.out.println("You are entering the Burning Forest.");
                                    forest(self, cinder, shard3);
                                    break;

                                case "Meadow":
                                    currentLocation = "Barn";
                                    System.out.println("You are entering the Barn");
                                    courtyard(self, oliver, shard1);
                                    break;

                                case "Pit":
                                    currentLocation = "Meadow";
                                    System.out.println("You are entering the Meadow");
                                    meadow(self, blossom, shard5);
                                    break;

                                case "Final":
                                    System.out.println("You cannot leave this room.");
                                    break;

                                default:
                                    System.out.println("This has not been implemented yet.");
                                    break;
                            }
                            break;

                        case "QUIT":
                            quit();
                            break;

                        case "HELP":
                            displayControls();
                            break;

                        case "STATS":
                            displayStats(self);
                            break;

                        case "INVENTORY":
                            System.out.println("This has not been implemented yet");
                            System.out.println(inventoryList.toString());
                            break;

                        default:
                            System.out.println("Invalid input. Type \"HELP\" for a list of commands.");
                            break;
                    }


                }

            } else {
                System.out.println("Invalid input");
                userIn = "-1";
            }
        }

    }

    public static void characterCreation(Self me) {
        // in progress
        String userIn = "-1";
        int points = 11;
        int charisma = me.getCharisma();
        int strength = me.getStrength();
        int endurance = me.getEndurance();

        int sum = charisma + strength + endurance;

        int remaining = 11 - sum;

        int userIntIn;

        boolean change = true;

        Scanner scnr = new Scanner(System.in);
        System.out.printf("Create your character here.\n" +
                "Points remaining: %s \n" +
                "Charisma: %s\n" +
                "Strength: %s\n" +
                "Endurance: %s\n" +
                "Make changes? (Y/N)\n",remaining, charisma, strength, endurance);
        userIn = scnr.nextLine();
        if (userIn.equalsIgnoreCase("Y")) {
            while (change) {
                System.out.println("Change what?");
                // Use printf and Self() class
                userIn = scnr.next();
                try {
                    if (userIn.equalsIgnoreCase("charisma")) {
                        System.out.println("+/- how many points?");
                        userIntIn = scnr.nextInt();
                        charisma = charisma + userIntIn;
                        remaining = remaining - userIntIn;

                        if (((sum) > points) || (remaining < 0)) {
                            charisma = charisma - userIntIn;
                            remaining = remaining + userIntIn;
                            System.out.printf("Not enough points remaining. You have %s points remaining\n", remaining);
                        }
                        if ((charisma) <= 0) {
                            charisma = charisma - userIntIn;
                            remaining = remaining + userIntIn;
                            System.out.printf("Cannot have less than 1 point in each skill. You have %s points remaining\n", remaining);
                        }
                        if ((sum) <= points) {
                            System.out.printf(
                                    "Points remaining: %s \n" +
                                            "Charisma: %s\n" +
                                            "Strength: %s\n" +
                                            "Endurance: %s\n" +
                                            "Make changes? (Y/N)\n", remaining, charisma, strength, endurance);
                            userIn = scnr.next();

                            if (userIn.equalsIgnoreCase("y")) {}

                            if (userIn.equalsIgnoreCase("n")) { break; }
                        }

                    }
                }
                catch(InputMismatchException e) {System.out.println("Invalid input");}

                try {
                    if (userIn.equalsIgnoreCase("strength")) {
                        System.out.println("+/- how many points?");
                        userIntIn = scnr.nextInt();
                        strength = strength + userIntIn;
                        remaining = remaining - userIntIn;
                        if ((sum) > points || (remaining < 0)) {
                            strength = strength - userIntIn;
                            remaining = remaining + userIntIn;
                            System.out.printf("Not enough points remaining. You have %s points remaining\n", remaining);
                        }
                        if ((strength) <= 0) {
                            strength = strength - userIntIn;
                            remaining = remaining + userIntIn;
                            System.out.printf("Cannot have less than 1 point in each skill. You have %s points remaining\n", remaining);
                        }
                        if ((sum) <= points) {
                            System.out.printf(
                                    "Points remaining: %s \n" +
                                            "Charisma: %s\n" +
                                            "Strength: %s\n" +
                                            "Endurance: %s\n" +
                                            "Make changes? (Y/N)\n", remaining, charisma, strength, endurance);
                            userIn = scnr.next();

                            if (userIn.equalsIgnoreCase("y")) {}

                            if (userIn.equalsIgnoreCase("n")) { break; }
                        }
                    }
                }
                catch(InputMismatchException e) {System.out.println("Invalid input");}

                try {
                    if (userIn.equalsIgnoreCase("endurance")) {
                        System.out.println("+/- how many points?");
                        userIntIn = scnr.nextInt();
                        endurance = endurance + userIntIn;
                        remaining = remaining - userIntIn;

                        if ((sum) > points || (remaining < 0)) {
                            endurance = endurance - userIntIn;
                            remaining = remaining + userIntIn;
                            System.out.printf("Not enough points remaining. You have %s points remaining\n", remaining);
                        }

                        if ((endurance) <= 0) {
                            endurance = endurance - userIntIn;
                            remaining = remaining + userIntIn;
                            System.out.printf("Cannot have less than 1 point in each skill. You have %s points remaining\n", remaining);
                        }

                        if ((sum) <= points) {
                            System.out.printf(
                                    "Points remaining: %s \n" +
                                            "Charisma: %s\n" +
                                            "Strength: %s\n" +
                                            "Endurance: %s\n" +
                                            "Make changes? (Y/N)\n", remaining, charisma, strength, endurance);
                            userIn = scnr.next();
                            if (userIn.equalsIgnoreCase("y")) {}

                            if (userIn.equalsIgnoreCase("n")) { break; }
                        }
                    }
                }
                catch(InputMismatchException e) {System.out.println("Invalid input");}
            }
        }
        if (userIn.equalsIgnoreCase("n")) {
            characterCreation = false;
        }
        else {
            switch (userIn) {
                case "QUIT":
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                case "HELP":
                    displayControls();
                    break;

                case "STATS":
                    System.out.println("This has not been implemented yet");
                    break;

                case "INVENTORY":
                    System.out.println("This has not been implemented yet");
                    System.out.println(inventoryList.toString());
                    break;

                default:
                    System.out.println("Invalid input. Type \"HELP\" for a list of commands.");
                    break;
            }
            }
        me.setCharisma(charisma);
        me.setEndurance(endurance);
        me.setStrength(strength);
        }


    public static void displayStats(Self me) {
        System.out.printf("Stats:\n" +
                "Charisma: %s\n" +
                "Endurance: %s\n" +
                "Strength: %s\n", me.getCharisma(), me.getEndurance(), me.getStrength());
    }

    public static void dialogueControls() {
        System.out.println("Enter either a capital A, B or C to choose a dialogue option. \n" +
                "Or type \"QUIT\" to quit the game (progress is not saved)");
    }



    public static void viewInventory() {
        if (inventoryList.size() == 0) {
            System.out.print("Nothing in inventory");
        } else {
            System.out.println(inventoryList);
        }
    }

    public static void quit() {
        System.out.println("Goodbye!");
        exit(0);
    }

    public static void gameStarting() {
        Scanner scnr = new Scanner(System.in);
        String userIn = "null";

        System.out.println("You enter a large labyrinth. You have heard a rumor that if you defeat the Keeper of the\n" +
                "Ledger that resides at the end, you may gain immortality.");
        displayControls();

        while (userIn.length() > 0) {
            System.out.println("Press enter to continue");
            userIn = scnr.nextLine();
        }
        userIn = "null";

    }

    public static void displayControls() {
        System.out.println("Move between rooms by typing \"go north\", \"go south\", \"go west\", or \"go east\".");
        System.out.println("View your inventory by typing \"INVENTORY\".");
        System.out.println("View the list of controls by typing \"HELP\".");
        System.out.println("View your stats an by typing \"STATS\".");
        System.out.println("Quit the game by typing \"QUIT\" (progress is not saved).");
    }

    /*public static void initializeShards() {
        Shards shard1 = new Shards(false, 1);
        Shards shard2 = new Shards(false, 1);
        Shards shard3 = new Shards(false, 1);
        Shards shard4 = new Shards(false, 1);
        Shards shard5 = new Shards(false, 1);
        Shards shard6 = new Shards(false, 1);

    }*/

    public static void courtyard(Self me, Oliver oliver, Shards shard1) {
        Scanner scnr = new Scanner(System.in);
        String userIn = "-1";

        boolean dialogue = true;
        // if shard is in inventory, if oliver is dead
        if (shard1.isInInventory() == true) {
            System.out.printf("You have already completed this room.\n");

        } else {
            while (userIn.length() > 0) {
                System.out.println("You arrive at a barn, and a creature who appears to be half-man half-hog approaches you. You cower in fear for a moment before" +
                        "he speaks to you. \n \n" +
                        "\"Hello! Oh wow I haven't had a visitor in years! I don't intend to harm you, please come in!\" \n" +
                        "Press enter.");
                userIn = scnr.nextLine();
            }

            userIn = "-1";

            loop: while (dialogue) {

                System.out.println("A. \"Who are you? Why do you look like that?\"");
                System.out.println("B. \"Where am I?\"");
                System.out.println("C. \"Creatures like you don't deserve to stay alive.\"");
                //System.out.println(userIn);

                userIn = scnr.nextLine();
                //System.out.println(userIn);

                switch (userIn) {

                    case ("A"):
                        //System.out.println("Dialogue continues");
                        courtyardDialogueA(me, oliver, shard1);
                        break loop;

                    case ("B"):
                        //System.out.println("Dialogue continues");
                        courtyardDialogueB();
                        break;

                    case ("C"):
                        System.out.println("Fight");
                        Fight(me, oliver, shard1);
                        break loop;

                    case "QUIT":
                        System.out.println("This has not been implemented yet");
                        break;

                    case "HELP":
                        System.out.println("This has not been implemented yet");
                        break;

                    case "STATS":
                        System.out.println("This has not been implemented yet");
                        break;

                    case "INVENTORY":
                        System.out.println("This has not been implemented yet");
                        break;

                    default:
                        System.out.println("Invalid input. Enter A B or C.");

                }
            }
        }
    }

    public static void Fight(Self me, NPC npc, Shards shard) {
        String npcName = npc.getName();
        int npcEndRoll;
        int max = npc.getEndurance();
        int HP = npc.getEndurance();
        int attack = npc.getStrength();

        String shardName = shard.getName();

        int min = 1;

        int selfEndRoll;
        int selfMax = me.getEndurance();
        int selfHP = me.getEndurance();
        int selfAttack = me.getStrength();

        Scanner scnr = new Scanner(System.in);
        String userIn = "null";

        npcEndRoll = randomNum(max);
        selfEndRoll = randomNum(selfMax);


        //npcEndRoll = (int)Math.floor(Math.random() * (max - min) + min);

        //selfEndRoll = (int)Math.floor(Math.random() * (selfMax - min) + min);

        winFight = false;

        //System.out.printf("%s, %s", npcEndRoll, selfEndRoll);
        if (npcEndRoll > selfEndRoll) {
            System.out.printf("%s rolled a %s and you rolled a %s for Endurance. So %s goes first.\n",npcName, npcEndRoll, selfEndRoll, npcName);
            selfHP = selfHP - attack;
            System.out.printf("%s attacks you for %s HP. You have %s HP remaining.\n",npcName, attack, selfHP);
            while (userIn.length() > 0) {
                System.out.println("Press enter to continue");
                userIn = scnr.nextLine();
            }
            userIn = "null";
            if (selfHP <= 0) {
                System.out.printf("You have 0 HP remaining and have died. You lost the game!");
                System.exit(0);
            }
            else {
                while (!winFight) {
                    System.out.printf("Do you want to:\n" +
                            "A: Attack\n" +
                            "B: Talk yourself out\n");
                    userIn = scnr.next();
                    if (userIn.equalsIgnoreCase("A")) {
                        HP = HP - selfAttack;
                        if (HP > 0) {
                            System.out.printf("You attack %s for %s HP. You have %s HP remaining and %s has %s HP remaining\n", npcName, selfAttack, selfHP, npcName, HP);
                        }
                        else if (HP <= 0){
                                System.out.printf("%s has 0 HP remaining and has died. %s drops %s.\n", npcName, npcName, shardName);
                                shard.setInInventory(true);
                                me.setLevelUp(true);
                                winFight = true;
                                break;
                        }
                    }
                    if (userIn.equalsIgnoreCase("B")) {
                        System.out.printf("You attempt to talk yourself out of the fight");
                        if (me.getCharisma() >= npc.getCharisma()) {
                            // TODO Add shard variable to classes
                            System.out.printf("You successfully talked yourself out of the fight and %s was added to your inventory.", shardName);
                            me.setLevelUp(true);
                            shard.setInInventory(true);
                            winFight = true;
                        } else {
                            System.out.printf("You were unable to talk yourself out of the fight");
                        }
                    }
                    selfHP = selfHP - attack;
                    System.out.printf("%s attacks you for %s HP. You have %s HP remaining.\n",npcName, attack, selfHP);
                    if (selfHP <= 0) {
                        System.out.printf("You have 0 HP remaining and have died. You lost the game!");
                        System.exit(0);
                    }
                    else {}
                }
            }
        }
        // If you roll higher endurance
        else if (npcEndRoll <= selfEndRoll) {
            System.out.printf("%s rolled a %s and you rolled a %s for Endurance. So you go first.\n",npcName, npcEndRoll, selfEndRoll);
            userIn = "null";
            while (userIn.length() > 0) {
                System.out.println("Press enter to continue");
                userIn = scnr.nextLine();
            }
            userIn = "null";
            while (!winFight) {
                System.out.printf("Do you want to:\n" +
                        "A: Attack\n" +
                        "B: Talk yourself out\n");
                userIn = scnr.next();
                // Attack
                if (userIn.equalsIgnoreCase("A")) {
                    HP = HP - selfAttack;
                    if (HP < 1) {
                        System.out.printf("You attack %s for %s HP. He dies and drops %s.\n",npcName, selfAttack, shardName);
                        shard.setInInventory(true);
                        me.setLevelUp(true);
                        winFight = true;
                        break;
                    }
                    else {
                        System.out.printf("You attack %s for %s HP. You have %s HP remaining and %s has %s HP remaining\n",npcName, selfAttack, selfHP, npcName, HP);
                    }
                }
                // Charisma Check
                if (userIn.equalsIgnoreCase("B")) {
                    System.out.println("You attempt to talk yourself out of the fight");
                    if (me.getCharisma() >= npc.getCharisma()) {
                        System.out.printf("You successfully talked yourself out of the fight and %s was added to your inventory.\"", shardName);
                        shard.setInInventory(true);
                        me.setLevelUp(true);
                        winFight = true;
                        break;
                    }
                    else {
                        System.out.println("You were unable to talk yourself out of the fight");
                    }
                }
                // If you don't input correctly
                else {
                    /*selfHP = selfHP - attack;
                    System.out.printf("%s attacks you for %s HP. You have %s HP remaining.\n",npcName, attack, selfHP);
                    if (selfHP <= 0) {
                        System.out.printf("You have 0 HP remaining and have died. You lost the game!");
                        System.exit(0);
                    }
                    else {}*/
                }
                // attacks after you attack every time
                selfHP = selfHP - attack;
                System.out.printf("%s attacks you for %s HP. You have %s HP remaining.\n",npcName, attack, selfHP);
                if (selfHP <= 0) {
                    System.out.printf("You have 0 HP remaining and have died. You lost the game!");
                    System.exit(0);
                }
                else {}
            }
        }
    }

    public static int randomNum(int num) {
        int max = num;
        int min = 1;
        Random rn = new Random();
        int number = rn.nextInt(max - min + 1) + min;

        return number;

    }

    public static void courtyardDialogueA(Self me, NPC npc, Shards shard1) {
        Scanner scnr = new Scanner(System.in);
        String userIn = "-1";
        System.out.println("My name is Oliver, and I was cursed with this dreaded appearance many moons ago.\n" +
                "I am a friendly upright hog-man, I am eager to see a friendly face around this terrifying place.");
        while (userIn.length() > 0) {
            System.out.println("[Press enter]");
            userIn = scnr.nextLine();
        }
        userIn = "null";
        System.out.println("I suppose you've come here looking to defeat the Keeper of the Ledger to gain immortality,\n" +
                "not to chat with little old Oliver...\n" +
                "\n" +
                "Well in that case you'll need this.\n");
        System.out.println("[He holds up a broken metallic object]" +
                "\n");
        System.out.println("This is the first shard to the Immortality Dagger, the weapon you need to defeat\n" +
                "the Keeper.");
        while (userIn.length() > 0) {
            System.out.println("[Press enter]");
            userIn = scnr.nextLine();
        }
        userIn = "null";
        if (me.getCharisma() >= npc.getCharisma()) {
            shard1.setInInventory(true);
            me.setLevelUp(true);
            System.out.println("[Oliver has given you Shard 1: Irony]");
            while (userIn.length() > 0) {
                System.out.println("[Press enter]");
                userIn = scnr.nextLine();
            }
            userIn = "null";

        }
        else {
            System.out.println("Charisma check unsuccessful.");
        }



    }

    public static void courtyardDialogueB() {
        Scanner scnr = new Scanner(System.in);
        String userIn = "null";
        System.out.println("\"You are in the labyrinth that belongs to the Keeper of the Ledger. The Keeper is the ruler\n" +
                "of all life on Earth, and this is his domain. The Keeper is the passage between life and the afterlife.\n" +
                "He ensures that your body returns to the Earth when you die. However, if one wishes to obtain\n" +
                "immortality, they may attempt to collect all six shards of the Immortality Dagger, and slay him in\n" +
                "battle. Which, I assume you are here to do, traveler.\"");
        while (userIn.length() > 0) {
            System.out.println("[Press enter]");
            userIn = scnr.nextLine();
        }
        userIn = "null";

    }

    public static void cave(Self me, Mortas mortas, Shards shard) {
        Scanner scnr = new Scanner(System.in);
        String userIn = "null";

        boolean dialogue = true;
        // if shard is in inventory, if mortas is dead
        if (shard.isInInventory() == true) {
            System.out.printf("You have already completed this room\n");

        } else {
            while (userIn.length() > 0) {
                System.out.println("[You arrive at the a large stone wall, and off to the right is a small cave entrance]\n" +
                        "[Press enter]");
                userIn = scnr.nextLine();
            }
            userIn = "null";
            System.out.println("[A loud booming voice echoes from the darkness in front of you]\n" +
                    "Who approaches my cave? Who dares intrude upon the great Mortas the Sanguine?\n");
            System.out.println("A tall, slender muscular creature appears from the darkness. His skin is paler than\n" +
                    "any man you've ever seen, and his jet black hair and dark eyes pierce your soul and send chills\n" +
                    "down your spine.\n");
            while (userIn.length() > 0) {
                System.out.println("[Press enter]");
                userIn = scnr.nextLine();
            }
            userIn = "null";

            loop: while (dialogue) {

                System.out.println("A. \"Hello, I do not wish you harm, I am simply searching to defeat the Keeper of the\n" +
                        "Ledger. I believe you have something I desire.\"");
                System.out.println("B. \"Who are you? Why are you here?\"");
                System.out.println("C. \"I don't have time for petty conversation. I'd rather just kill you.\"");
                //System.out.println(userIn);

                userIn = scnr.nextLine();
                //System.out.println(userIn);

                switch (userIn) {

                    case ("A"):
                        //System.out.println("Dialogue continues");
                        caveDialogueA(me, mortas, shard);
                        if (shard.isInInventory() == true) {
                            break loop;
                        }
                        else { break; }
                    case ("B"):
                        //System.out.println("Dialogue continues");
                        caveDialogueB();
                        break;

                    case ("C"):
                        System.out.println("\" think you can defeat me? Let's duel shall we?\n\"");
                        Fight(me, mortas, shard);
                        if (shard.isInInventory() == true) {
                            winFight = false;
                            break loop;
                        }
                    case "QUIT":
                        quit();
                        break;

                    case "HELP":
                        displayControls();
                        break;

                    case "STATS":
                        displayStats(me);
                        break;

                    case "INVENTORY":
                        System.out.println("This has not been implemented yet");
                        break;

                    default:
                        System.out.println("Invalid input. Enter A B or C.");

                }
            }
        }
    }

    private static void caveDialogueB() {
        System.out.println("\"I am Mortas the Sanguine Vampire, I have lived in this labyrinth for thousands of years\n" +
                "It has been so long since I've seen a human, it will be nice to taste your blood instead of these rodents\"\n");
    }

    private static void caveDialogueA(Self me, NPC npc, Shards shard) {
        //System.out.println("Dialogue A is a charisma check.");
        if (me.getCharisma() >= npc.getCharisma()) {
            shard.setInInventory(true);
            me.setLevelUp(true);
            System.out.println("\"Hm. I pity you, human. Besides, it's been far too long since something interesting\n" +
                    "happened. Here, you may have my piece.\"");
            System.out.printf("[Mortas has given you %s]", shard);

        }
        else {
            System.out.println("\"Hilarious that you think you're escaping here alive, mortal.\"");
        }
    }

    public static void wardrobe(Self me, enemy dominique, Shards shard) {
        Scanner scnr = new Scanner(System.in);
        String userIn = "-1";

        boolean dialogue = true;
        // if shard is in inventory, if mortas is dead
        if (shard.isInInventory() == true)  {
            System.out.printf("You have already completed this room\n");

        } else {
            while (userIn.length() > 0) {
                System.out.println("[You arrive at an empty room with nothing in it other than a velvet wardrobe. \n" +
                        "Something about it draws you in as you open the door.]\n" +
                        "[As you open the door the most beautiful woman you have ever seen stands before you, your eyes \n" +
                                "stare wide at this woman as she laughs to herself]\n" +
                        "Press enter.");
                userIn = scnr.nextLine();
            }

            userIn = "-1";

            System.out.println("\"You know it's not polite to stare, right darling?\"\n");

            loop: while (dialogue) {

                System.out.println("A. \"I am here because you have something I need. I must defeat the Keeper.\"");
                System.out.println("B. \"Wha- who are you?\"");
                System.out.println("C. \"I have no time to flirt with you, you must be eliminated.\"");
                //System.out.println(userIn);

                userIn = scnr.nextLine();
                //System.out.println(userIn);

                switch (userIn) {

                    case ("A"):
                        System.out.println("\"Well aren't you just the bravest adventurer out there. Standing up to me.\"\n");
                        wardrobeDialogueA(me, dominique, shard);
                        if (shard.isInInventory() == true) {
                            break loop;
                        }
                        else { break; }

                    case ("B"):
                        //System.out.println("Dialogue continues");
                        wardrobeDialogueB();
                        break;

                    case ("C"):
                        System.out.println("\"Finally, somebody challenge my TRUE abilities!\"\n");
                        Fight(me, dominique, shard);
                        if (shard.isInInventory() == true) {
                            winFight = false;
                            break loop;
                        }
                    case "QUIT":
                        quit();
                        break;

                    case "HELP":
                        dialogueControls();
                        break;

                    case "STATS":
                        displayStats(me);
                        break;

                    case "INVENTORY":
                        System.out.println("This has not been implemented yet");
                        break;

                    default:
                        System.out.println("Invalid input. Enter A B or C.");

                }
            }
        }
    }

    public static void wardrobeDialogueA(Self me, NPC npc, Shards shard) {
        String npcName = npc.getName();
        String s = shard.getName();
        Scanner scnr = new Scanner(System.in);
        String userIn = "null";

        if (me.getCharisma() >= npc.getCharisma()) {
            shard.setInInventory(true);
            me.setLevelUp(true);
            System.out.printf("\"Something about you makes me think you just might be able to do it. Here, you may \n" +
                    "have my shard\"\n");
            while (userIn.length() > 0) {
                System.out.println("[Press enter]");
                userIn = scnr.nextLine();
            }
            userIn = "null";
            System.out.printf("[%s has given you %s.]\n", npcName, s);

        }
        else {
            System.out.println("\"You are just the cutest, unfortunately for you I'm not THAT easy.\"\n");
        }
    }

    private static void wardrobeDialogueB() {
        Scanner scnr = new Scanner(System.in);
        String userIn = "null";
        System.out.println("[She grins with a seductive smile]\n" +
                "\"My name is Dominique, this is my wardrobe. Here you will find the vices of desire and lust. \n" +
                "Many travelers have come through here just to be enthralled by my beauty, and have fallen under my \n" +
                "spell. Would you like to be my next victim, traveler?\"\n");
        while (userIn.length() > 0) {
            System.out.println("[Press enter]");
            userIn = scnr.nextLine();
        }
        userIn = "null";
    }

    public static void forest(Self me, friendly cinder, Shards shard) {
        Scanner scnr = new Scanner(System.in);
        String userIn = "-1";

        boolean dialogue = true;
        // if shard is in inventory, if mortas is dead
        if (shard.isInInventory() == true) {
            System.out.printf("You have already completed this room\n");

        }
        else {
            while (userIn.length() > 0) {
                System.out.println("You arrive at the Burning Forest\n" +
                        "Press enter.");
                userIn = scnr.nextLine();
            }

            userIn = "-1";

            loop: while (dialogue) {

                System.out.println("A. \"Get shard\"");
                System.out.println("B. \"Dialogue\"");
                System.out.println("C. \"Fight\"");
                //System.out.println(userIn);

                userIn = scnr.nextLine();
                //System.out.println(userIn);

                switch (userIn) {

                    case ("A"):
                        System.out.println("Dialogue continues");
                        forestDialogueA(me, cinder, shard);
                        if (shard.isInInventory() == true) {
                            break loop;
                        }
                        else { break; }

                    case ("B"):
                        System.out.println("Dialogue continues");
                        forestDialogueB();
                        break loop;

                    case ("C"):
                        System.out.println("Fight");
                        Fight(me, cinder, shard);
                        if (shard.isInInventory() == true) {
                            winFight = false;
                            break loop;
                        }
                    case "QUIT":
                        System.out.println("This has not been implemented yet");
                        break;

                    case "HELP":
                        System.out.println("This has not been implemented yet");
                        break;

                    case "STATS":
                        System.out.println("This has not been implemented yet");
                        break;

                    case "INVENTORY":
                        System.out.println("This has not been implemented yet");
                        break;

                    default:
                        System.out.println("Invalid input. Enter A B or C.");

                }
            }
        }
    }

    public static void forestDialogueA(Self me, NPC npc, Shards shard) {
        String npcName = npc.getName();
        String s = shard.getName();

        System.out.println("Dialogue A is a charisma check.");
        if (me.getCharisma() >= npc.getCharisma()) {
            shard.setInInventory(true);
            me.setLevelUp(true);
            System.out.printf("You persuaded %s to give you %s",npcName,s);

        }
        else {
            System.out.println("Charisma check unsuccessful.");
        }
    }
    private static void forestDialogueB() {
        System.out.println("This is dialogue to find out more about the character.");
    }

    public static void meadow(Self me, friendly blossom, Shards shard) {
        Scanner scnr = new Scanner(System.in);
        String userIn = "-1";

        boolean dialogue = true;
        // if shard is in inventory, if mortas is dead
        if (shard.isInInventory() == true) {
            System.out.printf("You have already completed this room\n");

        } else {
            while (userIn.length() > 0) {
                System.out.println("You arrive at the Meadow\n" +
                        "Press enter.");
                userIn = scnr.nextLine();
            }

            userIn = "-1";

            loop: while (dialogue) {

                System.out.println("A. \"Get shard\"");
                System.out.println("B. \"Dialogue\"");
                System.out.println("C. \"Fight\"");
                //System.out.println(userIn);

                userIn = scnr.nextLine();
                //System.out.println(userIn);

                switch (userIn) {

                    case ("A"):
                        System.out.println("Dialogue continues");
                        meadowDialogueA(me, blossom, shard);
                        if (shard.isInInventory() == true) {
                            break loop;
                        }
                        else { break; }

                    case ("B"):
                        System.out.println("Dialogue continues");
                        meadowDialogueB();
                        break loop;

                    case ("C"):
                        System.out.println("Fight");
                        Fight(me, blossom, shard);
                        if (shard.isInInventory() == true) {
                            winFight = false;
                            break loop;
                        }

                    case "QUIT":
                        System.out.println("This has not been implemented yet");
                        break;

                    case "HELP":
                        System.out.println("This has not been implemented yet");
                        break;

                    case "STATS":
                        System.out.println("This has not been implemented yet");
                        break;

                    case "INVENTORY":
                        System.out.println("This has not been implemented yet");
                        break;

                    default:
                        System.out.println("Invalid input. Enter A B or C.");

                }
            }
        }
    }
    public static void meadowDialogueA(Self me, NPC npc, Shards shard) {
        String npcName = npc.getName();
        String s = shard.getName();

        System.out.println("Dialogue A is a charisma check.");
        if (me.getCharisma() >= npc.getCharisma()) {
            shard.setInInventory(true);
            me.setLevelUp(true);
            System.out.printf("You persuaded %s to give you %s",npcName,s);

        }
        else {
            System.out.println("Charisma check unsuccessful.");
        }
    }

    private static void meadowDialogueB() {
        System.out.println("This is dialogue to find out more about the character.");
    }

    public static void pit(Self me, enemy dray, Shards shard) {
        Scanner scnr = new Scanner(System.in);
        String userIn = "-1";

        boolean dialogue = true;
        // if shard is in inventory, if dray is dead
        if (shard.isInInventory() == true) {
            System.out.printf("You have already completed this room\n");

        } else {
            while (userIn.length() > 0) {
                System.out.println("You arrive at the Bottomless Pit\n" +
                        "Press enter.");
                userIn = scnr.nextLine();
            }

            userIn = "-1";

            loop: while (dialogue) {

                System.out.println("A. \"Get shard\"");
                System.out.println("B. \"Dialogue\"");
                System.out.println("C. \"Fight\"");
                //System.out.println(userIn);

                userIn = scnr.nextLine();
                //System.out.println(userIn);

                switch (userIn) {

                    case ("A"):
                        System.out.println("Dialogue continues");
                        pitDialogueA(me, dray, shard);
                        if (shard.isInInventory() == true) {
                            break loop;
                        }
                        else { break; }

                    case ("B"):
                        System.out.println("Dialogue continues");
                        pitDialogueB();
                        break;

                    case ("C"):
                        System.out.println("Fight");
                        Fight(me, dray, shard);
                        if (shard.isInInventory() == true) {
                            winFight = false;
                            break loop;
                        }
                    case "QUIT":
                        System.out.println("This has not been implemented yet");
                        break;

                    case "HELP":
                        System.out.println("This has not been implemented yet");
                        break;

                    case "STATS":
                        System.out.println("This has not been implemented yet");
                        break;

                    case "INVENTORY":
                        System.out.println("This has not been implemented yet");
                        break;

                    default:
                        System.out.println("Invalid input. Enter A B or C.");

                }
            }
        }
    }
    public static void pitDialogueA(Self me, NPC npc, Shards shard) {
        String npcName = npc.getName();
        String s = shard.getName();

        System.out.println("Dialogue A is a charisma check.");
        if (me.getCharisma() >= npc.getCharisma()) {
            shard.setInInventory(true);
            me.setLevelUp(true);
            System.out.printf("You persuaded %s to give you %s",npcName,s);

        }
        else {
            System.out.println("Charisma check unsuccessful.");
        }
    }

    private static void pitDialogueB() {
        System.out.println("This is dialogue to find out more about the character.");
    }
    public static void initializeSelf(Self self) {
        self.setStrength(3);
        self.setCharisma(3);
        self.setEndurance(3);

    }

    public static void initializeOliver(Oliver oliver) {
        oliver.setCharisma(3);
        oliver.setEndurance(1);
        oliver.setStrength(1);
        oliver.setCharismaXP(400);
        oliver.setKillXP(200);
    }
}