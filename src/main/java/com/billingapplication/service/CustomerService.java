package com.billingapplication.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.billingapplication.model.customer;
import com.billingapplication.repo.customerRepo;

@Service
public class CustomerService {

	@Autowired
	private customerRepo repo;
	
	private String generateTruncatedUUID() {
        UUID uuid = UUID.randomUUID();
      return uuid.toString().substring(0, 8); 
    }

    public customer saveRecords(customer cs) {
        if (cs.getId() == null) {
            cs.setId(generateTruncatedUUID()); 
        }
        return repo.save(cs);
    }
    public List<customer> saveAllRecords(List<customer> customers) {
        for (customer cs : customers) {
            if (cs.getId() == null) {
                cs.setId(generateTruncatedUUID()); 
            }
        }
        return repo.saveAll(customers);
    }
	
	public List<customer> getrecords(){
		return repo.findAll();
	}
	
	public customer getCustomerById(String customerid) {
        return repo.findBycustomerid(customerid); 
    }

    public String deletecustomer(String id) { 
        repo.deleteById(id);
        return "removed";
    }

    public customer updateCustomer(customer customer) {
        customer editRec = repo.findById(customer.getId()).orElse(null); 
        if (editRec != null) {
            editRec.setName(customer.getName());
            editRec.setAddress(customer.getAddress());
            editRec.setEmail(customer.getEmail());
            editRec.setBalance(customer.getBalance());
            editRec.setPhonenumber(customer.getPhonenumber());
            editRec.setMessage(customer.getMessage());
            return repo.save(editRec);
        }
        return null; 
    }
}