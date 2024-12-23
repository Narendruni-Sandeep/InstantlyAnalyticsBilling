package com.InstantAnalytic.BillingDashboard.model;

import java.sql.Timestamp;
import java.util.UUID;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "billing_history")
public class BillingHistory {

    @Id
    @Column(nullable = false)
    private String paymentId;

    @Column
    private String customerId;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private String status;

	@Column(nullable = false)
    private Timestamp date;

    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String paymentInvoice;

    // Getters and Setters
    
    public String getPaymentInvoice() {
		return paymentInvoice;
	}

	public void setPaymentInvoice(String paymentInvoice) {
		this.paymentInvoice = paymentInvoice;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

    // Getters and Setters
}
