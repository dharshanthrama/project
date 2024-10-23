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
public class Cashbook {

    @Id
    @Column(name = "cashbook_id", nullable = false, unique = true)
    @JsonProperty("cashbookId")
    private String cashbookId;

    private String name;
    private String amount;
    private String description;
    private String date;

    @Column(name = "in_out")
    @JsonProperty("inOut")
    private String inOut;

    @Column(name = "user_email", nullable = false) 
    @JsonProperty("userEmail")
    private String userEmail;

    // New field for the 6-digit code
    @Column(name = "code", nullable = false, unique = true)
    @JsonProperty("code")
    private String code;  // New property to store the generated code

    public void adjustBalance(MasterBalance masterBalance) {
        double amountValue = Double.parseDouble(this.amount);
        if ("IN".equalsIgnoreCase(this.inOut)) {
            masterBalance.addBalance(amountValue);
        } else if ("OUT".equalsIgnoreCase(this.inOut)) {
            masterBalance.deductBalance(amountValue);
        } else {
            throw new IllegalArgumentException("Invalid value for in/out: " + this.inOut);
        }
    }

    // Getters and Setters for the new field
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // Other existing constructors, getters, and setters can remain unchanged
    public Cashbook() {
        super();
    }

    public Cashbook(String cashbookId, String name, String amount, String description, String date, String inOut,
                    String userEmail) {
        super();
        this.cashbookId = cashbookId;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.inOut = inOut;
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "Cashbook [cashbookId=" + cashbookId + ", name=" + name + ", amount=" + amount + ", description="
                + description + ", date=" + date + ", inOut=" + inOut + ", userEmail=" + userEmail + ", code=" + code
                + "]";
    }

	public String getCashbookId() {
		return cashbookId;
	}

	public void setCashbookId(String cashbookId) {
		this.cashbookId = cashbookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInOut() {
		return inOut;
	}

	public void setInOut(String inOut) {
		this.inOut = inOut;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
    
    
}
