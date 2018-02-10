package org.softuni.main.database.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.Method;
import java.util.HashMap;

public abstract class BaseRepository implements Repository {
    private EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    private HashMap<String, Method> methods;

    public BaseRepository() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("casebook");
        this.entityManager = this.entityManagerFactory.createEntityManager();
        this.initializeMethods();
    }

    private void initializeMethods() {
        this.methods = new HashMap<>();

        for (Method method : this.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            this.methods.putIfAbsent(method.getName(), method);
        }
    }

    @Override
    public Object doAction(String action, Object... args) {
        EntityTransaction transaction = null;
        Object result = null;

        try {
            transaction = this.entityManager.getTransaction();
            transaction.begin();

            result = this.methods.get(action).invoke(this, args);

            transaction.commit();
            return result;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
            return result;
        }
    }

    @Override
    public void dismiss() {
        this.entityManager.close();
        this.entityManagerFactory.close();
    }
}