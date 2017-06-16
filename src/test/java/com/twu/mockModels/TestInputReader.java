package com.twu.mockModels;

import com.twu.inputOutput.InputReader;

/**
 * Created by pujag on 6/16/17.
 */
public class TestInputReader implements InputReader {

    String inputString;

    public TestInputReader(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String read() {
        return inputString;
    }

}
