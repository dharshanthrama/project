package com.billingapplication.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class customer {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private String id;

	@Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phonenumber;

    @Column(unique = true, nullable = false)
    private String customerid;
    
    private String address;
    private String balance;
    private String message;
    

	public customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public customer(String id, String name, String email, String phonenumber, String customerid, String address,
			String balance, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.customerid = customerid;
		this.address = address;
		this.balance = balance;
		this.message = message;
	}
	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "customer [id=" + id + ", name=" + name + ", email=" + email + ", phonenumber=" + phonenumber
				+ ", customerid=" + customerid + ", address=" + address + ", balance=" + balance + ", message="
				+ message + ", getId()=" + getId() + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getPhonenumber()=" + getPhonenumber() + ", getCustomerid()=" + getCustomerid() + ", getAddress()="
				+ getAddress() + ", getBalance()=" + getBalance() + ", getMessage()=" + getMessage() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
    
}