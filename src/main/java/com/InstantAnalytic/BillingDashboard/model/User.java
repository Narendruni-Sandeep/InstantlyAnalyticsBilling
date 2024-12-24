package com.InstantAnalytic.BillingDashboard.model;


import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "instantly_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String subscriptionStatus;
    
    @Column(nullable = false)
    private String subscriptionBillingStatus;

	@Column
    private Timestamp currentPeriodStart;

    @Column
    private Timestamp currentPeriodEnd;
    
    @Column
    private String customerId;
    
    

	public String getSubscriptionBillingStatus() {
		return subscriptionBillingStatus;
	}

	public void setSubscriptionBillingStatus(String subscriptionBillingStatus) {
		this.subscriptionBillingStatus = subscriptionBillingStatus;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	

	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Timestamp getCurrentPeriodStart() {
		return currentPeriodStart;
	}

	public void setCurrentPeriodStart(Timestamp currentPeriodStart) {
		this.currentPeriodStart = currentPeriodStart;
	}

	public Timestamp getCurrentPeriodEnd() {
		return currentPeriodEnd;
	}

	public void setCurrentPeriodEnd(Timestamp currentPeriodEnd) {
		this.currentPeriodEnd = currentPeriodEnd;
	}

	

	

    // Getters and Setters
}


