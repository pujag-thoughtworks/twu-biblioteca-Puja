package com.twu.biblioteca;

import com.twu.mockModels.TestInputReader;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

/**
 * Created by pujag on 6/15/17.
 */
public class AppStarterTest {

    @Test
    public void shouldWriteWelcomeMessage() {

        TestOutputWriter outputWriter=new TestOutputWriter();
        TestInputReader inputReader=new TestInputReader("1");
        AppStarter appStarter=new AppStarter(inputReader,outputWriter);
        List<String> output=outputWriter.getOutput();

        appStarter.start();
        assertEquals(appStarter.WELCOME_MESSAGE,output.get(0));
    }

    @Test
    public void shouldDisplayMenuAfterGreetingUser() {

        TestInputReader inputReader=new TestInputReader("1");
        TestOutputWriter outputWriter=new TestOutputWriter();
        TestOutputWriter testOutputWriter=new TestOutputWriter();
        AppStarter appStarter=new AppStarter(inputReader,outputWriter);
        MainMenu mainMenu=new MainMenu(inputReader,testOutputWriter);
        mainMenu.addMenuItems(new ListAvailableBooks(testOutputWriter));
        mainMenu.display();
        mainMenu.loadSelectedMenu();
        ArrayList<String> expectedOutput=new ArrayList<>();
        expectedOutput.add(appStarter.WELCOME_MESSAGE);
        expectedOutput.addAll(testOutputWriter.getOutput());

        appStarter.start();

        assertEquals(expectedOutput,outputWriter.getOutput());
    }
}
