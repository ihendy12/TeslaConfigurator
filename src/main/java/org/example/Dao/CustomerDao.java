package org.example.Dao;

import org.example.models.Customer;


public interface CustomerDao {
    Customer createCustomer(Customer newCustomer);

    Customer getCustomerById(int customerId);


}
