package kea.dk;

public class Drinks extends Item{
    private final int healthPoints;

    public Drinks(String name, int healthPoints) {
        super(name);
        this.healthPoints = healthPoints;
    }

    public int getDrinkHealth(){
        return healthPoints;
    }


}