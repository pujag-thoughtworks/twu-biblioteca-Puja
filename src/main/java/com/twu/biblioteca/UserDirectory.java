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

    Map<String, Customer> customerDirectory;
    Map<String, Librarian> librarianDirectory;

    UserDirectory() {
        RegisteredUsers registeredUsers = new RegisteredUsers();
        List<Customer> userList = registeredUsers.getCustomers();
        customerDirectory = new HashMap<>();
        for (Customer customer : userList) {
            customerDirectory.put(customer.getLibraryNo(), customer);
        }
        librarianDirectory = new HashMap<>();
        librarianDirectory.put("LIB-0001", new Librarian("Jagriti", "LIB-0001", "password"));
        librarianDirectory.put("LIB-0002",new Librarian("Naman","LIB-0002","password"));

    }

    public Customer getCustomer(String libraryNo) {
        return customerDirectory.getOrDefault(libraryNo, null);
    }

    public Librarian getLibrarian(String libraryNo) {
        return librarianDirectory.getOrDefault(libraryNo,null);
    }




}
