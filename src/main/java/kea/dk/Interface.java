package kea.dk;

import java.util.Scanner;

public class Interface {

    Scanner sc = new Scanner(System.in);
    Adventure adventure = new Adventure();

    public void startUp() {
        System.out.println("Welcome to a magical wonderland of adventure!");
        adventure.startUp();
        forklaring();
        brugerValg();
    }

    public void forklaring() {
        System.out.println("In this magical adventure you have to explore a maze of 9 rooms.\n" +
                "Can you find the exit or be lost in the maze forever?");
    }

    public void brugerValg() {
        boolean gameRunning = true;
        String brugerValg;
        do {
            System.out.println("You are currently in " + adventure.getCurrentRoom() +   ". Which direction do you wanna go?");
            brugerValg = sc.nextLine();
            switch (brugerValg.trim().toLowerCase()) {
                case "walk north":
                case "go north":
                case "north":
                case "n":
                    System.out.println("going north");
                    adventure.getNorth();
                    break;
                case "walk south":
                case "go south":
                case "south":
                case "s":
                    System.out.println("going south");
                    adventure.getSouth();
                    break;
                case "walk east":
                case "go east":
                case "east":
                case "e":
                    System.out.println("going east");
                    adventure.getEast();
                    break;
                case "walk west":
                case "go west":
                case "west":
                case "w":
                    System.out.println("going west");
                    adventure.getWest();
                    break;
                case "help":
                case "h":
                    System.out.println("Here is a list of commands:\n" +
                            "type (N)orth/(S)outh/(E)ast/(W)est to go that direction \n" +
                            "type (l)ook to look around in your current location \n" +
                            "type (q)uit to exit program");
                    break;
                case "look":
                case "l":
                    adventure.look();
                    break;
                case "exit":
                case "quit":
                case "q":
                    gameRunning = false;
                    break;
                default:
                    System.out.println("if you need help type (help) to get help");
                    break;
            }
        } while (gameRunning);
    }
}
