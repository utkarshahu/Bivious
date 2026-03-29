package com.gccloud.gc.services;

import java.util.List;
import java.util.Optional;

import com.gccloud.gc.entities.User;

public interface UserServices {

    User saveUser(User user);
    Optional <User> getUserById(String id);
    Optional<User> updateUser(User user);
    void deleteUser(String id);
    boolean isUserExists(String userId);
    boolean isUserExistsByEmail(String email);

    List<User> getAllUsers();

    
}
