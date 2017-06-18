package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * Menu-Item to facilitate return of Book.
 */
public class ReturnBookMenuItem implements MenuItem {

    static final String MESSAGE_TO_REQUEST_RETURN = "Please enter the name of book you want to return : ";
    static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid book to return";
    static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the book";
    public static final String MENU_NAME = "Return book\n";

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Librarian librarian;

    ReturnBookMenuItem(InputReader inputReader, OutputWriter outputWriter, Librarian librarian) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.librarian = librarian;
    }

    @Override
    public void performAction() {
        outputWriter.write(MESSAGE_TO_REQUEST_RETURN);
        String bookName = inputReader.read();
        if (!librarian.doesBookBelongToLibrary(bookName)) {
            outputWriter.write(UNSUCCESSFUL_RETURN_MESSAGE);
            return;
        }
        librarian.returnBook(bookName);
        outputWriter.write(SUCCESSFUL_RETURN_MESSAGE);

    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }
}
