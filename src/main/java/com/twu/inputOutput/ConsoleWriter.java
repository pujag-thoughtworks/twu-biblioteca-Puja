package com.twu.inputOutput;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Output Writer for writing outputs.
 */
public class ConsoleWriter  {

    BufferedWriter bufferedWriter;
    int writeCount=0;

    public ConsoleWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter=bufferedWriter;
    }


    public void write(String output) {
        try {
            bufferedWriter.write(output);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            writeCount++;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
