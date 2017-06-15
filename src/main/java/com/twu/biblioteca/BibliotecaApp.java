package com.twu.biblioteca;

import com.twu.inputOutput.ConsoleWriter;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BibliotecaApp {


    public static void main(String[] args) {
        ConsoleWriter consoleWriter=new ConsoleWriter((new BufferedWriter(new
                OutputStreamWriter(System.out))));
        AppStarter appStarter=new AppStarter(consoleWriter);
        appStarter.start();



    }
}
