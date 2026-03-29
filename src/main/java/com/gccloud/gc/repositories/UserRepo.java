package com.gccloud.gc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gccloud.gc.entities.User;


@Repository
public interface UserRepo extends JpaRepository<User, String> {
    // extra methods can be defined here if needed
    // custom query methods can be added based on the requirements
    // custom finder methods
    

    Optional<User> findByEmail(String email);
}
