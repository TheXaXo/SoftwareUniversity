package blobs.models.attacks;

import blobs.models.Blob;

public class Blobplode extends AbstractAttack {

    @Override
    public void execute(Blob attacker, Blob target) {
        int attackerHealthAfterTurn = attacker.getHealth() / 2;

        if (attackerHealthAfterTurn < 1) {
            attackerHealthAfterTurn = 1;
        }

        attacker.setHealth(attackerHealthAfterTurn);
        target.respond(attacker.getDamage() * 2);
    }
}