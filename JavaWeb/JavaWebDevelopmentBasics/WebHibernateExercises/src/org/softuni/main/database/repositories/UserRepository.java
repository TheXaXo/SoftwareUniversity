package org.softuni.main.database.repositories;

import org.softuni.main.database.models.User;

import java.util.List;

public class UserRepository extends BaseRepository {
    private boolean create(String username, String password) {
        super.entityManager.persist(new User(username, password));
        return true;
    }

    private User findBy(String criteria, String value) {
        String query = "SELECT * FROM users AS u WHERE u." + criteria + " = \'" + value + "\'";

        return (User) this.entityManager
                .createNativeQuery(query, User.class)
                .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    private User[] findAll() {
        List<User> resultList = this.entityManager
                .createNativeQuery("SELECT * FROM users", User.class)
                .getResultList();
        return resultList.toArray(new User[resultList.size()]);
    }

    private void addFriend(String username, String friendName) {
        User user = this.findBy("username", username);
        User friend = this.findBy("username", friendName);

        user.addFriend(friend);
        friend.addFriend(user);
    }
}