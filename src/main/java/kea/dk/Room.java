package kea.dk;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room west;
    private Room east;

    public Room(){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void setRoom(Room north, Room east, Room south, Room west) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
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

    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    //her skal vi lave vores room
}
