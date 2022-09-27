package kea.dk;

public class Adventure {
    private Room currentRoom;


    public void Creator(){
        //this.Room1 = setRoom();
        //laver aller rum
        Room Room1 = new Room("first room", "starting room");
        Room Room2 = new Room("2nd" , "stuff");
        Room Room3 = new Room("3rd" , "stuff");
        Room Room4 = new Room("4th" , "stuff");
        Room Room5 = new Room("Winner Room" , "you found the way out! good job");
        Room Room6 = new Room("6th" , "stuff");
        Room Room7 = new Room("7th" , "stuff");
        Room Room8 = new Room("8th" , "stuff");
        Room Room9 = new Room("9th" , "stuff");

        //laver paths i rum
        //Room north, Room east, Room south, Room west
        Room1.setRoom(null, Room2, Room4, null);
        Room2.setRoom(Room1, null, Room3, null);
        Room3.setRoom(null, null, Room6, Room2);
        Room4.setRoom(Room1, null, Room7, null);
        Room5.setRoom(null, Room8, null, null);
        Room6.setRoom(Room3, null, Room9, null);
        Room7.setRoom(Room4, Room8, null, null);
        Room8.setRoom(Room5, Room9, null, Room7);
        Room9.setRoom(Room6, null, null, Room8);

        currentRoom = Room1;
    }
    public Room getCurrentRoom(){
        return currentRoom;
    }
    public String look(){
        String look = currentRoom.getDescription();
        return look;
    }
    public void getNorth(){
        if(getCurrentRoom() !=null){
            currentRoom=currentRoom.getNorth();
        } else{
            System.out.println("you somehow hit a wall in the forest");
        }
    }
    public void getEast(){
        if(getCurrentRoom() !=null){
            currentRoom=currentRoom.getEast();
        } else{
            System.out.println("you somehow hit a wall in the forest");
        }
    }
    public void getSouth(){
        if(getCurrentRoom() !=null){
            currentRoom=currentRoom.getSouth();
        } else{
            System.out.println("you somehow hit a wall in the forest");
        }
    }
    public void getWest(){
        if(getCurrentRoom() !=null){
            currentRoom=currentRoom.getWest();
        } else{
            System.out.println("you somehow hit a wall in the forest");
        }
    }
    public void startUp() {
        Creator();
        Interface ui = new Interface();
        ui.startUp();
    }
}
