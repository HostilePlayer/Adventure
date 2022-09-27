package kea.dk;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room west;
    private Room east;

    public void setRoom(Room north, Room east, Room south, Room west) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }

    public Room currentRoom(Room Room){
        return Room;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //her skal vi lave vores room
}
