package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * MenuItem to facilitate check-out of books.
 */
public class CheckOutBookMenuItem implements MenuItem {

    static final String MESSAGE_TO_REQUEST_CHECKOUT = "Please enter the name of book you want to check out : ";
    static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "That book is not available";
    static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book :";
    private static final String MENU_NAME = "Check out book\n";

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Librarian librarian;

    CheckOutBookMenuItem(InputReader inputReader, OutputWriter outputWriter, Librarian librarian) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.librarian = librarian;
    }

    @Override
    public void performAction() {

        outputWriter.write(MESSAGE_TO_REQUEST_CHECKOUT);
        String bookName = inputReader.read();
        if (!librarian.isBookAvailableForCheckout(bookName)) {
            outputWriter.write(UNSUCCESSFUL_CHECKOUT_MESSAGE);
            return;
        }
        librarian.checkoutBook(bookName);
        outputWriter.write(SUCCESSFUL_CHECKOUT_MESSAGE);

    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }
}
