package kea.dk;

public class Adventure {
    private Room currentRoom;


    public void Creator(){
        //this.Room1 = setRoom();
        //laver aller rum
        Room room1 = new Room("first room", "starting room");
        Room room2 = new Room("2nd" , "stuff");
        Room room3 = new Room("3rd" , "stuff");
        Room room4 = new Room("4th" , "stuff");
        Room room5 = new Room("Winner Room" , "you found the way out! good job");
        Room room6 = new Room("6th" , "stuff");
        Room room7 = new Room("7th" , "stuff");
        Room room8 = new Room("8th" , "stuff");
        Room room9 = new Room("9th" , "stuff");

        //laver paths i rum
        //Room north, Room east, Room south, Room west
        room1.setRoom(null, room2, room4, null);
        room2.setRoom(room1, null, room3, null);
        room3.setRoom(null, null, room6, room2);
        room4.setRoom(room1, null, room7, null);
        room5.setRoom(null, room8, null, null);
        room6.setRoom(room3, null, room9, null);
        room7.setRoom(room4, room8, null, null);
        room8.setRoom(room5, room9, null, room7);
        room9.setRoom(room6, null, null, room8);

        currentRoom = room1;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }
    public String look(){
        String look = currentRoom.getDescription();
        return look;
    }
    public boolean getNorth(){
        if(getCurrentRoom() !=null){
            currentRoom=currentRoom.getNorth();
            return true;
        } else{
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }
    public boolean getEast(){
        if(getCurrentRoom() !=null){
            currentRoom = currentRoom.getEast();
            return true;
        } else{
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }
    public boolean getSouth(){
        if(getCurrentRoom() !=null){
            currentRoom=currentRoom.getSouth();
            return true;
        } else{
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }
    public boolean getWest(){
        if(getCurrentRoom() !=null){
            currentRoom=currentRoom.getWest();
            return true;
        } else{
            System.out.println("you somehow hit a wall in the forest");
            return false;
        }
    }
    public void startUp() {
        Creator();
    }
}
