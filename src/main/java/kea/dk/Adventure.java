package kea.dk;

import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class Adventure {
    Map creator = new Map();
    Player player = new Player();

    public ArrayList<Item> lootItems = new ArrayList<>();

    public void createLoot(String itemName) {
        Item item = new Item(itemName);
        lootItems.add(item);
    }

    public void dropLoot(){
        for (Item item : lootItems){
            getCurrentRoom().addItem(item);
        }
    }

    public void loadMusic(){
        //for the love of god! husk at lav om så fil placering passer og navnet passer. NOTE: skal være en wav fil
        File backgroundMusic = new File("C:\\Users\\Hostile\\IdeaProjects\\Adventure\\Sound\\GameMusic.wav");
        playMusic(backgroundMusic);
    }

    static void playMusic(File Sound){
        try{
            Clip music = AudioSystem.getClip();
            music.open(AudioSystem.getAudioInputStream(Sound));
            music.loop(999999);

        }catch (Exception e){
            System.out.println("can not find music file \n" +
                    "go to the Adventure class and change the file location on line 15");
        }
    }

    public boolean canPlayerTeleport() {
        boolean canTeleport;
        if (getCurrentRoom() == getDarkRoom1()) {
            canTeleport = true;
        } else if (getCurrentRoom() == getDarkRoom2()) {
            canTeleport = true;
        } else {
            canTeleport = false;
        }
        return canTeleport;
    }


    public Item getItemFromRoom(String itemName){
        for(Item itemFromRoom : getCurrentRoom().getAllItems()){
            if (itemFromRoom.getItemName().contains(itemName)){
                return itemFromRoom;
            }
        }
        return null;
    }

    public Room getDarkRoom1() {
        return creator.getEroom();
    }

    public Room getDarkRoom2() {
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

    public boolean goTeleport() {
        return player.goTeleport();
    }

    public Room getStartRoom() {
        return creator.getCurrentRoom();
    }

    public void startAdventure() {
        creator.createPaths();
        player.setCurrentRoom(getStartRoom());
        createLoot("gold coins");
        createLoot("gold coins");
        createLoot("ammo");
        createLoot("ammo");
    }

    public Item takeItem(String itemName) {
        player.getItem(itemName);
        return player.getItem(itemName);
    }

    public Item removeItem(String name) {
        for (Item item : getCurrentRoom().getAllItems()) {
            if (item.getItemName().equals(name)) {
                getCurrentRoom().getAllItems().remove(item);
                return item;
            }
        }
        return null;
    }

}
