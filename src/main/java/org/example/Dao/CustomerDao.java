package org.example.Dao;

import org.example.models.Customer;

import java.util.List;


public interface CustomerDao {
    Customer createCustomer(Customer newCustomer);

    Customer getCustomerById(int customerId);

    public List<Customer> getAllCustomerOrders();


}
