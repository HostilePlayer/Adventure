package kea.dk;

public class Food extends Item{
    private boolean isEatAble;
    private boolean isHealthy;

    public Food(String itemName, boolean isEatAble, boolean isHealthy) {
        super(itemName);
        this.isEatAble = isEatAble;
        this.isHealthy = isHealthy;
    }

    public boolean getIsEatAble(Item item){
        return isEatAble;
    }

    public boolean getIsHealhty(){
        return isHealthy;
    }

}
