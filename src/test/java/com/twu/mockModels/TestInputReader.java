package com.twu.mockModels;

import com.twu.inputOutput.InputReader;

/**
 * Created by pujag on 6/16/17.
 */
public class TestInputReader implements InputReader {

    String[] input;
    int noOfReads=0;

    public TestInputReader(String inputString) {
        input=inputString.split("\n");

    }

    @Override
    public String read() {
        String givenInput= input[noOfReads];
        noOfReads++;
        return givenInput;
    }

    public int getNoOfReads() {
        return noOfReads;
    }
}
