package com.billingapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Item item;

    private String quantity;
    private LocalDate date;
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expense(long id, Category category, Item item, String quantity, LocalDate date) {
		super();
		this.id = id;
		this.category = category;
		this.item = item;
		this.quantity = quantity;
		this.date = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Expense [id=" + id + ", category=" + category + ", item=" + item + ", quantity=" + quantity + ", date="
				+ date + ", getId()=" + getId() + ", getCategory()=" + getCategory() + ", getItem()=" + getItem()
				+ ", getQuantity()=" + getQuantity() + ", getDate()=" + getDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

    
}
