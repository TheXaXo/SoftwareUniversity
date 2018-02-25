package repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BaseRepository {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("casebook_db");

    private EntityTransaction transaction;
    protected EntityManager entityManager;

    protected BaseRepository() {

    }

    private void initEntityManager() {
        this.entityManager = factory.createEntityManager();
    }

    private void initTransaction() {
        if (this.transaction != null && this.transaction.isActive()) {
            throw new IllegalArgumentException("Transaction is active.");
        }

        this.transaction = this.entityManager.getTransaction();
        this.transaction.begin();
    }

    private void commitTransaction() {
        if (this.transaction == null || !this.transaction.isActive()) {
            throw new IllegalArgumentException("Transaction is inactive.");
        }

        this.transaction.commit();
    }

    private void dispose() {
        this.entityManager.close();
    }

    protected RepositoryActionResult execute(RepositoryInvoker invoker) {
        RepositoryActionResult result = new RepositoryActionResult(null);

        try {
            this.initEntityManager();
            this.initTransaction();

            invoker.invoke(result);

            this.commitTransaction();
            this.dispose();
        } catch (Exception e) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }

            e.printStackTrace();
        }

        return result;
    }
}