package kea.dk;

import java.util.ArrayList;

public class Item {
    private String itemName;
    private ArrayList<Item> items;
    public Item(String itemName) {
        this.itemName = itemName;
    }
    public String itemName() {
        return itemName;
    }
    public void add(Item item){
        items.add(item);
    }
    public ArrayList<Item> getAllItems() {
        return items;
    }
    public void createItem(){
        Item item1 = new Item("massive bong");
        Item item2 = new Item("machete");
        Item item3 = new Item("gun");

        items.add(item1);
        items.add(item2);
        items.add(item3);
    }
}
