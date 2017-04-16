package kingsGambit.models;

import java.util.ArrayList;
import java.util.List;

public class King extends Person implements Subject {

    private List<Observer> observers;

    public King(String name) {
        super(name);
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.printf("King %s is under attack!%n", super.getName());

        for (Observer observer : this.observers) {
            observer.notifyCurrent();
        }
    }
}