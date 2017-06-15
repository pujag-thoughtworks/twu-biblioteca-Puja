package com.twu.biblioteca;

import com.twu.inputOutput.ConsoleWriter;

import java.io.BufferedWriter;
import java.util.ArrayList;

/**
 * Created by pujag on 6/15/17.
 */
public class TestConsoleWriter extends ConsoleWriter {

    ArrayList<String> output;

    public TestConsoleWriter(BufferedWriter bufferedWriter) {
        super(bufferedWriter);
        output=new ArrayList<>();
    }

    @Override
    public void write(String str) {
        output.add(str);
    }

    public ArrayList<String> getOutput() {
        return output;
    }
}
