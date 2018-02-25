package entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "gender", nullable = false)
    private String gender;

    @ManyToMany
    private Set<User> friends;

    public User() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<User> getFriends() {
        return this.friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public boolean isFriendWith(String username) {
        for (User friend : this.friends) {
            if (friend.getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }

    public void removeFriend(User friendToBeRemoved) {
        this.friends = this.friends.stream()
                .filter(u -> !u.getUsername().equals(friendToBeRemoved.getUsername()))
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result
                .append("<div class=\"col-md-3 d-flex flex-column mb-4\">")
                .append(String.format("<img src=\"png/%s.png\" class=\"mx-auto img-thumbnail\" width=\"200\" height=\"200\">", this.gender.toLowerCase()))
                .append(String.format("<h4 class=\"mx-auto\">%s</h4>", this.username))
                .append(String.format("<a href=\"/friends/add/%s\" class=\"btn btn-md btn-info\">Add Friend</a>", this.id))
                .append("</div>");

        return result.toString();
    }
}