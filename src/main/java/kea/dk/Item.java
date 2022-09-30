package kea.dk;

public class Item {
    private String itemName;
    public Item(String itemName) {
        this.itemName = itemName;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName() {
        this.itemName = itemName;
    }
    @Override
    public String toString(){
        return itemName;
    }
}
