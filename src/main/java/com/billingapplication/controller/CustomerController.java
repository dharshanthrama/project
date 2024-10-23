package com.billingapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.billingapplication.model.customer;
import com.billingapplication.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/add")
    public ResponseEntity<customer> addCustomer(@RequestBody customer customer) {
        customer savedCustomer = service.saveRecords(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PostMapping("/multicust")
    public ResponseEntity<List<customer>> addMultipleCustomers(@RequestBody List<customer> customers) {
        List<customer> savedCustomers = service.saveAllRecords(customers);
        return new ResponseEntity<>(savedCustomers, HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<customer>> findAllCustomers() {
        List<customer> customers = service.getrecords();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/customer/{customerid}")
    public ResponseEntity<customer> findCustomerByCustomerId(@PathVariable String customerid) {
        customer customer = service.getCustomerById(customerid);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<customer> updateCustomer(@RequestBody customer customer) {
        customer updatedCustomer = service.updateCustomer(customer);
        if (updatedCustomer != null) {
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        try {
            String result = service.deletecustomer(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}