package kea.dk;

public class Room {
    private String name;
    private String description;
    private String itemName;
    private Room north;
    private Room south;
    private Room west;
    private Room east;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Room(String itemName){
        this.itemName = itemName;
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
