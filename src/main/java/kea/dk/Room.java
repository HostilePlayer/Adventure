package kea.dk;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room west;
    private Room east;
    private ArrayList<Item> items = new ArrayList();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addItem(Item item) {
        items.add(item);
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public Room getEast() {
        return east;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    public void setRoom(Room north, Room east, Room south, Room west) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }
    //her skal vi lave vores room
}
