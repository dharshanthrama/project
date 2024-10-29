package com.billingapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String itemname;
    private String itemprice;
    private String description;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(long id, String itemname, String itemprice, String description) {
		super();
		this.id = id;
		this.itemname = itemname;
		this.itemprice = itemprice;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemprice() {
		return itemprice;
	}
	public void setItemprice(String itemprice) {
		this.itemprice = itemprice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemname=" + itemname + ", itemprice=" + itemprice + ", description=" + description
				+ ", getId()=" + getId() + ", getItemname()=" + getItemname() + ", getItemprice()=" + getItemprice()
				+ ", getDescription()=" + getDescription() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


}
