package com.twu.inputOutput;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Output Writer for writing outputs.
 */
public class consoleWriter implements outputWriter {

    BufferedWriter bufferedWriter;

    consoleWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter=bufferedWriter;
    }

    @Override
    public void write(String output) {
        try {
            bufferedWriter.write(output);
            bufferedWriter.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
