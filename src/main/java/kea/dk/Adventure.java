package kea.dk;

import java.util.ArrayList;

public class Adventure {
    Map creator = new Map();
    Player player = new Player();

    public void searchAndAddItem(String wantedItem) { //vi modtager searchTerm
        //den skal gå igennem alle items i rummet
        for (Item itemToAdd : getCurrentRoom().getAllItems()) { //kan ikke køre currentRoom = null
            //for hvert item skal den tage dens navn i lowercase og sammenligne med searchTerm
            if (itemToAdd.getItemName().contains(wantedItem)) {
                //add item til inventory
                player.getInventory().add(itemToAdd);
                //fjern item fra room
                getCurrentRoom().removeItem(itemToAdd);
            }
        }
    }

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

    public void startAdventure() {
        creator.createPaths();
        player.setCurrentRoom(getStartRoom());
    }
}
