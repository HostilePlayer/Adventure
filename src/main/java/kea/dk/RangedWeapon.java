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
    public void setAmmo(){
        ammo = ammo - 1;
    }
    public boolean canUse() {
        return ammo >= 1;
    }
}
