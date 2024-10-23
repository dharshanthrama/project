package com.billingapplication.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @EqualsAndHashCode.Exclude
    private Set<Product> products = new HashSet<>();

    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
    @JsonBackReference(value = "order-payment")
    private Payment payment;

    @Column(nullable = false, unique = true)
    private String orderNumber; // Unique 4 to 6 digit order number

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, Date orderDate, Double totalAmount, String userEmail, Set<Product> products, Payment payment,
			String orderNumber) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.userEmail = userEmail;
		this.products = products;
		this.payment = payment;
		this.orderNumber = orderNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", userEmail="
				+ userEmail + ", products=" + products + ", payment=" + payment + ", orderNumber=" + orderNumber
				+ ", getId()=" + getId() + ", getOrderDate()=" + getOrderDate() + ", getTotalAmount()="
				+ getTotalAmount() + ", getUserEmail()=" + getUserEmail() + ", getProducts()=" + getProducts()
				+ ", getPayment()=" + getPayment() + ", getOrderNumber()=" + getOrderNumber() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
    
}
