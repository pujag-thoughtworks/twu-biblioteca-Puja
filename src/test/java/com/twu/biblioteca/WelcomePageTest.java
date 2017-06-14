package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the welcome page
 */
public class WelcomePageTest {

    @Test
    public  void ShouldGetExpectedWelcomeMessage() {
        WelcomePage welcomePage=new WelcomePage("Hello");
        assertEquals("Hello",welcomePage.getWelcomeMessage());
    }


}
