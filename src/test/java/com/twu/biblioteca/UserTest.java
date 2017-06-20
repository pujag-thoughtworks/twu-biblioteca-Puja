package com.twu.biblioteca;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by pujag on 6/20/17.
 */
public class UserTest {

    /* TODO: implement constraints on library no
    @Test
    public void libraryNumberShouldBeInGivenFormat() {
        User customer=new User("Ram","ram@gmail.com","New Delhi","")
    } */

    @Test
    public void shouldGetPassword() {
        User user =new User("Ram","ram@gmail.com","New Delhi","CUS-0001","password");
        String output= user.getLibraryNo();
        assertEquals("password",output);

    }

    @Test
    public void shouldGetUserProfile() {
        User user =new User("Ram","ram@gmail.com","New Delhi","CUS-0001","password");
        String[] expectedOutput={"Ram","ram@gmail.com","New Delhi","CUS-0001"};

        String[] actualOutput= user.getProfile();

        assertTrue(Arrays.equals(expectedOutput,actualOutput));
    }

    @Test
    public void twoUsersWithSameDetailsAreSame() {
        User user1 =new User("Ram","ram@gmail.com","New Delhi","CUS-0001","password");
        User user2=new User("Ram","ram@gmail.com","New Delhi","CUS-0001","password");
        assertEquals(user1,user2);
    }

}
