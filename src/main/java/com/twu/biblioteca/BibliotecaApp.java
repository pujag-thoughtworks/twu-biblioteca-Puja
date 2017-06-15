package com.twu.biblioteca;

import com.twu.inputOutput.ConsoleWriter;

import java.io.BufferedWriter;

public class BibliotecaApp {

    public static void main(String[] args) {
        AppStarter appStarter=new AppStarter(new WelcomePage("Hello"));
        appStarter.start();
    }
}
