package com.twu.mockModels;

import com.twu.biblioteca.ListBooksMenuItem;
import com.twu.inputOutput.OutputWriter;

/**
 * Mocks the behaviour of ListBooksMenuItem.
 * Created for passing dependency during testing
 */
public class TestListBooksMenuItem extends ListBooksMenuItem {
    private int countOfPerformActionCalls;

    public TestListBooksMenuItem(OutputWriter outputWriter) {
        super(outputWriter);
    }

    public void performAction() {
        countOfPerformActionCalls++;
    }

    public int getCountOfPerformActionCalls() {
        return countOfPerformActionCalls;
    }

}
