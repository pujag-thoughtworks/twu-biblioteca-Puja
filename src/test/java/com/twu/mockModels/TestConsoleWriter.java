package com.twu.mockModels;

import com.twu.inputOutput.ConsoleWriter;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> getOutput() {
        return output;
    }
}
