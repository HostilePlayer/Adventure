package kea.dk;

import java.util.Scanner;

public class Interface {

    Scanner sc = new Scanner(System.in);
    Adventure adventure = new Adventure();
    Player player = new Player();
    boolean haveLamp = false;

    public void startUp() {
        System.out.println("Welcome to a magical wonderland of adventure!");
        adventure.startAdventure();
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
                "type (ex)it to exit program");
    }

    public void userInput() {
        boolean gameRunning = true;
        player.setPlayerHealth(5);
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
                    } else {
                        System.out.println("You can not go that way");
                    }
                    break;


                case "(e)ast", "east", "e":
                    if (adventure.goEast()) {
                        System.out.println("Going east \n" + adventure.getCurrentRoom().getName());

                    } else {
                        System.out.println("You can not go that way");
                    }
                    break;

                case "(s)outh", "south", "s":
                    if (adventure.goSouth()) {
                        System.out.println("Going south \n" + adventure.getCurrentRoom().getName());

                    } else {
                        System.out.println("You can not go that way");
                    }
                    break;

                case "(w)est", "west", "w":
                    if (adventure.goWest()) {
                        System.out.println("Going west \n" + adventure.getCurrentRoom().getName());

                    } else {
                        System.out.println("You can not go that way");
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
                        System.out.println("No itemPickUp like that in this room");
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
                    }
                    break;

                case "health", "hp", "lives":
                    System.out.println("You have " + player.getPlayerHealth() + " health points");
                    break;

                case "eat":
                    String foodToEat = command;
                    //alt der her skal tages til en food class some arver fra item class
                    //den fangede jeg ikke da jeg lavede dette

                    Item eatFromInventory = player.removeItem(command);
                    Item eatFromRoom = adventure.removeItem(command);
                    if (adventure.isItemFood(command)) {
                        if (eatFromInventory != null) {

                            if (adventure.isItemGood(command)) {
                                player.setPlayerHealth(5);
                                System.out.println("Nice filling meal");
                            } else {
                                System.out.println("Are you sure about that? It's raw and might be from a human");
                                String anotherInput = sc.nextLine();
                                if (anotherInput == "Yes" || anotherInput == "yes" || anotherInput == "Y" || anotherInput == "y"
                                        || anotherInput == "Ja" || anotherInput == "ja" || anotherInput == "J"
                                        || anotherInput == "j") {
                                    player.setPlayerHealth(-5);
                                    System.out.println("Yuk, I'm gonna barf");
                                } else {
                                    System.out.println("That's properly for the best");
                                }
                            }
                        } else if (eatFromRoom != null) {
                            if (adventure.isItemGood(command)) {
                                player.setPlayerHealth(5);
                                System.out.println("Nice filling meal");
                            } else {
                                System.out.println("Are you sure about that? It's raw and might be from a human");
                                String anotherInput = sc.nextLine();
                                if (anotherInput == "Yes" || anotherInput == "yes" || anotherInput == "Y" || anotherInput == "y"
                                        || anotherInput == "Ja" || anotherInput == "ja" || anotherInput == "J"
                                        || anotherInput == "j") {
                                    player.setPlayerHealth(-5);
                                    System.out.println("Yuk, I'm gonna barf");
                                } else {
                                    System.out.println("That's properly for the best");
                                }
                            }
                        } else {
                            System.out.println("Was not able to eat" + foodToEat);
                        }
                    }
                    break;

                case "unlock":
                    System.out.println("dende mulighed er WIP");
                    break;

                default:
                    System.out.println("Could not find that command");
                    break;

            }
            if (adventure.getCurrentRoom() == adventure.getWinningRoom()) {
                gameRunning = false;
                System.out.println("Congratz! you did a thing");
            }
            if (player.getPlayerHealth() == 0) {
                gameRunning = false;
                System.out.println("GAME OVER");
                System.out.println("You died in the maze");
            }
        }
        while (gameRunning) ;
    }
}
