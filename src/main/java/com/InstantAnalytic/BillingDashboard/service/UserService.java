package com.InstantAnalytic.BillingDashboard.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InstantAnalytic.BillingDashboard.model.User;
import com.InstantAnalytic.BillingDashboard.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findById(UUID userId) {
        return userRepository.findById(userId);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
