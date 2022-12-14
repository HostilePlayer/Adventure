package kea.dk;

import java.util.ArrayList;

public class Room {
    private final String name;
    private final String description;
    private Room north;
    private Room south;
    private Room west;
    private Room east;
    private final int darkness;
    private final boolean npcInRoom;
    private Room teleport;

    public ArrayList<Item> roomItems = new ArrayList<>();
    public ArrayList<Enemy> enemies = new ArrayList<>();

    public Room(String name, String description, int darkness, boolean npcInRoom) {
        this.name = name;
        this.description = description;
        this.darkness = darkness;
        this.npcInRoom = npcInRoom;
    }

    public void createItem(String itemName) {
        Item item = new Item(itemName);
        roomItems.add(item);
    }

    public void createFoodItem(String itemName, int healPoints){
        Food food = new Food(itemName, healPoints);
        roomItems.add(food);
    }

    public void createRangedWeapon(String itemName, int damage, int ammo){
        RangedWeapon rangedWeapon = new RangedWeapon(itemName, damage, ammo);
        roomItems.add(rangedWeapon);
    }

    public void createMeleeWeapon(String itemName, int damage){
        MeleeWeapon meleeWeapon = new MeleeWeapon(itemName, damage);
        roomItems.add(meleeWeapon);
    }

    public void createDrinkItem(String itemName, int healPoints){
        Drinks drink = new Drinks(itemName, healPoints);
        roomItems.add(drink);
    }

    public void createShield(String itemName){
        Shield shield = new Shield(itemName);
        roomItems.add(shield);
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

    public boolean getNpcInRoom(){
        return npcInRoom;
    }

    public void setRoom(Room north, Room east, Room south, Room west, Room teleport) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.teleport = teleport;
    }
}
