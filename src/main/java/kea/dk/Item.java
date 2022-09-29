package kea.dk;

public class Item {
    Player player = new Player();
    private String itemName;
    public Item(String itemName) {
        this.itemName = itemName;
    }
    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString(){
        return itemName;
    }
}
