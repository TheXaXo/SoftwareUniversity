package CollectionHierarchy;

public class MyList extends AddRemoveCollection implements IMyList {

    public MyList() {
        super();
    }

    @Override
    public int used() {
        return super.getItems().size();
    }

    @Override
    public String remove() {
        return super.remove(0);
    }
}