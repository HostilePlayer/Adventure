package kea.dk;

import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom; //den her bliver null når seachAndAddItem skal bruge den
    }

    public Room getCurrentRoom() {
        return currentRoom; // bliver reset til null når seachAndAddItem skal bruge den
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void searchAndAddItem(String wantedItem) { //vi modtager searchTerm
        //den skal gå igennem alle items i rummet
        for (Item itemToAdd : currentRoom.getAllItems()) { //kan ikke køre currentRoom = null
            //for hvert item skal den tage dens navn i lowercase og sammenligne med searchTerm
            if (itemToAdd.toString().contains(wantedItem)) {
                //add item til inventory
                inventory.add(itemToAdd);
                //fjern item fra room
                currentRoom.removeItem(itemToAdd);
                return;

            }
        }
    }

    public boolean goNorth() {
        if (currentRoom.getNorth() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getNorth();
            return true;
        }

    }

    public boolean goSouth() {
        if (currentRoom.getSouth() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getSouth();
            return true;
        }
    }

    public boolean goEast() {
        if (currentRoom.getEast() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getEast();
            return true;
        }
    }

    public boolean goWest() {
        if (currentRoom.getWest() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getWest();
            return true;
        }
    }
}
