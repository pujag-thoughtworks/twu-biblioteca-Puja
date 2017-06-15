package com.twu.biblioteca;

import com.twu.mockModels.TestConsoleWriter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

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
        appStarter.start("Hello", new ArrayList<Book>());
        ArrayList<String> output=consoleWriter.getOutput();
        String expectedOutput="Hello";

        assertEquals(expectedOutput,output.get(0));
    }

    @Test
    public void shouldDisplayListOfAvailableBooksAfterGreetingUser() {

        ArrayList<Book> bookList=new ArrayList<>();
        Book book1=new Book ("Harry Potter","J.K Rowling",2000);
        Book book2=new Book("Notebook","Nicholas Spark",1999);
        bookList.add(book1 );
        bookList.add(book2);
        TestConsoleWriter consoleWriter=new TestConsoleWriter(new
                BufferedWriter(new OutputStreamWriter(System.out)));
        AppStarter appStarter=new AppStarter(consoleWriter);
        appStarter.start("Hello",bookList);
        ArrayList<String> expectedOutput=new ArrayList<>();
        expectedOutput.add("Hello");
        expectedOutput.add(book1.toString());
        expectedOutput.add(book2.toString());

        assertEquals(expectedOutput,consoleWriter.getOutput());
    }
}
