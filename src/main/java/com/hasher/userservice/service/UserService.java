package com.hasher.userservice.service;


import com.hasher.userservice.entities.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getALLUser();

    User getUserByID(String userId);

}
