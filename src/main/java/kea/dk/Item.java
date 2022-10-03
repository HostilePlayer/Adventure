package kea.dk;

public class Item {
    private String itemName;

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void removeItem(String itemName){
       // itemName
    }

    @Override
    public String toString() {
        return itemName;
    }
}
