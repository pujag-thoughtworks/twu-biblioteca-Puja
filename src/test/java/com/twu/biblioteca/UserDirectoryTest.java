package com.twu.biblioteca;

import com.twu.buildingBlocks.User;
import com.twu.resources.RegisteredUsers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests user directory.
 */
public class UserDirectoryTest {

    @Test
    public void shouldAssociateUserWithLibraryNo() {

        UserDirectory userDirectory=new UserDirectory();
        RegisteredUsers registeredUsers=new RegisteredUsers();
        User expectedUser=registeredUsers.getCustomers().get(0);

        User user=userDirectory.getCustomer("CUS-0001");
        assertEquals(expectedUser,user);
    }


}
