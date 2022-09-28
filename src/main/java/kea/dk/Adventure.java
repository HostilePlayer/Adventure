package kea.dk;

public class Adventure {
        Map creator = new Map();
        Player player = new Player();

    public Room getWinningRoom() {
        return creator.getEndRoom();
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public void startUp() {
        creator.startUp();
    }
}
