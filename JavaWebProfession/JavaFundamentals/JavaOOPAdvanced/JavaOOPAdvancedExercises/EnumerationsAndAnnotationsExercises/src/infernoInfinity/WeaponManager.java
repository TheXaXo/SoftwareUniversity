package infernoInfinity;

import java.util.HashMap;
import java.util.Map;

public class WeaponManager {

    private Map<String, Weapon> nameWeapon;

    public WeaponManager() {
        this.nameWeapon = new HashMap<>();
    }

    public void create(String weaponType, String weaponName) {
        Weapon weapon = new Weapon(weaponName, weaponType);

        this.nameWeapon.putIfAbsent(weaponName, weapon);
    }

    public void add(String weaponName, int index, String gemType) {
        if (this.nameWeapon.containsKey(weaponName)) {
            try {
                this.nameWeapon.get(weaponName).add(gemType, index);
            } catch (IllegalArgumentException ex) {
                return;
            }
        }
    }

    public void remove(String weaponName, int index) {
        if (this.nameWeapon.containsKey(weaponName)) {
            try {
                this.nameWeapon.get(weaponName).remove(index);
            } catch (IllegalArgumentException ex) {
                return;
            }
        }
    }

    public void print(String weaponName) {
        if (this.nameWeapon.containsKey(weaponName)) {
            System.out.println(nameWeapon.get(weaponName));
        }
    }

    public void compare(String weaponOneStr, String weaponTwoStr) {
        if (this.nameWeapon.containsKey(weaponOneStr) && this.nameWeapon.containsKey(weaponTwoStr)) {
            Weapon weaponOne = this.nameWeapon.get(weaponOneStr);
            Weapon weaponTwo = this.nameWeapon.get(weaponTwoStr);

            if (weaponOne.compareTo(weaponTwo) >= 0) {
                System.out.println(weaponOne.printComparable());
            } else {
                System.out.println(weaponTwo.printComparable());
            }
        }
    }
}