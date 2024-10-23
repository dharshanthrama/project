package com.billingapplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor 
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    
    @Id
    @Column(name = "productid", nullable = false, unique = true)
    @JsonProperty("Product ID")
    private String productid;

    private String name;
    private String category;
    private String price;
    private String quantity;
    private String image;
    private String description;

    @Column(name = "user_email", nullable = false)
    @JsonProperty("userEmail")
    private String userEmail;

    // Constructor without userEmail (if needed)
    public Product(String productid, String name, String category, String price, String quantity, String image, String description) {
        this.productid = productid;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
    }

    // This method can be kept to generate a unique product ID
    public void generateProductId() {
        if (this.productid == null || this.productid.isEmpty()) {
            this.productid = String.format("%06d", (int) (Math.random() * 1000000));
        }
    }

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productid, String name, String category, String price, String quantity, String image,
			String description, String userEmail) {
		super();
		this.productid = productid;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.description = description;
		this.userEmail = userEmail;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", quantity=" + quantity + ", image=" + image + ", description=" + description + ", userEmail="
				+ userEmail + ", getProductid()=" + getProductid() + ", getName()=" + getName() + ", getCategory()="
				+ getCategory() + ", getPrice()=" + getPrice() + ", getQuantity()=" + getQuantity() + ", getImage()="
				+ getImage() + ", getDescription()=" + getDescription() + ", getUserEmail()=" + getUserEmail()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
    
    
}
