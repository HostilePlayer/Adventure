package kea.dk;

import java.util.Scanner;

public class Interface {

    Scanner sc = new Scanner(System.in);
    Adventure adventure = new Adventure();
    Player player = new Player();
    boolean haveLamp = false;

    public void startUp() {
        System.out.println("\u001B[0m\u001B[1;32m" +
                "01100010 01100101 01110011 01110100 00100000 01000111 01100001 01101101 01100101\n" +
                "01100010 01100101 01110011 01110100 00100000 01000111 01100001 01101101 01100101\n" +
                "\u001B[0m \u001B[1;32m▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\u001B[0m\n" +
                " \u001B[1;32m█\u001B[0m  \u001B[1;32m                                                                          █\u001B[0m\n" +
                " \u001B[1;32m█\u001B[0m  \u001B[1;32m                           Welcome Adventure!\u001B[0m                             \u001B[1;32m█\u001B[0m\n" +
                " \u001B[1;32m█\u001B[0m  \u001B[1;32m \u001B[0m                                                                         \u001B[1;32m█\u001B[0m\n" +
                " \u001B[1;32m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n" +
                "01100010 01100101 01110011 01110100 00100000 01000111 01100001 01101101 01100101\n" +
                "01100010 01100101 01110011 01110100 00100000 01000111 01100001 01101101 01100101\n");

        System.out.println("\033[0m");
        adventure.startAdventure();
        adventure.loadMusic();
        introduction();

        boolean menuLoopEndValue = true;
        String gameStartInput;
        do {
            gameStartInput = sc.nextLine();
            switch (gameStartInput.trim().toLowerCase()) {
                case "start game", "(s)tart", "start", "s":
                    introduction();
                    userInput();
                    menuLoopEndValue = false;
                    break;
                case "(h)elp", "help", "h":
                    help();
                    break;
                case "(q)uit", "quit", "q":
                    menuLoopEndValue = false;
                    break;
                default: //den høre det her hver gang, selv om man hver et rigtigt input
                    System.out.println(gameStartInput + " is not a valid input if you need help type (h)elp to get a list of commands, \n " +
                            "type (s)tart to start or type (q)uit to quit");
                    break;
            }
        } while (menuLoopEndValue);
    }

    public void introduction() {
        System.out.println("In this magical adventure you have to explore a maze of 9 rooms.\n" +
                "Can you find the exit or be lost in the maze forever?\n" +
                "\n" +
                "type (s)tart to start up the game or type (h)elp to get a list of commands");
    }

    public void help() {
        System.out.println("Here is a list of commands:\n" +
                "type (N)orth to go north \n" +
                "type (S)outh to go south \n" +
                "type (E)ast to go east \n" +
                "type (W)est to go west \n" +
                "type (l)ook to look around in your current location \n" +
                "type (E)eat 'food' to eat \n" +
                "type (A)ttack 'enemy' to attack \n" +
                "type (R)un to run away from combat \n" +
                "type (ex)it to exit program \n");
    }

    public void combatState() {
        if (adventure.getCurrentRoom().getEnemies().size() == 1) {
            boolean combatState = true;
            System.out.println("you have entered combat");
            Enemy enemy = adventure.getCurrentRoom().getEnemies().get(0);
            System.out.println("current enemy: " + enemy);

            while (combatState) {
                String combatInput;

                combatInput = sc.nextLine().toLowerCase();
                switch (combatInput) {
                    case "attack", "atk", "a":
                        if (player.getCurrentWeapon() != null) {
                            int dmg = player.getWeaponDMG(player.getCurrentWeapon());
                            int enemydmg = enemy.getEnemyDMG();
                            System.out.println("you did " + dmg + " DMG to " + enemy);
                            enemy.setEnemyHP(dmg);
                            System.out.println(enemy + " have " + enemy.getEnemyHP() + "HP left");
                            if (adventure.getCurrentRoom().isDead(enemy)) {
                                System.out.println("you killed " + enemy);
                                combatState = false;
                            } else {
                                if (player.haveShield()){
                                    System.out.println("You blocked some of the incomming DMG with your shield");
                                    player.setPlayerHealth(enemydmg/2);
                                    System.out.println("You have " + player.getPlayerHealth() + "HP left");
                                } else {
                                    System.out.println(enemy + " hit you for " + enemydmg + " DMG");
                                    player.setPlayerHP(enemydmg);
                                    System.out.println("You have " + player.getPlayerHealth() + "HP left");
                                }

                                if (player.getPlayerHealth() <= 0) {
                                    combatState = false;
                                }
                            }
                        } else if (player.getCurrentWeapon() == null) {
                            System.out.println("You have no weapon equipped");
                        }
                        break;
                    case "run", "r":
                        System.out.println("you have run away from " + enemy);
                        combatState = false;
                        break;
                }
            }
            while (combatState) ;
        }
    }

