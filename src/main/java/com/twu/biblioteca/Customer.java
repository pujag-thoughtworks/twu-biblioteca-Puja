package com.twu.biblioteca;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pujag on 6/21/17.
 */
public class Customer implements User {
    static final String USER_TYPE="Customer";

    private String name;
    private String email;
    private String address;
    private String libraryNo;
    private String password;

    public Customer(String name, String email, String address, String libraryNo, String password) {
        if(!isLibraryNoInFormat(libraryNo))
            throw new IllegalArgumentException();
        this.name = name;
        this.email = email;
        this.address = address;
        this.libraryNo = libraryNo;
        this.password = password;
    }

    private boolean isLibraryNoInFormat(String libraryNo) {
    Pattern requiredFormat = Pattern.compile("\\w{3}\\-\\w{4}");
    Matcher matcher = requiredFormat.matcher(libraryNo);
        return matcher.matches(); }

    public String getLibraryNo() {
        return libraryNo;
    }

    public String getPassword() {
        return password;
    }

    String[] getProfile() {
        return new String[]{ name,email,address,libraryNo,};
    }

    public boolean equals(Object obj) {
        Customer customer=(Customer) obj;
        if(customer==null)
            return false;
        return(name.equals(customer.name) && email.equals(customer.email) && address.equals(customer.address)
                && libraryNo.equals(customer.libraryNo) && password.equals(customer.password));
    }
}

