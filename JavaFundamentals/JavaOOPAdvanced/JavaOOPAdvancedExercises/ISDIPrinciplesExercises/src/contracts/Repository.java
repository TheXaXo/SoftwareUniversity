package contracts;

import exeptions.DuplicateModelException;
import exeptions.NonExistentModelException;

import java.util.List;

public interface Repository<T extends Modelable> {

    void add(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistentModelException;

    List<T> getItems();
}