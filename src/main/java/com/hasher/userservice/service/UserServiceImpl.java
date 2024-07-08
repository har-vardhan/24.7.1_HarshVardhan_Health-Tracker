package com.hasher.userservice.service;

import com.hasher.userservice.entities.User;
import com.hasher.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getALLUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByID(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user;
    }

}
