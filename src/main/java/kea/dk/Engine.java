package kea.dk;

public class Engine {
    public void controller() {
        Interface ui = new Interface();
        Adventure adventure = new Adventure();
        Map creator = new Map();
        adventure.startUp();
        creator.startUp();
        ui.startUp();
    }
}
