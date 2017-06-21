package com.twu.biblioteca;

import com.twu.resources.RegisteredUsers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests user directory.
 */
public class UserDirectoryTest {

    @Test
    public void shouldAssociateUserWithLibrary() {

        UserDirectory userDirectory=new UserDirectory();
        RegisteredUsers registeredUsers=new RegisteredUsers();
        User expectedUser=registeredUsers.getCustomers().get(0);

        User user=userDirectory.getCustomer("CUS-0001");
        assertEquals(expectedUser,user);
    }

    @Test
    public void shouldKnowIfAUserIsLibrarian() {
        UserDirectory userDirectory=new UserDirectory();
        RegisteredUsers registeredUsers=new RegisteredUsers();
        User librarian=registeredUsers.getCustomers().get(4);
        User customer=registeredUsers.getCustomers().get(0);

        assertTrue(userDirectory.isLibrarian(librarian.getLibraryNo()));
        assertFalse(userDirectory.isLibrarian(customer.getLibraryNo()));
    }

}
