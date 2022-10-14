package kea.dk;

public class Food extends Item{
    private final int healthPoints;

    public Food(String name, int healthPoints) {
        super(name);
        this.healthPoints = healthPoints;
    }

    public int getFoodHealth(){
        return healthPoints;
    }


}
