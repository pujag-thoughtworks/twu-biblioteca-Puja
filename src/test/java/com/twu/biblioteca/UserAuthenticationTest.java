package com.twu.biblioteca;

import com.twu.buildingBlocks.Customer;
import com.twu.buildingBlocks.User;
import com.twu.mockModels.TestInputReader;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by pujag on 6/23/17.
 */
public class UserAuthenticationTest {
    @Test
    public void shouldAuthenticateUser() {
        TestInputReader testInputReader=new TestInputReader("CUS-0001\npassword");
        TestOutputWriter testOutputWriter=new TestOutputWriter();
        UserAuthentication userAuthentication=new UserAuthentication(testInputReader,testOutputWriter);

        User user =userAuthentication.authenticateUser(Customer.USER_TYPE);

        assertTrue(testOutputWriter.getOutput().contains(UserAuthentication.SUCCESSFUL_LOGIN_MESSAGE));

    }
}
