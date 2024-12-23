package com.InstantAnalytic.BillingDashboard.config;

import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {

    @Value("${stripe.api.secret-key}")
    private String secretKey;

    @Value("${stripe.api.publishable-key}")
    private String publishableKey;

    public String getPublishableKey() {
        return publishableKey;
    }

    @Value("${stripe.api.secret-key}")
    public void setStripeApiKey(String key) {
        Stripe.apiKey = key;
    }
}

