package kea.dk;

public class RangedWeapon extends Weapons{
    private int ammo;

    public RangedWeapon(String name, int damage, int ammo) {
        super(name, damage);
        this.ammo = ammo;
    }

    public int getAmmoLeft() {
        return ammo;
    }

    public boolean canUse() {
        if (ammo < 1){
            return false;
        } else {
            return true;
        }
    }
}
