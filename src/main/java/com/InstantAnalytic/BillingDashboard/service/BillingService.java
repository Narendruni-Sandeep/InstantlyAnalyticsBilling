package com.InstantAnalytic.BillingDashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InstantAnalytic.BillingDashboard.model.User;
import com.InstantAnalytic.BillingDashboard.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class BillingService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserDetails(UUID userId) {
        return userRepository.findById(userId);
    }
}

