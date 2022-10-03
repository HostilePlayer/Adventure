package kea.dk;

public class Item {
    private String itemName;

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() { //denne metode ser ikke ud til at virke, men hvorfor?
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
