package com.twu.biblioteca;

import com.twu.mockModels.TestInputReader;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;


/**
 * Tests customer login menu item.
 */
public class CustomerLoginMenuItemTest {



    @Test
    public void shouldPerformSelectedActionFromCustomerSpecificMenu() {

        TestInputReader testInputReader=new TestInputReader("CUS-0001\npassword\n7");
        TestOutputWriter testOutputWriter=new TestOutputWriter();
        CustomerLoginMenuItem customerLoginMenu=new CustomerLoginMenuItem(testInputReader,testOutputWriter,
                new MenuProvider(testInputReader,testOutputWriter));

        customerLoginMenu.performAction();
        List<String> displayOutput=testOutputWriter.getOutput();

        assertTrue(displayOutput.contains(LogOutMenuItem.LOG_OUT_MESSAGE));
    }
}
