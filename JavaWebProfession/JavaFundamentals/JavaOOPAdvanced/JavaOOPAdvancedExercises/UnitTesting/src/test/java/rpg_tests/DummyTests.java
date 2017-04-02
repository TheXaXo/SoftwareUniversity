package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;
import rpg_lab.Weapon;

import java.util.ArrayList;

public class DummyTests {

    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int AXE_ATTACK_POINTS = 5;

    private Dummy dummy;

    @Before
    public void initializeDummyObject() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE, new ArrayList<Weapon>());
    }

    @Test
    public void dummyLosesHealthOnAttack() {
        dummy.takeAttack(AXE_ATTACK_POINTS);

        Assert.assertEquals("Wrong dummy health",
                DUMMY_HEALTH - AXE_ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionOnAttack() {
        dummy.takeAttack(DUMMY_HEALTH);
        dummy.takeAttack(DUMMY_HEALTH);
    }

    @Test
    public void deadDummyThrowsXP() {
        dummy.takeAttack(DUMMY_HEALTH);

        Assert.assertEquals("Wrong XP given", DUMMY_EXPERIENCE, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyDoesNotGiveXP() {
        dummy.giveExperience();
    }
}