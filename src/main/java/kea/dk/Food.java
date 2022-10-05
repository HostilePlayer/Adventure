package kea.dk;

public class Food extends Item{
    private boolean isEatAble;

    public Food(String itemName, boolean isEatAble) {
        super(itemName);
        this.isEatAble = isEatAble;
    }

    public boolean getIsFood(){
        return isEatAble;
    }
}
