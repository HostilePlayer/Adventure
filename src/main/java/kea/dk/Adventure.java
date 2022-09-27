package kea.dk;

public class Adventure {
    private Room currentRoom;
    private Room nextRoom;
    private Room endRoom;


    public void Creator() {
        //this.Room1 = setRoom();
        //laver aller rum
        Room room1 = new Room("first room", "you are in a grand forest, not much to see");
        Room room2 = new Room("2nd", "You see a lot of forest");
        Room room3 = new Room("3rd", "What is that? a tree? in a forest");
        Room room4 = new Room("4th", "In the forest you wonder, how many trees make a forest");
        Room room5 = new Room("Winner Room", "you found the way out! good job");
        Room room6 = new Room("6th", "More trees and more grass");
        Room room7 = new Room("7th", "Above the forest you see the sky");
        Room room8 = new Room("8th", "You notice the trees all look like trees");
        Room room9 = new Room("9th", "You have come to the other site of the forest and found more forest");

        //laver paths i rum
        //Room north, Room east, Room south, Room west
        room1.setRoom(null, room2, room4, null);
        room2.setRoom(null, room3, null, room1);
        room3.setRoom(null, null, room6, room2);
        room4.setRoom(room1, null, room7, null);
        room5.setRoom(null, room8, null, null);
        room6.setRoom(room3, null, room9, null);
        room7.setRoom(room4, room8, null, null);
        room8.setRoom(room5, room9, null, room7);
        room9.setRoom(room6, null, null, room8);

        endRoom = room5;
        nextRoom = null;
        currentRoom = room1;
    }

    public Room getWinningRoom() {
        return endRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String look() {
        String look = currentRoom.getDescription();
        return look;
    }

    public boolean getNorth() {
        nextRoom = currentRoom.getNorth();
        if (nextRoom != null) {
            currentRoom = currentRoom.getNorth();
            return true;
        } else {
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }

    public boolean getEast() {
        nextRoom = currentRoom.getEast();
        if (nextRoom != null) {
            currentRoom = currentRoom.getEast();
            return true;
        } else {
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }

    public boolean getSouth() {
        nextRoom = currentRoom.getSouth();
        if (nextRoom != null || getCurrentRoom().equals(null)) {
            currentRoom = currentRoom.getSouth();
            return true;
        } else {
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }

    public boolean getWest() {
        nextRoom = currentRoom.getWest();
        if (nextRoom != null) {
            currentRoom = currentRoom.getWest();
            return true;
        } else {
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }

    public void startUp() {
        Creator();
    }
}
