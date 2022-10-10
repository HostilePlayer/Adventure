package kea.dk;

public class Weapons extends Item {
    private int damage;

    public Weapons(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    public int getDamage(){
        return damage;
    }

}