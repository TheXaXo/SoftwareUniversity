package org.softuni.nuggets.repositories;

import org.softuni.nuggets.entities.Nugget;
import org.softuni.nuggets.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
