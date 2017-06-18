package com.twu.biblioteca;

import com.twu.inputOutput.ConsoleInputReader;
import com.twu.inputOutput.ConsoleOutputWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BibliotecaApp {

    public static void main(String[] args) {

        ConsoleOutputWriter consoleOutputWriter = getConsoleWriter();
        ConsoleInputReader consoleInputReader = getConsoleReader();
        LibrarySystem librarySystem = new LibrarySystem(consoleInputReader, consoleOutputWriter);
        librarySystem.start();
    }

    private static ConsoleInputReader getConsoleReader() {
        return new ConsoleInputReader(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static ConsoleOutputWriter getConsoleWriter() {
        return new ConsoleOutputWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }

}
