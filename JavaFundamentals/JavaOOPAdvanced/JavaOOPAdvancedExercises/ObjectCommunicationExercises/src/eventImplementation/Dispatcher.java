package eventImplementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private String name;
    private List<NameChangeListener> listeners;

    public Dispatcher() {
        this.listeners = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
        this.fireNameChangedEvent(new NameChange(name));
    }

    public void addNameChangerListener(NameChangeListener listener) {
        this.listeners.add(listener);
    }

    public void removeNameChangerListener(NameChangeListener listener) {
        this.listeners.remove(listener);
    }

    private void fireNameChangedEvent(NameChange event) {
        for (NameChangeListener listener : this.listeners) {
            listener.handleChangedName(event);
        }
    }
}