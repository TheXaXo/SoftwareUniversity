package repositories;

import entities.User;

import java.util.List;

public class UserRepository extends BaseRepository {
    public void createUser(User user) {
        this.execute(result -> this.entityManager.persist(user));
    }

    public void addFriend(User user, User friend) {
        user.getFriends().add(friend);
        friend.getFriends().add(user);

        this.execute(result -> this.entityManager.merge(user));
        this.execute(result -> this.entityManager.merge(friend));
    }

    public void removeFriend(User user, User friend) {
        user.removeFriend(friend);
        friend.removeFriend(user);

        this.execute(result -> this.entityManager.merge(user));
        this.execute(result -> this.entityManager.merge(friend));
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

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        List<User> users = (List<User>) this.execute(actionResult -> {
            Object queryResult = this.entityManager
                    .createNativeQuery("SELECT * FROM users AS u", User.class)
                    .getResultList();

            actionResult.setResult(queryResult);
        }).getResult();

        return users;
    }
}