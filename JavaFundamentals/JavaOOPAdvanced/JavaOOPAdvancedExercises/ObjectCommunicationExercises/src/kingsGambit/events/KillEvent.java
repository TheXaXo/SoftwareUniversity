package kingsGambit.events;

import kingsGambit.models.Observer;
import kingsGambit.models.Subject;

public class KillEvent {

    public void executeEvent(Observer observer, Subject king) {
        observer.takeHit();

        if (observer.getHealth() <= 0) {
            king.removeObserver(observer);
        }
    }
}
