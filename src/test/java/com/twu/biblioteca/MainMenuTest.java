package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

/**
 * Test for menu items.
 */
public class MainMenuTest {
    @Test
    public void menuItemsShouldHaveListAvailableBooks(){

        ListAvailableBooks listAvailableBooks=new ListAvailableBooks();
        MainMenu menu=new MainMenu( listAvailableBooks);
        ArrayList<MenuItem> menuItem =menu.getMenuItems();

        assertTrue(menuItem.contains(listAvailableBooks));
    }
}
