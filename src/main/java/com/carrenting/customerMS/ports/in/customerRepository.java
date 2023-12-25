package com.carrenting.customerMS.ports.in;


import com.carrenting.customerMS.ports.data.Customer;

// zur Datenbank
public interface customerRepository {

    void addCustomer (Customer customer);


    void deleteCustomer(Customer customer);

    


}
