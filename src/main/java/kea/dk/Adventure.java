package kea.dk;

import java.util.ArrayList;

public class Adventure {
    Map creator = new Map();
    Player player = new Player();

    public Room getWinningRoom() {
        return creator.getEndRoom();
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public boolean goNorth() {
        return player.goNorth();
    }

    public boolean goEast() {
        return player.goEast();
    }

    public boolean goSouth() {
        return player.goSouth();
    }

    public boolean goWest() {
        return player.goWest();
    }

    public Room getStartRoom() {
        return creator.getCurrentRoom();
    }

    public ArrayList<Item> searchAndAddItem(String searchTerm) { //vi modtager searchTerm
        //den skal gå igennem alle items i rummet
        for (Item itemToAdd : getCurrentRoom().getAllItems()) { //vi ser den gå igennem alle ellementer
            //for hvert item skal den tage dens navn i lowercase og sammenligne med searchTerm
            if (itemToAdd.getItemName().toLowerCase().contains(searchTerm)) { //vi ser den tjekke om nogle matcher
                //laver en ny plads i inventory og adder nyt item
                player.getInventory().add(new Item(itemToAdd.getItemName())); //vi ser den kalde på elementet der matcher
                //TODO: add metode til at fjerne items
            }
        }
        return player.getInventory();
    }

    public void startAdventure() {
        creator.createPaths();
        player.setCurrentRoom(getStartRoom());
    }
}
