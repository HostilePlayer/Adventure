package kea.dk;

public class MeleeWeapon extends Weapons{

    public MeleeWeapon(String name, int damage) {
        super(name, damage);
    }
    public boolean canUse() {
        return true;
    }
}
