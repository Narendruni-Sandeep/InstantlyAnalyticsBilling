package com.InstantAnalytic.BillingDashboard.model;


import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String subscriptionStatus;
    
    @Column(nullable = false)
    private String subscriptionBilling;

	@Column
    private java.sql.Date subscriptionStartDate;

    @Column
    private java.sql.Date subscriptionEndDate;
    
    @Column
    private String customerId;
    
    public String getSubscriptionBilling() {
		return subscriptionBilling;
	}

	public void setSubscriptionBilling(String subscriptionBilling) {
		this.subscriptionBilling = subscriptionBilling;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	public java.sql.Date getSubscriptionStartDate() {
		return subscriptionStartDate;
	}

	public void setSubscriptionStartDate(java.sql.Date subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}

	public java.sql.Date getSubscriptionEndDate() {
		return subscriptionEndDate;
	}

	public void setSubscriptionEndDate(java.sql.Date subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}

    // Getters and Setters
}


