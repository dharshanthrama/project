package com.billingapplication.repo;

import com.billingapplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
    // You can add custom queries here if needed
}
