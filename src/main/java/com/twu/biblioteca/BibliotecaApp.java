package com.twu.biblioteca;

import com.twu.Resources.BookList;
import com.twu.inputOutput.ConsoleWriter;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BibliotecaApp {


    public static void main(String[] args) {
        ConsoleWriter consoleWriter=new ConsoleWriter((new BufferedWriter(new
                OutputStreamWriter(System.out))));
        BookList bookList=new BookList();
        AppStarter appStarter=new AppStarter(consoleWriter);
        appStarter.start("Welcome",bookList.getBookList());


    }
}
