package com.hasher.userservice.service;

import com.hasher.userservice.entities.User;
import com.hasher.userservice.exceptions.ResourceNotFoundException;
import com.hasher.userservice.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User createUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        logger.info("Saving user with id : {}", randomId);
        User savedUser = userRepository.save(user);
        logger.info("User saved successfully with id {}", randomId);
        return  savedUser;
    }

    @Override
    public List<User> getALLUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByID(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(
                        "User with id "+userId+" is not available on server."));
        return user;
    }

}
