package kea.dk;

public class Adventure {

    private Room Room;

    private Room Room1;
    private Room Room2;
    private Room Room3;
    private Room Room4;
    private Room Room5;
    private Room Room6;
    private Room Room7;
    private Room Room8;
    private Room Room9;


    public void startUp() {

        Room = new Room();
        Creator();
        Interface ui = new Interface();
        ui.startUp();
    }

    public Room Creator(){
        //Room north, Room east, Room south, Room west
        //this.Room1 = setRoom();
        Room1.setName("first room");
        Room1.setDescription("starting room");
        Room1.setRoom(null, Room2, Room4, null);

        Room2.setName("first room");
        Room2.setDescription("starting room");
        Room2.setRoom(Room1, null, Room3, null);

        Room3.setName("first room");
        Room3.setDescription("starting room");
        Room3.setRoom(null, null, Room6, Room2);

        Room4.setName("first room");
        Room4.setDescription("starting room");
        Room4.setRoom(Room1, null, Room7, null);

        Room5.setName("Winner Room");
        Room5.setDescription("you found the way out! good job");
        Room5.setRoom(null, Room8, null, null);

        Room6.setName("another room");
        Room6.setDescription("you did a thing");
        Room6.setRoom(Room3, null, Room9, null);

        Room7.setName("another room");
        Room7.setDescription("you did a thing");
        Room7.setRoom(Room4, Room8, null, null);

        Room8.setName("another room");
        Room8.setDescription("you did a thing");
        Room8.setRoom(Room5, Room9, null, Room7);

        Room9.setName("another room");
        Room9.setDescription("you did a thing");
        Room9.setRoom(Room6, null, null, Room8);
        return Room1;
    }
}
