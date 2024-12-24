package com.InstantAnalytic.BillingDashboard.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.InstantAnalytic.BillingDashboard.model.BillingHistory;

@Repository
public interface BillingHistoryRepository extends JpaRepository<BillingHistory, String> {

    // Correct query to match the email column in the BillingHistory table
    @Query("SELECT b FROM BillingHistory b WHERE b.email = :email")
    List<BillingHistory> findByUserEmail(String email);
}

