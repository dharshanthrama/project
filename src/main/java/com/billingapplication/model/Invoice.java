package com.billingapplication.model;

import jakarta.persistence.*;
import java.util.Set;
import com.billingapplication.util.IDGenerator;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    private String invoiceId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private customer customer; 

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "invoice_products",
        joinColumns = @JoinColumn(name = "invoice_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;

    private String paymentName;
    private String paymentNum;
    private String address;
    private String gstin;
    private String billNum;
    private String billDate;
    private String termDueDate;

    // Default constructor
    public Invoice() {
        this.invoiceId = IDGenerator.generateInvoiceId(); // Generate invoice ID
        this.gstin = IDGenerator.generateGstin(); // Generate GSTIN
        this.billNum = IDGenerator.generateBillNum(); // Generate Bill Number
    }

    // Parameterized constructor
    public Invoice(String invoiceId, customer customer, Set<Product> products,
                   String paymentName, String paymentNum, String address, String gstin, 
                   String billNum, String billDate, String termDueDate) {
        this.invoiceId = invoiceId;
        this.customer = customer;
        this.products = products;
        this.paymentName = paymentName;
        this.paymentNum = paymentNum;
        this.address = address;
        this.gstin = gstin;
        this.billNum = billNum;
        this.billDate = billDate;
        this.termDueDate = termDueDate;
    }

    // Getters and Setters
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public customer getCustomer() { 
        return customer;
    }

    public void setCustomer(customer customer) { 
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getPaymentNum() {
        return paymentNum;
    }

    public void setPaymentNum(String paymentNum) {
        this.paymentNum = paymentNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getTermDueDate() {
        return termDueDate;
    }

    public void setTermDueDate(String termDueDate) {
        this.termDueDate = termDueDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", customer=" + customer +
                ", products=" + products +
                ", paymentName='" + paymentName + '\'' +
                ", paymentNum='" + paymentNum + '\'' +
                ", address='" + address + '\'' +
                ", gstin='" + gstin + '\'' +
                ", billNum='" + billNum + '\'' +
                ", billDate='" + billDate + '\'' +
                ", termDueDate='" + termDueDate + '\'' +
                '}';
    }
}
