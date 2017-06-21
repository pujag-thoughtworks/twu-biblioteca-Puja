package com.twu.biblioteca;

import com.twu.resources.RegisteredUsers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Maps users with library number.
 * Identifies if a user is a customer or a librarian.
 */
public class UserDirectory {

    private static String LIBRARIAN_IDENTIFIER="LIB";

    Map<String,Customer> customerDirectory;

    UserDirectory() {
        RegisteredUsers registeredUsers=new RegisteredUsers();
        List<Customer> userList=registeredUsers.getCustomers();
        customerDirectory =new HashMap<>();
        for(Customer customer:userList) {
            customerDirectory.put(customer.getLibraryNo(),customer);
        }

    }

    public Customer getCustomer(String libraryNo) {
        return customerDirectory.getOrDefault(libraryNo,null);
    }

    public boolean isLibrarian(String libraryNo) {
        return (libraryNo.contains(LIBRARIAN_IDENTIFIER));
    }

    public boolean contains(String libraryNo) {
        return customerDirectory.containsKey(libraryNo);
    }
}
