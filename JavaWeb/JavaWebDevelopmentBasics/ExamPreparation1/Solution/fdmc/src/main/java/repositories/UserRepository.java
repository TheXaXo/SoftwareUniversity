package repositories;

import entities.User;

public class UserRepository extends BaseRepository {
    public void createUser(User user) {
        this.execute(result -> this.entityManager.persist(user));
    }

    @SuppressWarnings("unchecked")
    private User findBy(String parameterName, String parameterValue) {
        User user = (User) this.execute(actionResult -> {
            Object queryResult = this.entityManager
                    .createNativeQuery("SELECT * FROM users AS u WHERE u." + parameterName + "= \'" + parameterValue + "\'", User.class)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            actionResult.setResult(queryResult);
        }).getResult();

        return user;
    }

    public User findById(String userId) {
        return this.findBy("id", userId);
    }

    public User findByUsername(String username) {
        return this.findBy("username", username);
    }

    public User findByEmail(String email) {
        return this.findBy("email", email);
    }
}