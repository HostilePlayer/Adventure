package kea.dk;

public class Weapons extends Item {
    protected int damage;

    public Weapons(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    public int getDamage(){
        return damage;
    }

}