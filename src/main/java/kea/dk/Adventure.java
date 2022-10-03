package kea.dk;

public class Adventure {
    Map creator = new Map();
    Player player = new Player();

    public boolean teleportPLayer(){
        boolean canTeleport;
        if(getCurrentRoom() == getDarkRoom1()){
            player.setCurrentRoom(getDarkRoom2());
            canTeleport = true;
        } else if(getCurrentRoom() == getDarkRoom2()){
            player.setCurrentRoom(getDarkRoom1());
            canTeleport = true;
        } else {
            canTeleport = false;
        }
        return canTeleport;
    }

    public Room getDarkRoom1(){
        return creator.getEroom();
    }

    public Room getDarkRoom2(){
        return creator.getWroom();
    }

    public Room getWinningRoom() {
        return creator.getEndRoom();
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public boolean goNorth() {
        return player.goNorth();
    }

    public boolean goEast() {
        return player.goEast();
    }

    public boolean goSouth() {
        return player.goSouth();
    }

    public boolean goWest() {
        return player.goWest();
    }

    public Room getStartRoom() {
        return creator.getCurrentRoom();
    }

    public void startAdventure() {
        creator.createPaths();
        player.setCurrentRoom(getStartRoom());
    }

    public Item takeItem(String itemName) {
        player.getItem(itemName);
        return player.getItem(itemName);
    }
}
