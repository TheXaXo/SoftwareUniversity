package models.targets;

import models.attackers.Observer;

public interface Subject {

    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();
}