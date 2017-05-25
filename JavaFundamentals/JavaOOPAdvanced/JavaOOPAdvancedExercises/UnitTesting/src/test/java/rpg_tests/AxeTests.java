package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Weapon;

import java.util.ArrayList;

public class AxeTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_EXPECTED_DURABILITY = AXE_ATTACK - 1;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE, new ArrayList<Weapon>());
    }

    @Test
    public void weaponAttackLoosesDurability() {
        axe.attack(dummy);

        Assert.assertEquals("Wrong axe durability points",
                AXE_EXPECTED_DURABILITY, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {

        while (axe.getAttackPoints() >= 0) {
            axe.attack(dummy);
        }

        axe.attack(dummy);
    }
}