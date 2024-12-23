package com.InstantAnalytic.BillingDashboard.service;

import com.stripe.Stripe;
import com.stripe.model.billingportal.Session; // Billing Portal Session
import com.stripe.param.billingportal.SessionCreateParams; // Billing Portal Params
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    // Constructor or initialization block to set the Stripe API key
    public PaymentService() {
        Stripe.apiKey = "sk_test_51QXGUlAH2TnRWion9He1eunoDKk6Ad77scBlth8TIBCTwB78pIoS0QozfQ2svpZdXDHF5VtckpTwelTMUWxzYaER00ePzOvStN"; // Replace with your Stripe secret key
    }

    // Method to create a Stripe Checkout Session for subscription
    public String createCheckoutSession(String userId, String email, String successUrl, String cancelUrl) throws Exception {
        try {
            // Replace with your actual Stripe Price ID
            String priceId = "price_1QXJndAH2TnRWionN3PCcHKE";

            // Use fully qualified name for Checkout SessionCreateParams
            com.stripe.param.checkout.SessionCreateParams params = com.stripe.param.checkout.SessionCreateParams.builder()
                .setMode(com.stripe.param.checkout.SessionCreateParams.Mode.SUBSCRIPTION)
                .setSuccessUrl(successUrl)
                .setCancelUrl(cancelUrl)
                .addLineItem(
                    com.stripe.param.checkout.SessionCreateParams.LineItem.builder()
                        .setPrice(priceId) // Use your Stripe Price ID
                        .setQuantity(1L)   // Subscription quantity
                        .build()
                )
                .putMetadata("userId", userId) // Attach userId as metadata
                .putMetadata("email", email)  // Attach email as metadata
                .build();

            // Use fully qualified name for Checkout Session creation
            com.stripe.model.checkout.Session session = com.stripe.model.checkout.Session.create(params);

            // Return the session URL for redirection
            return session.getUrl();
        } catch (Exception e) {
            // Log the error and rethrow the exception
            System.err.println("Error creating Checkout Session: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    // Existing method for creating Stripe Customer Portal session
    public String createCustomerPortal(String customerId, String returnUrl) throws Exception {
        try {
            // Build session parameters for the Stripe Customer Portal
            SessionCreateParams params = SessionCreateParams.builder()
                .setCustomer(customerId)
                .setReturnUrl(returnUrl)
                .build();

            // Create the session
            Session session = Session.create(params);

            // Return the portal URL
            return session.getUrl();
        } catch (Exception e) {
            // Log the error and rethrow the exception
            System.err.println("Error creating customer portal session: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
