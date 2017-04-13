package database;

import utility.Constants;
import contracts.Modelable;
import contracts.Repository;
import exeptions.DuplicateModelException;
import exeptions.NonExistentModelException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RepositoryImpl<T extends Modelable> implements Repository<T> {
    private Map<String, T> items;

    public RepositoryImpl() {
        this.setItems(new LinkedHashMap<>());
    }

    @Override
    public void add(T item) throws DuplicateModelException {
        if (this.items.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.items.put(item.getModel(), item);
    }

    @Override
    public T getItem(String model) throws NonExistentModelException {
        if (!this.items.containsKey(model)) {
            throw new NonExistentModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }

        return this.items.get(model);
    }

    @Override
    public List<T> getItems() {
        return new ArrayList<>(this.items.values());
    }

    private void setItems(Map<String, T> items) {
        this.items = items;
    }
}