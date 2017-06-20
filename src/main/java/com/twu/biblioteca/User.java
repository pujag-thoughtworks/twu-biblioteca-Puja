package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pujag on 6/20/17.
 */
public class User {

    private String name;
    private String email;
    private String address;
    private String libraryNo;
    private String password;

    public User(String name, String email, String address, String libraryNo, String password) {

        this.name = name;
        this.email = email;
        this.address = address;
        this.libraryNo = libraryNo;
        this.password = password;
    }

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
        User user=(User) obj;
        if(user==null)
            return false;
        return(name.equals(user.name) && email.equals(user.email) && address.equals(user.address)
        && libraryNo.equals(user.libraryNo) && password.equals(user.password));
    }
}
