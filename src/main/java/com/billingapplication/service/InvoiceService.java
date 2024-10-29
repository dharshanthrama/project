package com.billingapplication.service;

import com.billingapplication.model.Invoice;
import com.billingapplication.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(String invoiceId) {
        return invoiceRepository.findById(invoiceId);
    }

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(String invoiceId, Invoice updatedInvoice) {
        Optional<Invoice> existingInvoiceOpt = invoiceRepository.findById(invoiceId);
        
        if (existingInvoiceOpt.isPresent()) {
            Invoice existingInvoice = existingInvoiceOpt.get();
            existingInvoice.setCustomer(updatedInvoice.getCustomer());
            existingInvoice.setProducts(updatedInvoice.getProducts());
            existingInvoice.setPaymentName(updatedInvoice.getPaymentName());
            existingInvoice.setPaymentNum(updatedInvoice.getPaymentNum());
            existingInvoice.setAddress(updatedInvoice.getAddress());
            existingInvoice.setGstin(updatedInvoice.getGstin());
            existingInvoice.setBillNum(updatedInvoice.getBillNum());
            existingInvoice.setBillDate(updatedInvoice.getBillDate());
            existingInvoice.setTermDueDate(updatedInvoice.getTermDueDate());
            return invoiceRepository.save(existingInvoice);
        } else {
            return null; // Or throw a custom exception if desired
        }
    }

    public void deleteInvoice(String invoiceId) {
        invoiceRepository.deleteById(invoiceId);
    }
}
