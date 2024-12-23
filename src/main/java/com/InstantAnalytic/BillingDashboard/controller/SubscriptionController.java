package com.InstantAnalytic.BillingDashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.InstantAnalytic.BillingDashboard.service.PaymentService;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
	
	@Value("${frontend.url}")
    private String frontendurl;

    @Autowired
    private PaymentService paymentService;
    
    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(@RequestParam String userId, @RequestParam String email) {
        try {
            String successUrl = frontendurl+"/success"; // Customize your success URL
            String cancelUrl = frontendurl+"/cancel"; // Customize your cancel URL
            String checkoutUrl = paymentService.createCheckoutSession(userId, email, successUrl, cancelUrl);
            return ResponseEntity.ok(checkoutUrl);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating subscription session: " + e.getMessage());
        }
    }

    @PostMapping("/cancel")
    public ResponseEntity<String> cancel(@RequestParam String customerId) {
        try {
            String returnUrl = frontendurl+"/dashboard"; // Redirect URL after cancellation
            String portalUrl = paymentService.createCustomerPortal(customerId, returnUrl);
            return ResponseEntity.ok(portalUrl);
        } catch (Exception e) {
            // Log the error for better debugging (use a logging framework)
            System.err.println("Error creating customer portal session: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error creating customer portal session: " + e.getMessage());
        }
    }
}
