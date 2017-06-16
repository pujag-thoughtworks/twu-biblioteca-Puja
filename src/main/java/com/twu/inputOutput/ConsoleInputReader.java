package com.twu.inputOutput;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Reads Input From the user
 */
public class ConsoleInputReader implements InputReader{

    private BufferedReader bufferedReader;

    public ConsoleInputReader(BufferedReader bufferedReader) {

        this.bufferedReader = bufferedReader;
    }


    public String read(){
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