    public void getDoors(){
        if (adventure.getCurrentRoom().getNorth() != null){
            System.out.println("you see a path leading North");
        }

        if (adventure.getCurrentRoom().getSouth() != null){
            System.out.println("you see a path leading South");
        }

        if (adventure.getCurrentRoom().getEast() != null){
            System.out.println("you see a path leading East");
        }

        if (adventure.getCurrentRoom().getWest() != null){
            System.out.println("you see a path leading West");
        }
    }

    public void userInput() {
        boolean gameRunning = true;
        //player.setPlayerHealth(5); //for tester
        player.setStartingHealth(); // for actual game
        System.out.println("You are now in a " + adventure.getStartRoom().getName() + "\n" + adventure.getStartRoom().getDescription());
        while (gameRunning) {
            String input;

            input = sc.nextLine().toLowerCase();
            String[] inputSplit = input.split(" ");
            String firstWord = inputSplit[0];
            String command = "";


            if (inputSplit.length > 1) {
                command = inputSplit[1];
            }

            switch (firstWord) {
                case "(n)orth", "north", "n":

                    if (adventure.goNorth()) {
                        System.out.println("Going north \n" + adventure.getCurrentRoom().getName());
                        getDoors();
                    } else {
                        System.out.println("You somehow hit a wall in a forest");
                    }
                    break;


                case "(e)ast", "east", "e":
                    if (adventure.goEast()) {
                        System.out.println("Going east \n" + adventure.getCurrentRoom().getName());
                        getDoors();
                    } else {
                        System.out.println("You somehow hit a wall in a forest");
                    }
                    break;

                case "(s)outh", "south", "s":
                    if (adventure.goSouth()) {
                        System.out.println("Going south \n" + adventure.getCurrentRoom().getName());
                        getDoors();
                    } else {
                        System.out.println("You somehow hit a wall in a forest");
                    }
                    break;

                case "(w)est", "west", "w":
                    if (adventure.goWest()) {
                        System.out.println("Going west \n" + adventure.getCurrentRoom().getName());
                        getDoors();
                    } else {
                        System.out.println("You somehow hit a wall in a forest");
                    }
                    break;

                case "help", "h":
                    help();
                    break;

                case "(l)ook", "look", "l":
                    //er currentRoom mørkt
                    if (adventure.getCurrentRoom().getDarkness() == 0) {
                        System.out.println(adventure.getCurrentRoom().getDescription());
                        for (int i = 0; i < adventure.getCurrentRoom().roomItems.size(); i++) {
                            System.out.println(adventure.getCurrentRoom().roomItems.get(i));
                        }
                    } else {
                        //har player en lamp?
                        haveLamp = player.haveLamp();
                        if (haveLamp) {
                            //er lampen tændt?
                            if (player.isLightOn()) {
                                //hvis lampen er tændt
                                System.out.println(adventure.getCurrentRoom().getDescription());
                                for (int i = 0; i < adventure.getCurrentRoom().roomItems.size(); i++) {
                                    System.out.println(adventure.getCurrentRoom().roomItems.get(i));
                                }
                            } else {
                                System.out.println("This unlit lamp is not working!");
                            }
                        }
                        if (!haveLamp) {
                            System.out.println("You need a light to see");
                        }
                    }

                    break;

                case "inventory", "backpack", "pocket", "i":
                    if (player.getInventory().isEmpty()) {
                        System.out.println("You do not have any items");
                    } else {
                        System.out.println("Items in inventory:" + player.getInventory().toString());
                    }
                    break;

                case "take", "t", "add", "a", "pick", "p":
                    //secondWord
                    String itemName = command;
                    Item itemPickUp = adventure.takeItem(itemName);

                    if (itemPickUp == null) {
                        System.out.println("No item like that in this room");
                    } else {
                        System.out.println("You have picked up the " + itemPickUp.getItemName());
                        player.getInventory().add(itemPickUp);
                        adventure.getCurrentRoom().roomItems.remove(itemPickUp);
                    }
                    break;


                case "drop", "d", "leave":
                    String droppedItem = command;
                    Item itemToDrop = player.removeItem(droppedItem);

                    if (itemToDrop == null) {
                        System.out.println("No such item in Inventory");
                    } else {
                        System.out.println("you have dropped " + itemToDrop.getItemName());
                        adventure.getCurrentRoom().addItem(itemToDrop);
                    }
                    break;

                case "light":
                    haveLamp = player.haveLamp();
                    if (haveLamp) {
                        player.toggleLamp(true);
                        System.out.println("Lamp is now on!");
                    } else {
                        System.out.println("You do not have a light");
                    }
                    break;

                case "extinguish":
                    haveLamp = player.haveLamp();
                    if (haveLamp) {
                        player.toggleLamp(false);
                        System.out.println("Lamp is now off!");
                    } else {
                        System.out.println("You do not have a light");
                    }
                    break;
                case "status":
                    haveLamp = player.haveLamp();
                    if (haveLamp) {
                        if (player.isLightOn()) {
                            System.out.println("Lamp is on");
                        } else {
                            System.out.println("Lamp is off");
                        }
                    } else {
                        System.out.println("You do not have a light");
                    }
                    break;

                case "(q)uit", "quit", "q":
                    System.out.println("Hope you enjoyed our game");
                    System.out.println("Exiting program....");
                    gameRunning = false;
                    break;

                case "xyzzy":
                    System.out.println(">>puff<<");
                    adventure.canPlayerTeleport();
                    if (adventure.goTeleport()) {
                        System.out.println(adventure.getCurrentRoom().getName());
                    } else {
                        System.out.println("Nothing changed");
                    }
                    break;

                case "health", "hp", "lives":
                    System.out.println("You have " + player.getPlayerHealth() + " health points");
                    break;

                case "eat":
                    String foodToEat = command;
                    Item eatFromInventory = player.getItemFromInvetory(command);
                    Item eatFromRoom = adventure.getItemFromRoom(command);

                    //tager item fra inventory
                    if (eatFromInventory != null) {
                        if (((Food) eatFromInventory).getFoodHealth() < 0) {
                            System.out.println("are you sure abouth that? yes / no");
                            String eatPosion = sc.nextLine().toLowerCase();
                            if (eatPosion.equals("yes")) {
                                player.eatFromInventory(eatFromInventory);
                                System.out.println("you ate " + foodToEat);
                                System.out.println(((Food) eatFromInventory).getFoodHealth() + " to HP");
                                player.removeItem(foodToEat);
                            } else {
                                System.out.println("That's is most likely for the best");
                            }
                        } else {
                            player.eatFromInventory(eatFromInventory);
                            System.out.println("you ate " + foodToEat);
                            System.out.println(((Food) eatFromInventory).getFoodHealth() + " to HP");
                            player.removeItem(foodToEat);
                        }
                        //tager item fra currentRoom
                    } else if (eatFromRoom != null) {
                        if (eatFromRoom instanceof Food) {
                            if (((Food) eatFromRoom).getFoodHealth() < 0) {
                                System.out.println("are you sure abouth that? yes / no");
                                String eatPosion = sc.nextLine().toLowerCase();
                                if (eatPosion.equals("yes")) {
                                    System.out.println(((Food) eatFromRoom).getFoodHealth() + " to HP");
                                    player.setPlayerHealth(((Food) eatFromRoom).getFoodHealth());
                                    System.out.println("You're eating " + foodToEat);
                                    adventure.removeItem(foodToEat);
                                } else {
                                    System.out.println("That's is most likely for the best");
                                }
                            } else {
                                System.out.println(((Food) eatFromRoom).getFoodHealth() + " to HP");
                                player.setPlayerHealth(((Food) eatFromRoom).getFoodHealth());
                                System.out.println("You're eating " + foodToEat);
                                adventure.removeItem(foodToEat);
                            }

                        }

                    } else {
                        System.out.println(foodToEat + " not eatable");
                    }
                    break;

                case "drink":
                    String itemToDrink = command;
                    Item drinkFromInventory = player.getItemFromInvetory(command);
                    Item drinkFromRoom = adventure.getItemFromRoom(command);

                    //tager item fra inventory
                    if (drinkFromInventory != null) {
                        if (((Drinks) drinkFromInventory).getDrinkHealth() < 0) {
                            System.out.println("are you sure abouth that? yes / no");
                            String drinkpoison = sc.nextLine().toLowerCase();
                            if (drinkpoison.equals("yes")) {
                                player.drinkFromInventory(drinkFromInventory);
                                System.out.println("You drink " + itemToDrink);
                                System.out.println(((Drinks) drinkFromInventory).getDrinkHealth() + " to HP");
                                player.removeItem(itemToDrink);
                            } else {
                                System.out.println("That's is most likely for the best");
                            }

                        } else {
                            player.drinkFromInventory(drinkFromInventory);
                            System.out.println("You drink " + itemToDrink);
                            System.out.println(((Drinks) drinkFromInventory).getDrinkHealth() + " to HP");
                            player.removeItem(itemToDrink);
                        }

                        //tager item fra currentRoom
                    } else if (drinkFromRoom != null) {
                        if (drinkFromRoom instanceof Drinks) {
                            if (((Drinks) drinkFromRoom).getDrinkHealth() < 0) {
                                System.out.println("are you sure abouth that? yes / no");
                                String drinkpoison = sc.nextLine().toLowerCase();
                                if (drinkpoison.equals("yes")) {
                                    System.out.println(((Drinks) drinkFromRoom).getDrinkHealth() + " to HP");
                                    player.setPlayerHealth(((Drinks) drinkFromRoom).getDrinkHealth());
                                    System.out.println("You're drinking " + itemToDrink);
                                    adventure.removeItem(itemToDrink);
                                } else {
                                    System.out.println("That's is most likely for the best");
                                }
                            } else {
                                System.out.println(((Drinks) drinkFromRoom).getDrinkHealth() + " to HP");
                                player.setPlayerHealth(((Drinks) drinkFromRoom).getDrinkHealth());
                                System.out.println("You're drinking " + itemToDrink);
                                adventure.removeItem(itemToDrink);
                            }
                        }
                    } else {
                        System.out.println(itemToDrink + " not eatable");
                    }
            break;

            case "weapon":
                if (player.getCurrentWeapon() == null) {
                    System.out.println("you have nothing equipped");
                } else {
                    System.out.println("you have " + player.getCurrentWeapon() + " equip");
                }
                break;

            case "equip":
                String weaponToEquip = command;
                Item takeFromInventory = player.getItemFromInvetory(command);
                Item takeFromRoom = adventure.getItemFromRoom(command);

                //tager item fra inventory
                if (takeFromInventory != null) {
                    player.equipFromInventory(takeFromInventory);


                    if (player.getCurrentWeapon() == null) {
                        System.out.println("Was not able to equip " + weaponToEquip);
                    } else {
                        System.out.println("You equip " + weaponToEquip);
                        player.removeItem(weaponToEquip);
                    }

                    //tager item fra currentRoom
                } else if (takeFromRoom != null) {
                    if (takeFromRoom instanceof Weapons) { //fejler check
                        player.equipItem(takeFromRoom);
                        adventure.removeItem(weaponToEquip);
                        System.out.println("You equip " + weaponToEquip);
                    } else {
                        System.out.println("Was not able to equip " + weaponToEquip);
                    }

                } else {
                    System.out.println(weaponToEquip + " is not a weapon");
                }
                break;

            case "attack":
                if (player.getCurrentWeapon() != null) {
                    System.out.println("You attacked!... the air...");
                    player.getWeaponDMG(player.getCurrentWeapon());
                    System.out.println("you did " + player.getWeaponDMG(player.getCurrentWeapon()) + " DMG");
                } else if (player.getCurrentWeapon() == null) {
                    System.out.println("You have no weapon equipped");
                }

                break;

            case "unlock":
                System.out.println("this is WIP command");
                break;

            default:
                System.out.println("Could not find that command");
                break;

        }
        if (adventure.getCurrentRoom() == adventure.getWinningRoom()) {
            gameRunning = false;
            System.out.println("Congratz! you did a thing");
        }
        combatState();
        if (player.getPlayerHealth() == 0 || player.getPlayerHealth() < 0) {
            gameRunning = false;
            System.out.println("GAME OVER");
            System.out.println("You died in the maze");
        }
    }
        while(gameRunning);
}
}
