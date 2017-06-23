package com.twu.biblioteca;

import com.twu.buildingBlocks.Customer;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Tests viewProfileMenuItem.
 */
public class ViewProfileMenuItemTest {

    @Test
    public void shouldDisplayCustomerProfile() {
        TestOutputWriter outputWriter = new TestOutputWriter();
        Customer loggedInCustomer = new UserDirectory().getCustomer("CUS-0002");
        ViewProfileMenuItem viewProfileMenuItem = new ViewProfileMenuItem(outputWriter, loggedInCustomer);

        viewProfileMenuItem.performAction();

        assertEquals(Arrays.asList(loggedInCustomer.getProfile()), outputWriter.getOutput());
    }
}
