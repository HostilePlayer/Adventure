package kea.dk;

public class RangedWeapon extends Weapons{
    private int ammo;

    public rangedWeapons(String name, int damage, int ammo) {
        super(name, damage);
        this.ammo = ammo;
    }
    public int getAmmo(){
        return ammo;
    }
    //merge conflict?

}
