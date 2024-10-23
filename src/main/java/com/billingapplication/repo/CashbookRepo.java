package com.billingapplication.repo;

import com.billingapplication.model.Cashbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashbookRepo extends JpaRepository<Cashbook, String> {
    // Additional custom query methods can be defined here if needed
}
