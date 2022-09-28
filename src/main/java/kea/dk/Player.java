package kea.dk;

public class Player {
    Map creator = new Map();
    private Room currentRoom;
    private Room nextRoom;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String look() {
        String look = currentRoom.getDescription();
        return look;
    }

    public boolean goNorth() {
        nextRoom = currentRoom.getNorth();
        if (nextRoom != null) {
            currentRoom = currentRoom.getNorth();
            return true;
        } else {
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }

    public boolean goEast() {
        nextRoom = currentRoom.getEast();
        if (nextRoom != null) {
            currentRoom = currentRoom.getEast();
            return true;
        } else {
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }

    public boolean goSouth() {
        nextRoom = currentRoom.getSouth();
        if (nextRoom != null) {
            currentRoom = currentRoom.getSouth();
            return true;
        } else {
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }

    public boolean goWest() {
        nextRoom = currentRoom.getWest();
        if (nextRoom != null) {
            currentRoom = currentRoom.getWest();
            return true;
        } else {
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }
}
