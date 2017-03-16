package CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddCollection implements IAddCollection {

    private List<String> items;

    public AddCollection() {
        this.items = new ArrayList<>();
    }

    @Override
    public int add(String item) {
        this.items.add(item);

        return items.size() - 1;
    }
}