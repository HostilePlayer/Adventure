package kea.dk;

public class Adventure {
    Map creator = new Map();
    Player player = new Player();
    boolean isItemFood;
    boolean isFoodGood;

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

    public boolean isItemFood(String item) {
        if (item.contains("pringles") || item.contains("flesh") ) {
            isItemFood = true;
        } else {
            isItemFood = false;
        }
        return isItemFood;
    }

    public boolean isItemGood(String item) {
        if (item.contains("pringles")) {
            isFoodGood = true;
        } else {
            isFoodGood = false;
        }
        return isFoodGood;
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
