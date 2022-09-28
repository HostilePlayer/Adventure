package kea.dk;

public class Engine {
    public void controller() {
        Interface ui = new Interface();
        Adventure adventure = new Adventure();
        adventure.startUp();
        ui.startUp();
    }
}
