package kea.dk;

import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private final ArrayList<Item> inventory = new ArrayList<>();
    private Item newItem;
    private Item currentWeapon;
    boolean lampLight = false;
    boolean lampInInventory;
    boolean shieldInInventory;
    boolean isEatAble;
    private int weaponDamage;

    private int health;
    private final int maxHealth = 100;

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void equipItem(Item weapon){
        currentWeapon = weapon;
    }

    public Item getCurrentWeapon(){
        return currentWeapon;
    }

    public Item getItemFromInventory(String itemName){
        for(Item itemFromInventory : inventory){
            if (itemFromInventory.getItemName().contains(itemName)){
                return itemFromInventory;
            }
        }
        return null;
    }
    public int currentWeaponDMG(){
        int dmg = getWeaponDMG(getCurrentWeapon());
        return dmg;
    }
    public boolean attack(Enemy enemy){
        int dmg = getWeaponDMG(getCurrentWeapon());

        if (getCurrentWeapon() instanceof RangedWeapon){
            if (((RangedWeapon) getCurrentWeapon()).canUse()){
                enemy.setEnemyHP(dmg);
                ((RangedWeapon) getCurrentWeapon()).setAmmo();
                return true;
            }
        } else if (getCurrentWeapon() instanceof MeleeWeapon){
            enemy.setEnemyHP(dmg);
            return true;
        }
        return false;
    }
    public int getPlayerHealth() {
        return health;
    }

    public void setStartingHealth(){
        health = maxHealth;
    }

    public void setPlayerHealth(int change) {
        health += change;
        if (health > maxHealth){
            health = maxHealth;
        }
    }
    public void setPlayerHP(int enemyDMG){
        health = health - enemyDMG;
    }

    public boolean eatFromInventory(Item foodItem) {
        if (foodItem instanceof Food) {
            health += ((Food) foodItem).getFoodHealth();
            return isEatAble = true; // eatable
        } else {
            return isEatAble = false; // not found
        }
    }

    public boolean drinkFromInventory(Item drinkItem) {
        if (drinkItem instanceof Drinks) {
            health += ((Drinks) drinkItem).getDrinkHealth();
            return isEatAble = true; // eatable
        } else {
            return isEatAble = false; // not found
        }
    }

    public int getWeaponDMG(Item weaponAtUse){
        weaponDamage = ((Weapons) weaponAtUse).getDamage();
        return weaponDamage;
    }

    public void equipFromInventory(Item weaponToUse) {
        if (weaponToUse instanceof Weapons) {
            currentWeapon = weaponToUse;
        }
    }

    public boolean haveShield(){
        for (Item item : inventory){
            shieldInInventory = item.getItemName().contains("shield");
        }
        return shieldInInventory;
    }

    public boolean haveLamp() {
        for (Item item : inventory) {
            lampInInventory = item.getItemName().contains("lamp");
        }
        return lampInInventory;
    }

    public boolean isLightOn() {
        boolean isLampOn;
        if (lampLight == true) {
            isLampOn = true;
        } else {
            isLampOn = false;
        }
        return isLampOn;
    }

    public void toggleLamp(boolean toggleLight) {
        lampLight = toggleLight;
    }

    public void setCurrentRoom(Room currentRoom) {

        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Item getItem(String searchTerm) {
        resetNewItem();
        //make list over items in currentRoom
        ArrayList<Item> searchResult = getCurrentRoom().getAllItems();
        //for each item
        for (Item item : searchResult) {
            //if item name match searchTerm
            if (item.getItemName().contains(searchTerm.toLowerCase())) {
                //add item til inventory
                newItem = item;
            }
        }
        return newItem;
    }
    public Item resetNewItem(){
        newItem = null;
        return newItem;
    }
    public boolean goNorth() {
        if (currentRoom.getNorth() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getNorth();
            return true;
        }

    }

    public boolean goSouth() {
        if (currentRoom.getSouth() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getSouth();
            return true;
        }
    }

    public boolean goEast() {
        if (currentRoom.getEast() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getEast();
            return true;
        }
    }

    public boolean goWest() {
        if (currentRoom.getWest() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getWest();
            return true;
        }
    }

    public boolean goTeleport() {
        if (currentRoom.goTeleport() == null) {
            return false;
        } else {
            currentRoom = currentRoom.goTeleport();
            return true;
        }
    }


    public Item removeItem(String name) {
        for (Item item : inventory) {
            if (item.getItemName().equals(name)) {
                inventory.remove(item);
                return item;
            }
        }
        return null;
    }
}
