package com.twu.resources;

import com.twu.buildingBlocks.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * List of pre registered users.
 */
public class RegisteredUsers {

    private List<Customer> registeredCustomer;

    public RegisteredUsers() {
        registeredCustomer=new ArrayList<>();
        registeredCustomer.add(new Customer("Karan","karan@gmail.com","Kolkata","CUS-0001","password"));
        registeredCustomer.add(new Customer("Smriti","smriti@yahoo.com","Pune","CUS-0002","password"));
        registeredCustomer.add(new Customer("Mohan","mohan@gmail.com","Goa","CUS-0003","password"));
        registeredCustomer.add(new Customer("Pragya","pragya@gmail.com","Gangtok","CUS-0004","password"));
        registeredCustomer.add(new Customer("Jagriti","Jagriti","New Delhi","LIB-0001","password"));
    }

   public List<Customer> getCustomers() {
        return registeredCustomer;
    }
}
