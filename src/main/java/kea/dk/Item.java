package kea.dk;

public class Item {
    private String itemName;

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName(String itemName) {
        return itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }
}
