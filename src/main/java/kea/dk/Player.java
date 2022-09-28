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
        String look = creator.getCurrentRoom().getDescription();
        return look;
    }

    public boolean goNorth() {
        nextRoom = creator.getCurrentRoom().getNorth();
        if (nextRoom != null) {
            currentRoom = creator.getCurrentRoom().getNorth();
            return true;
        } else {
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }

    public boolean goEast() {
        nextRoom = creator.getCurrentRoom().getEast();
        if (nextRoom != null) {
            currentRoom = creator.getCurrentRoom().getEast();
            return true;
        } else {
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }

    public boolean goSouth() {
        nextRoom = creator.getCurrentRoom().getSouth();
        if (nextRoom != null) {
            currentRoom = creator.getCurrentRoom().getSouth();
            return true;
        } else {
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }

    public boolean goWest() {
        nextRoom = creator.getCurrentRoom().getWest();
        if (nextRoom != null) {
            currentRoom = creator.getCurrentRoom().getWest();
            return true;
        } else {
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }
}
