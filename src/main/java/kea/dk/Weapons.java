package kea.dk;

public class Weapons extends Item {
    private final int damage;

    public Weapons(String name, int damage) {
        super(name);
        this.damage = damage;
    }
    public int getDamage(){
        return damage;
    }

    public boolean canUse(){
        return true;
    }
}