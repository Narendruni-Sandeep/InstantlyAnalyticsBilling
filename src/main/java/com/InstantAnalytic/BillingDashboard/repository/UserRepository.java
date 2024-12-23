package com.InstantAnalytic.BillingDashboard.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.InstantAnalytic.BillingDashboard.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findById(UUID userId);
}


