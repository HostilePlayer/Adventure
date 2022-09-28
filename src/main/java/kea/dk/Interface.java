package kea.dk;

import java.util.Scanner;

public class Interface {

    Scanner sc = new Scanner(System.in);
    Adventure adventure = new Adventure();
    Player player = new Player();
    Map map = new Map();


    public void startUp() {
        System.out.println("Welcome to a magical wonderland of adventure!");
        adventure.startAdventure();
        introduction();

        boolean menuLoopEndValue = true;
        String gameStartInput;
        do {
            gameStartInput = sc.nextLine();
            switch (gameStartInput.trim().toLowerCase()) {
                case "start game":
                case "(s)tart":
                case "start":
                case "s":
                    introduction();
                    userInput();
                    menuLoopEndValue = false;
                    break;
                case "(h)elp":
                case "help":
                case "h":
                    help();
                    break;
                case "(q)uit":
                case "quit":
                case "q":
                    menuLoopEndValue = false;
                    break;
                default: //den høre det her hver gang, selv om man iver et rigtigt input
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
                "type (q)uit to exit program");
    }

    public void userInput() {
        boolean gameRunning = true;
        System.out.println("You are now in a " + adventure.getStartRoom().getName() + "\n" + adventure.getStartRoom().getDescription());
        while (gameRunning) {
            String direction = sc.nextLine();
            switch (direction) {

                case "Go north", "Walk North", "North", "n":

                    if (adventure.goNorth()) {
                        System.out.println("Going north \n" + adventure.getStartRoom().getName() + "\n" + adventure.getStartRoom().getDescription());

                    } else {
                        System.out.println("You can not go that way");
                    }
                    break;


                case "Go east", "Walk east", "east", "e":
                    if (adventure.goEast()) {
                        System.out.println("Going east \n" + adventure.getCurrentRoom().getName() + "\n" + adventure.getCurrentRoom().getDescription());

                    } else {
                        System.out.println("You can not go that way");
                    }
                    break;


                case "Go south", "Walk south", "South", "s":

                    if (adventure.goSouth()) {
                        System.out.println("Going south \n" + adventure.getCurrentRoom().getName() + "\n" + adventure.getCurrentRoom().getDescription());

                    } else {
                        System.out.println("You can not go that way");
                    }
                    break;


                case " Go west", "Walk west", "west", "w":

                    if (adventure.goWest()) {
                        System.out.println("Going west \n" + adventure.getCurrentRoom().getName() + "\n" + adventure.getCurrentRoom().getDescription());

                    } else {
                        System.out.println("You can not go that way");
                    }
                    break;

                case "exit", "ex":
                    System.out.println("Exiting progam...");
                    gameRunning = false;
                    break;

                case "help", "h":
                    help();
                    break;

                case "look", "l":
                    System.out.println(adventure.getCurrentRoom().getDescription());
                    break;
                case "(q)uit":
                case "quit":
                case "q":
                    System.out.println("Hope you enjoyed our game");
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Could not find that command");
                    break;

            }
            if (adventure.getCurrentRoom() == adventure.getWinningRoom()) {
                gameRunning = false;
                System.out.println("Congratz! you did a thing");
            }
        }
        while (gameRunning) ;
    }
}
