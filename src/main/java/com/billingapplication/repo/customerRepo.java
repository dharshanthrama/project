package com.billingapplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billingapplication.model.customer;

@Repository
public interface customerRepo extends JpaRepository<customer, String> {

	customer findBycustomerid(String customerid);

}