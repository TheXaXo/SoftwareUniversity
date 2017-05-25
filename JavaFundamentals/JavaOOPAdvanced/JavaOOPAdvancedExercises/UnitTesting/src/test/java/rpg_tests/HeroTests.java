package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.*;

public class HeroTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int XP_TO_GIVE = 10;

    private Target target;
    private Weapon weapon;
    private Hero hero;

    @Before
    public void initializeObjects() {
        target = Mockito.mock(Dummy.class);
        weapon = new Axe(AXE_ATTACK, AXE_DURABILITY);
        hero = new Hero("Hero", this.weapon);
    }

    @Test
    public void heroGainsXPOnTargetDeath() {
        Mockito.when(this.target.isDead()).thenReturn(true);
        Mockito.when(this.target.giveExperience()).thenReturn(XP_TO_GIVE);

        this.hero.attack(target);

        Assert.assertEquals("Wrong XP given", XP_TO_GIVE, this.hero.getExperience());
    }

    @Test
    public void heroGetsLootFromDeadTarget() {
        Mockito.when(this.target.isDead()).thenReturn(true);
        Mockito.when(this.target.dropLoot()).thenReturn(this.weapon);

        this.hero.attack(this.target);

        Assert.assertTrue(this.hero.getInventory().iterator().hasNext());
    }
}