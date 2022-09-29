package kea.dk;

import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    int numberOfItems = 1;
    String[] inventory = new String[numberOfItems];

    public String[] getInventory(){
        return inventory;
    }

    public void addToInventory(String item){
        numberOfItems = numberOfItems + 1;
        inventory[numberOfItems - 1] = item; //index out of bounds?
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
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
