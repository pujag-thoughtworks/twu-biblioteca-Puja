package com.twu.biblioteca;

import com.twu.mockModels.TestInputReader;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests menu provider.
 */
public class MenuProviderTest {

//TODO: Implemnet method for getting specific menu names for generic menuItems

    @Test
    public void shouldProvideDefaultMenu() {

        MenuProvider menuProvider=new MenuProvider(new TestInputReader(""),new TestOutputWriter());
        String[] expectedMenuNames= {ListMenuItem.MENU_NAME,ListMenuItem.MENU_NAME,Constants.CUSTOMER_LOGIN_MENU_NAME,
                Constants.LIBRARIAN_LOGIN_MENU_NAME, QuitMenuItem.MENU_NAME};

        List<MenuItem> output=menuProvider.provideMenu();
        List<String> menuNamesOfItemsInOutput=new ArrayList<>();
        for(MenuItem menuItem:output)
            menuNamesOfItemsInOutput.add(menuItem.getMenuName());

        assertEquals(Arrays.asList(expectedMenuNames),menuNamesOfItemsInOutput);

    }

    @Test
    public void shouldProvideCustomerSpecificMenu() {

        MenuProvider menuProvider=new MenuProvider(new TestInputReader(""),new TestOutputWriter());
        String[] expectedMenuNames= {Constants.VIEW_PROFILE_MENU_NAME,ListMenuItem.MENU_NAME,ListMenuItem.MENU_NAME,CheckOutMenuItem.MENU_NAME,
                CheckOutMenuItem.MENU_NAME,ReturnBookMenuItem.MENU_NAME,Constants.LOG_OUT_MENU_NAME };

        List<MenuItem> output=menuProvider.provideMenu(new Customer());
        List<String> menuNamesOfItemsInOutput=new ArrayList<>();
        for(MenuItem menuItem:output) {
            menuNamesOfItemsInOutput.add(menuItem.getMenuName()); }

        assertEquals(Arrays.asList(expectedMenuNames),menuNamesOfItemsInOutput);

    }

    @Test
    public void shouldProvideLibrarianSpecificMenu() {

        MenuProvider menuProvider=new MenuProvider(new TestInputReader(""),new TestOutputWriter());
        String[] expectedMenuNames={Constants.CHECKED_OUT_DETAILS_MENU_NAME,Constants.CHECKED_OUT_DETAILS_MENU_NAME,
                Constants.LOG_OUT_MENU_NAME};

        List<MenuItem> output=menuProvider.provideMenu(new Librarian());
        List<String> menuNamesOfItemsInOutput=new ArrayList<>();
        for(MenuItem menuItem:output)
            menuNamesOfItemsInOutput.add(menuItem.getMenuName());

        assertEquals(Arrays.asList(expectedMenuNames),menuNamesOfItemsInOutput);

    }

}
