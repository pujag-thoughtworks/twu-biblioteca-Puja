package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by pujag on 6/15/17.
 */
public class AppStarterTest {

    @Test
    public void shouldWriteWelcomeMessage() {
        TestWelcomePage welcomePage=new TestWelcomePage("Hello");
        AppStarter appStarter=new AppStarter(welcomePage);
        appStarter.start();

        assertTrue(welcomePage.isWelcomeMessageWritten());
    }
}
