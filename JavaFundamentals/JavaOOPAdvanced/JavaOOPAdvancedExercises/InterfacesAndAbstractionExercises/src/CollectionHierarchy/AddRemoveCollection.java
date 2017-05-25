package CollectionHierarchy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddRemoveCollection implements IAddRemoveCollection {

    private List<String> items;

    public AddRemoveCollection() {
        this.items = new ArrayList<>();
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    @Override
    public int add(String item) {
        this.items.add(0, item);

        return 0;
    }

    @Override
    public String remove() {
        return this.remove(this.items.size() - 1);
    }

    public String remove(int index) {
        String item = this.items.get(index);

        this.items.remove(index);

        return item;
    }
}