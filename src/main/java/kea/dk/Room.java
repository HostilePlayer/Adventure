package kea.dk;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room west;
    private Room east;
    private int darkness;
    private Room teleport;

    public ArrayList<Item> roomItems = new ArrayList<>();
    public ArrayList<Enemy> enemies = new ArrayList<>();

    public Room(String name, String description, int darkness) {
        this.name = name;
        this.description = description;
        this.darkness = darkness;
    }

    public void createItem(String itemName) {
        Item item = new Item(itemName);
        roomItems.add(item);
    }

    public void createFoodItem(String itemName, int healPoints){
        Food food = new Food(itemName, healPoints);
        roomItems.add(food);
    }

    public void createWeaponItems(String itemName, int damage){
        Weapons weapons = new Weapons(itemName, damage);
        roomItems.add(weapons);
    }

    public void createEnemy(String enemyName, int enemyHP, int enemyDMG){
        Enemy enemy = new Enemy(enemyName, enemyHP, enemyDMG);
        enemies.add(enemy);
    }
    public boolean isDead(Enemy enemy){
        if (enemy.getEnemyHP() <= 0){
            enemies.remove(enemy);
            return true;
        } else return false;
    }
    public void addItem(Item item) {
        roomItems.add(item);
    }

    public ArrayList<Item> getAllItems() {
        return roomItems;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public Room getEast() {
        return east;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    public Room goTeleport() {
        return teleport;
    }

    public int getDarkness() {
        return darkness;
    }

    public void setRoom(Room north, Room east, Room south, Room west, Room teleport) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.teleport = teleport;
    }
    //her skal vi lave vores room
}
