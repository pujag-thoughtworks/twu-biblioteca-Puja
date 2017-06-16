package com.twu.biblioteca;

import com.twu.Resources.BookStorage;
import com.twu.mockModels.TestConsoleWriter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

/**
 * Created by pujag on 6/15/17.
 */
public class AppStarterTest {

    @Test
    public void shouldWriteWelcomeMessage() {

        TestConsoleWriter consoleWriter=new TestConsoleWriter(new
                BufferedWriter(new OutputStreamWriter(System.out)));
        AppStarter appStarter=new AppStarter(consoleWriter);
        ArrayList<String> output=consoleWriter.getOutput();
        String expectedOutput="Welcome to Biblioteca";

        appStarter.start();

        assertEquals(expectedOutput,output.get(0));
    }

    @Test
    public void shouldDisplayListOfAvailableBooksAfterGreetingUser() {

        BookStorage bookList=new BookStorage();
        TestConsoleWriter consoleWriter=new TestConsoleWriter(new
                BufferedWriter(new OutputStreamWriter(System.out)));
        AppStarter appStarter=new AppStarter(consoleWriter);
        List<String> expectedOutput=new ArrayList<>();
        expectedOutput.add(AppStarter.WELCOME_MESSAGE);
        for(Book book:bookList.getBookList())
        expectedOutput.add(book.toString());

        appStarter.start();

        assertEquals(expectedOutput,consoleWriter.getOutput());
    }
}
