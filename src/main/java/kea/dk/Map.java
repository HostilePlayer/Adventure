package kea.dk;

import java.util.ArrayList;

public class Map {
    private Room currentRoom;
    private Room endRoom;
    Player player = new Player();

    //laver alle rum
    Room room1 = new Room("1st forest clearing", "you are in a grand forest, not much to see");
    Room room2 = new Room("2nd forest clearing", "You see a lot of forest");
    Room room3 = new Room("3rd forest clearing", "What is that? a tree? in a forest");
    Room room4 = new Room("4th forest clearing", "In the forest you wonder, how many trees make a forest");
    Room room5 = new Room("Winner Room", "you found the way out! good job");
    Room room6 = new Room("6th forest clearing", "More trees and more grass");
    Room room7 = new Room("7th forest clearing", "Above the forest you see the sky");
    Room room8 = new Room("8th forest clearing", "You notice the trees all look like trees");
    Room room9 = new Room("9th forest clearing", "You have come to the other side of the forest and found more forest");

    public ArrayList<Item> searchResult = new ArrayList<>();
/*
    public ArrayList<Item> searchAndAdd(String searchTerm) {

        for (Item addItem : adventure.getCurrentRoom().getAllItems()) {
            //String name = addItem.getCurrentRoom().getItemName();
            //nu skal den finde dem der passer og add dem til searchResult
            if (adventure.getCurrentRoom().getItemName().contains(searchTerm)) {
                //hvis et element matcher skal det addes
                if (!searchResult.contains(player.inventory)) {
                    //add element : men add 2 gange?
                    player.inventory.add(addItem.getItemName());
                }
            }
        }
        return searchResult;
    }
*/
    public void createPaths() {
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

        //items get made here
        room1.createItem("massive bong");
        room1.createItem("machete");
        room1.createItem("gun");

        endRoom = room5;
        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom; //er altid null, selv om linje 34 stiller den til room1
    }

    public Room getEndRoom() {
        return endRoom;
    }

}
