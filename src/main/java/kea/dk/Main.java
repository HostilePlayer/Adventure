package kea.dk;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //first commit

        Interface ui = new Interface();
        ui.startUp();

        Adventure adventure = new Adventure();
        adventure.startUp();
    }
}