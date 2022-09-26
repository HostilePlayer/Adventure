package kea.dk;

public class Room {
    private String name;
    private String description;

    public Room(String name) {
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
