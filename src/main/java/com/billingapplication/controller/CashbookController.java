package com.billingapplication.controller;

import com.billingapplication.model.Cashbook;
import com.billingapplication.service.CashbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cashbook")
public class CashbookController {

    @Autowired
    private CashbookService cashbookService;

    @PostMapping
    public ResponseEntity<Cashbook> createCashbookEntry(@RequestBody Cashbook cashbook) {
        Cashbook createdEntry = cashbookService.createCashbookEntry(cashbook);
        return ResponseEntity.ok(createdEntry);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Cashbook> updateCashbookEntry(@PathVariable("id") String cashbookId, @RequestBody Cashbook cashbookDetails) {
        Cashbook updatedEntry = cashbookService.updateCashbookEntry(cashbookId, cashbookDetails);
        return ResponseEntity.ok(updatedEntry);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCashbookEntry(@PathVariable("id") String cashbookId) {
        cashbookService.deleteCashbookEntry(cashbookId);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }

   
    @GetMapping("/balance")
    public ResponseEntity<Double> getMasterBalance() {
        double balance = cashbookService.getMasterBalance();
        return ResponseEntity.ok(balance);
    }

    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
