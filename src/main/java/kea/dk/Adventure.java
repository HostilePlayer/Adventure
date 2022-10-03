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

    public void startAdventure() {
        creator.createPaths();
        player.setCurrentRoom(getStartRoom());
    }

    public Item takeItem(String itemName) {
        player.getItem(itemName);
        //creator.deleteItem(itemName);
        //return item
        return player.getItem(itemName);
    }
}
