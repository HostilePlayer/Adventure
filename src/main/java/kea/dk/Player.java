package kea.dk;

import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public boolean addToInventory(Item item) {
        boolean succes = inventory.add(item);
        return succes;
    }

    public void setCurrentRoom(Room currentRoom) {

        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public ArrayList<Item> getItem(String searchTerm) {
        //laver en liste over items i currentRoom
        ArrayList<Item> searchResult = getCurrentRoom().getAllItems();
        //for hvert item
        for (Item item : searchResult) {
            //check om item name passer med det bruger søger
            if (item.getItemName().contains(searchTerm.toLowerCase())) {
                //add item til inventory
                inventory.add(item);
            }
        }
        //returner en list over items i currentRoom
        return searchResult;
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
