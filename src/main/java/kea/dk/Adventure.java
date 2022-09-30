package kea.dk;

import java.util.ArrayList;

public class Adventure {
    Map creator = new Map();
    Player player = new Player();
    Item item = new Item("");
    Room room = new Room("","");

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
    public boolean deleteRoomItem (Item item){
        boolean succes = room.roomItems.remove(item);
        return succes;
    }
    public ArrayList<Item> getItem(String searchTerm) {
        ArrayList<Item> searchResult = new ArrayList<>();
        for (Item item : getCurrentRoom().roomItems) {
            if (getCurrentRoom().getItemName().contains(searchTerm)) {
                searchResult.add(item);
            }
        }
        return searchResult;
    }
    /*
    public Item getItem(String searhTerm){
        if(getCurrentRoom().roomItems.contains(searhTerm)) {
            return item;
        }else {
            return null;
        }
    }*/

    public void startAdventure() {
        creator.createPaths();
        player.setCurrentRoom(getStartRoom());
    }
}
