package com.twu.biblioteca;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by pujag on 6/20/17.
 */
public class CustomerTest {


    @Test (expected = IllegalArgumentException.class)
    public void libraryNumberShouldBeInFormat() {
        Customer customer=new Customer("Ram","ram@gmail.com","New Delhi","kkkkkkkk","pwd");
    }

    @Test
    public void shouldGetPassword() {
        Customer customer =new Customer("Ram","ram@gmail.com","New Delhi","CUS-0001","password");
        String output= customer.getPassword();
        assertEquals("password",output);

    }

    @Test
    public void shouldGetLibraryNo() {
        Customer customer =new Customer("Ram","ram@gmail.com","New Delhi","CUS-0001","password");
        String output= customer.getLibraryNo();
        assertEquals("CUS-0001",output);

    }

    @Test
    public void shouldGetCustomerProfile() {
        Customer customer =new Customer("Ram","ram@gmail.com","New Delhi","CUS-0001","password");
        String[] expectedOutput={"Ram","ram@gmail.com","New Delhi","CUS-0001"};

        String[] actualOutput= customer.getProfile();

        assertTrue(Arrays.equals(expectedOutput,actualOutput));
    }

    @Test
    public void shouldHaveUniqueSetOfCustomerDetail() {
        Customer user1 =new Customer("Ram","ram@gmail.com","New Delhi","CUS-0001","password");
        Customer user2=new Customer("Ram","ram@gmail.com","New Delhi","CUS-0001","password");
        assertEquals(user1,user2);
    }

}
