package com.billingapplication.service;

import com.billingapplication.model.Cashbook;
import com.billingapplication.model.MasterBalance;
import com.billingapplication.model.User;
import com.billingapplication.repo.CashbookRepo;
import com.billingapplication.repo.UserRepo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashbookService {

    @Autowired
    private CashbookRepo cashbookRepository;

    @Autowired
    private UserRepo userRepository;

    private MasterBalance masterBalance = new MasterBalance(0.0); 

    // Method to generate a random 6-digit code
    private String generate6DigitCode() {
        return String.format("%06d", (int) (Math.random() * 1000000));
    }

    @Transactional
    public Cashbook createCashbookEntry(Cashbook cashbook) {
        User user = userRepository.findByEmail(cashbook.getUserEmail());
        if (user == null) {
            throw new IllegalArgumentException("User with email " + cashbook.getUserEmail() + " does not exist.");
        }

        // Generate a unique 6-digit code
        String uniqueCode = generate6DigitCode();
        cashbook.setCode(uniqueCode); // Assuming Cashbook has a setCode method

        Cashbook savedEntry = cashbookRepository.save(cashbook);

        cashbook.adjustBalance(masterBalance);

        return savedEntry;
    }

    public Cashbook updateCashbookEntry(String cashbookId, Cashbook cashbookDetails) {
        Cashbook existingCashbook = cashbookRepository.findById(cashbookId)
                .orElseThrow(() -> new IllegalArgumentException("Cashbook entry with ID " + cashbookId + " does not exist."));

        User user = userRepository.findByEmail(cashbookDetails.getUserEmail());
        if (user == null) {
            throw new IllegalArgumentException("User with email " + cashbookDetails.getUserEmail() + " does not exist.");
        }

        existingCashbook.setName(cashbookDetails.getName());
        existingCashbook.setAmount(cashbookDetails.getAmount());
        existingCashbook.setDescription(cashbookDetails.getDescription());
        existingCashbook.setDate(cashbookDetails.getDate());
        existingCashbook.setInOut(cashbookDetails.getInOut());
        existingCashbook.setUserEmail(cashbookDetails.getUserEmail());

        return cashbookRepository.save(existingCashbook);
    }

    public void deleteCashbookEntry(String cashbookId) {
        if (!cashbookRepository.existsById(cashbookId)) {
            throw new IllegalArgumentException("Cashbook entry with ID " + cashbookId + " does not exist.");
        }

        cashbookRepository.deleteById(cashbookId);
    }

    public double getMasterBalance() {
        return masterBalance.getBalance();
    }
}
