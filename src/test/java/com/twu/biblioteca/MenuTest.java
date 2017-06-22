package com.twu.biblioteca;

import com.twu.mockModels.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Test for menu items.
 */
public class MenuTest {

    @Test
    public void shouldDisplayMenuOptions() {

        TestOutputWriter outputWriter = new TestOutputWriter();
        TestInputReader inputReader = new TestInputReader("");
        MenuProvider menuProvider=new MenuProvider(inputReader,outputWriter);
        Menu menu = new Menu(inputReader, outputWriter,menuProvider.provideMenu());

        ExpectedOutput expectedOutput = new ExpectedOutput();


        menu.displayMenu();

        assertEquals(expectedOutput.getMenuDisplayOutput(menuProvider.provideMenu()), outputWriter.getOutput());
    }

    @Test
    public void shouldLoadAMenuItemBasedOnSelection() {

        TestOutputWriter outputWriter = new TestOutputWriter();
        TestInputReader inputReader = new TestInputReader("5");
        MenuProvider menuProvider=new MenuProvider(inputReader,outputWriter);
        Menu menu = new Menu(inputReader, outputWriter,menuProvider.provideMenu());

        menu.performSelectedAction();

        assertEquals(QuitMenuItem.QUIT_MESSAGE, outputWriter.getOutput().get(0));
    }

    @Test
    public void shouldAskForInputUnlessValidInputIsPassed() {

        TestInputReader inputReader = new TestInputReader("8\na\n5");
        TestOutputWriter outputWriter = new TestOutputWriter();
        MenuProvider menuProvider=new MenuProvider(inputReader,outputWriter);
        Menu menu = new Menu(inputReader, outputWriter,menuProvider.provideMenu());

        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add(InvalidMenuItem.OPTION_INVALID_MESSAGE);
        expectedOutput.add(InvalidMenuItem.OPTION_INVALID_MESSAGE);
        expectedOutput.add(QuitMenuItem.QUIT_MESSAGE);

        menu.performSelectedAction();

        assertEquals(expectedOutput, outputWriter.getOutput());
    }

    @Test
    public void userShouldBeAbleToSelectMenuOptionUnlessHeSelectsQuit() {

        TestInputReader inputReader = new TestInputReader("1\n5");
        TestOutputWriter outputWriter = new TestOutputWriter();
        MenuProvider menuProvider=new MenuProvider(inputReader,outputWriter);
        Menu menu = new Menu(inputReader, outputWriter,menuProvider.provideMenu());

        ExpectedOutput preTestedOutput = new ExpectedOutput();
        List<String> requiredOutput = new ArrayList<>(preTestedOutput.getListBooksOutput());
        requiredOutput.addAll(preTestedOutput.getMenuDisplayOutput(menuProvider.provideMenu()));
        requiredOutput.add(QuitMenuItem.QUIT_MESSAGE);

        menu.performSelectedAction();

        assertEquals(requiredOutput, outputWriter.getOutput());

    }

    @Test
    public void LoggingOutShouldQuitFromMenu() {
        TestInputReader inputReader = new TestInputReader("7");
        TestOutputWriter outputWriter = new TestOutputWriter();
        Customer customer=new UserDirectory().getCustomer("CUS-0001");

        MenuProvider menuProvider=new MenuProvider(inputReader,outputWriter);
        Menu menu = new Menu(inputReader, outputWriter,menuProvider.provideMenu(customer));
        String[] expectedOutput={LogOutMenuItem.LOG_OUT_MESSAGE,};

        menu.performSelectedAction();

        assertEquals(Arrays.asList(expectedOutput),outputWriter.getOutput());

    }
    

}
