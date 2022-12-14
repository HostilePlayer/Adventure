package kea.dk;

public class Map {
    private Room currentRoom;
    private Room endRoom;

    //make alle rum
    Room room1 = new Room("Forest clearing", "you are in a grand forest, not much to see", 0, false);
    Room room2 = new Room("Northern part of the forest", "You see a lot of forest", 0, false);
    Room room3 = new Room("North eastern forest part", "What is that? a tree? in a forest", 0, false);
    Room room4 = new Room("Western forest", "In the forest you wonder, how many trees make a forest", 0, false);
    Room Wroom = new Room("Dark spot to the west", "You see a path starting from nowhere", 1, false);
    Room room5 = new Room("Winner Room", "you found the way out! good job", 0, false);
    Room room6 = new Room("Eastern forest part", "You see a old man that is, smelling of bear and his lower body in a tree", 0, true);
    Room Eroom = new Room("dark spot to the east", "something is written on a tree: xyzzy", 1, false);
    Room room7 = new Room("South western forest clearing", "Above the forest you see the sky", 0, false);
    Room room8 = new Room("Southern forest part", "You notice the trees all look like trees", 0, false);
    Room room9 = new Room("South eastern", "You have come to the other side of the forest and found more forest", 0, false);


    public void createPaths() {
        //make paths i rum
        //Room north, Room east, Room south, Room west, Room teleport
        room1.setRoom(null, room2, room4, null, null);
        room2.setRoom(null, room3, null, room1, null);
        room3.setRoom(null, null, room6, room2, null);
        room4.setRoom(room1, null, room7, Wroom, null);
        Wroom.setRoom(null, room4, null, null, Eroom);
        room5.setRoom(null, room8, null, null, null);
        room6.setRoom(room3, Eroom, room9, null, null);
        Eroom.setRoom(null, null, null, room6, Wroom);
        room7.setRoom(room4, room8, null, null, null);
        room8.setRoom(room5, room9, null, room7, null);
        room9.setRoom(room6, null, null, room8, null);

        //items get made here
        room1.createItem("gold coin");
        room1.createItem("massive bong");

        room3.createItem("lamp");
        //til mode til at lcok en d??r op
        room7.createItem("key");
        //food itemName, add health
        room4.createFoodItem("pringles", 5);
        room4.createFoodItem("flesh", -5);
        //drinks itemName, add health
        room6.createDrinkItem("cola", 20);
        room6.createDrinkItem("vodka", -20);
        //weapon items, name, damage
        room1.createRangedWeapon("gun", 50, 1);
        room2.createMeleeWeapon("machete", 10);
        //add shield
        room2.createShield("shield");
        //create enemy: name, health, damage
        room8.createEnemy("peter" , 9999, 100);
        room9.createEnemy("zombie" , 50, 20);
        //loot from kill


        endRoom = room5;
        currentRoom = room1;
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getEndRoom() {
        return endRoom;
    }

    public Room getWroom() {
        return Wroom;
    }

    public Room getEroom() {
        return Eroom;
    }
}
