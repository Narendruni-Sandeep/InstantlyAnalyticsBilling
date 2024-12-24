package com.InstantAnalytic.BillingDashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.InstantAnalytic.BillingDashboard.model.BillingHistory;
import com.InstantAnalytic.BillingDashboard.model.User;
import com.InstantAnalytic.BillingDashboard.repository.BillingHistoryRepository;
import com.InstantAnalytic.BillingDashboard.repository.UserRepository;
import com.InstantAnalytic.BillingDashboard.service.BillingService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class BillingController {

    @Autowired
    private BillingHistoryRepository billingHistoryRepository;

    @GetMapping("/billing-history")
    public ResponseEntity<List<BillingHistory>> getBillingHistory(@RequestParam String email) {
        List<BillingHistory> history = billingHistoryRepository.findByUserEmail(email);
        return ResponseEntity.ok(history != null ? history : Collections.emptyList());
    }
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/billing")
    public ResponseEntity<?> getBillingDetails(@RequestParam UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("User with ID " + id + " not found");
    }
}



