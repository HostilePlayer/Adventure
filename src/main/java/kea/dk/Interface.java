package kea.dk;

import java.util.Scanner;

public class Interface {

    Scanner sc = new Scanner(System.in);
    Adventure adventure = new Adventure();

    public void startUp() {
        System.out.println("Welcome to a magical wonderland of adventure!");
        adventure.startUp();
        introduction();

        boolean menuLoopEndValue = true;
        String gameStartInput;
        do {
            gameStartInput = sc.nextLine();
        switch (gameStartInput.trim().toLowerCase()){
            case "start game":
            case "(s)tart":
            case "start":
            case "s":
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
            default:
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

    public void help(){
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
        String userInput;
        do {
            System.out.println("You are currently in " + adventure.getCurrentRoom().getName() +   ". Which direction do you wanna go?");

            userInput = sc.nextLine();

            switch (userInput.trim().toLowerCase()) {
                case "walk north":
                case "go north":
                case "north":
                case "n":
                    System.out.println("going north");
                    adventure.goNorth();
                    break;
                case "walk south":
                case "go south":
                case "south":
                case "s":
                    System.out.println("going south");
                    adventure.goSouth();
                    break;
                case "walk east":
                case "go east":
                case "east":
                case "e":
                    System.out.println("going east");
                    adventure.goEast();
                    break;
                case "walk west":
                case "go west":
                case "west":
                case "w":
                    System.out.println("going west");
                    adventure.goWest();
                    break;
                case "help":
                case "h":
                    help();
                    break;
                case "look":
                case "l":
                    System.out.println(adventure.look());
                    break;
                case "exit":
                case "quit":
                case "q":
                    gameRunning = false;
                    break;
                default:
                    System.out.println(userInput + " is not a valid input if you need help type (h)elp to get help");
                    break;

            }
            if (adventure.getCurrentRoom() == adventure.getWinningRoom()) {
                gameRunning = false;
                System.out.println("Congratz! you did a thing");
            }
        } while (gameRunning);
    }
}
