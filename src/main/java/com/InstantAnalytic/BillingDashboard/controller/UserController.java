package com.InstantAnalytic.BillingDashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.InstantAnalytic.BillingDashboard.model.User;
import com.InstantAnalytic.BillingDashboard.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/validate")
    public ResponseEntity<String> validateUser(@RequestParam UUID userId) {
        return userService.findById(userId)
            .map(user -> ResponseEntity.ok("User valid"))
            .orElse(ResponseEntity.status(404).body("User not found"));
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }
}

