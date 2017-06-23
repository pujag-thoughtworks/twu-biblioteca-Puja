package com.twu.biblioteca;

import com.twu.buildingBlocks.Customer;
import com.twu.buildingBlocks.User;
import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * Authenticates user
 */
public class UserAuthentication {
    static final String LIBRARY_NO_REQUEST = "Please enter your library number:";
    static final String PASSWORD_REQUEST = "Please enter your password:";
    static final String INVALID_USERNAME = "Username invalid!";
    static final String INCORRECT_PASSWORD = "Entered password is incorrect!";
    static final String SUCCESSFUL_LOGIN_MESSAGE = "Successfully,logged in";


    InputReader inputReader;
    OutputWriter outputWriter;
    UserDirectory userDirectory;

    UserAuthentication(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.userDirectory = new UserDirectory();
    }

    private User getRequiredUser(String userType, String libraryNo) {
        if (userType == Customer.USER_TYPE)
            return userDirectory.getCustomer(libraryNo);
        return userDirectory.getLibrarian(libraryNo);
    }

    User authenticateUser(String userType) {
        outputWriter.write(LIBRARY_NO_REQUEST);
        String libraryNo = inputReader.read();
        User loggedInUser = getRequiredUser(userType, libraryNo);
        if (loggedInUser == null) {
            outputWriter.write(INVALID_USERNAME);
            return null;
        }
        outputWriter.write(PASSWORD_REQUEST);
        String providedPwd = inputReader.read();
        if (!providedPwd.equals(loggedInUser.getPassword())) {
            outputWriter.write(INCORRECT_PASSWORD);
            return null;
        }
        outputWriter.write(SUCCESSFUL_LOGIN_MESSAGE);
        return loggedInUser;

    }

}
