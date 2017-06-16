package com.twu.mockModels;

import com.twu.inputOutput.ConsoleOutputWriter;
import com.twu.inputOutput.OutputWriter;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Mocks behaviour of consoleOutputWriter
 */
public class TestOutputWriter implements OutputWriter {

    ArrayList<String> output;

    public TestOutputWriter() {
        output = new ArrayList<>();
    }

    @Override
    public void write(String str) {
        output.add(str);
    }

    public List<String> getOutput() {
        return output;
    }
}
