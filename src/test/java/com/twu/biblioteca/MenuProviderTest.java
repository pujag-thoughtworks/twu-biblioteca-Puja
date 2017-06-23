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
        String[] expectedMenuNames= {ListMenuItem.MENU_NAME + " Books",ListMenuItem.MENU_NAME + " Movies",CustomerLoginMenuItem.MENU_NAME,
                LibrarianLoginMenuItem.MENU_NAME, QuitMenuItem.MENU_NAME};

        List<MenuItem> output=menuProvider.provideMenu();
        List<String> menuNamesOfItemsInOutput=new ArrayList<>();
        for(MenuItem menuItem:output)
            menuNamesOfItemsInOutput.add(menuItem.getMenuName());

        assertEquals(Arrays.asList(expectedMenuNames),menuNamesOfItemsInOutput);

    }

    @Test
    public void shouldProvideCustomerSpecificMenu() {

        MenuProvider menuProvider=new MenuProvider(new TestInputReader(""),new TestOutputWriter());
        String[] expectedMenuNames= {ViewProfileMenuItem.MENU_NAME,ListMenuItem.MENU_NAME +" Books",ListMenuItem.MENU_NAME +" Movies",CheckOutMenuItem.MENU_NAME + " Book",
                CheckOutMenuItem.MENU_NAME +" Movie",ReturnBookMenuItem.MENU_NAME,LogOutMenuItem.MENU_NAME};

        List<MenuItem> output=menuProvider.provideMenu(new Customer("Ram","ab@gmail.com","Punjab","CUS-0008","password"));
        List<String> menuNamesOfItemsInOutput=new ArrayList<>();
        for(MenuItem menuItem:output) {
            menuNamesOfItemsInOutput.add(menuItem.getMenuName()); }

        assertEquals(Arrays.asList(expectedMenuNames),menuNamesOfItemsInOutput);

    }

    @Test
    public void shouldProvideLibrarianSpecificMenu() {

        MenuProvider menuProvider=new MenuProvider(new TestInputReader(""),new TestOutputWriter());
        String[] expectedMenuNames={CheckedOutDetailsMenuItem.MENU_NAME + " Books",CheckedOutDetailsMenuItem.MENU_NAME +" Movies",
                LogOutMenuItem.MENU_NAME};

        List<MenuItem> output=menuProvider.provideMenu(new Librarian("Jagriti","LIB-0001","password"));
        List<String> menuNamesOfItemsInOutput=new ArrayList<>();
        for(MenuItem menuItem:output)
            menuNamesOfItemsInOutput.add(menuItem.getMenuName());

        assertEquals(Arrays.asList(expectedMenuNames),menuNamesOfItemsInOutput);

    }

}
