package kea.dk;

public class Food extends Item{
    private int isEatAble;

    public Food(String itemName, int isEatAble) {
        super(itemName);
        this.isEatAble = isEatAble;
    }

    public int getIsFood(){
        return isEatAble;
    }
}
