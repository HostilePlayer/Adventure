package kea.dk;

public class Main {
    public static void main(String[] args) {
        //first commit
        Player player = new Player();
        Map map = new Map();
        player.setCurrentRoom(map.room1);
        Interface ui = new Interface();
        ui.startUp();
    }
}