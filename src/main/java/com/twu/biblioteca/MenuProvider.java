package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;
import com.twu.resources.BookStorage;
import com.twu.resources.MovieStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides list of menuItems.
 */
public class MenuProvider {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Inventory<Book> bookInventory;
    private Inventory<Movie> movieInventory;
    ListMenuItem<Book> listBookMenuItem;
    ListMenuItem<Movie>listMovieMenuItem;
    ;
    LogOutMenuItem logOutMenuItem;

    MenuProvider(InputReader inputReader, OutputWriter outputWriter) {

        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        bookInventory=new Inventory<>(new BookStorage().getBookList());
        movieInventory=new Inventory<>(new MovieStorage().getMovieList());
        listBookMenuItem=new ListMenuItem<>(outputWriter,bookInventory);
        listBookMenuItem.setDescriptionMessage(Constants.LIST_BOOK_DESCRIPTION_MESSAGE);
        listMovieMenuItem=new ListMenuItem<>(outputWriter,movieInventory);
        listMovieMenuItem.setDescriptionMessage(Constants.LIST_MOVIE_DESCRIPTION_MESSAGE);
        logOutMenuItem=new LogOutMenuItem(outputWriter);

    }

    List<MenuItem> provideMenu() {
        List<MenuItem> menu=new ArrayList<>();
        CustomerLoginMenuItem customerLoginMenuItem=new CustomerLoginMenuItem(inputReader,outputWriter,this);
        LibrarianLoginMenuItem librarianLoginMenuItem=new LibrarianLoginMenuItem(inputReader,outputWriter);
        QuitMenuItem quitMenuItem=new QuitMenuItem(outputWriter);


        menu.add(listBookMenuItem);
        menu.add(listMovieMenuItem);
        menu.add(customerLoginMenuItem);
        menu.add(librarianLoginMenuItem);
        menu.add(quitMenuItem);

        return menu;

    }

    List<MenuItem> provideMenu(Customer customer) {
        List<MenuItem> menu=new ArrayList<>();

        ViewProfileMenuItem viewProfileMenuItem=new ViewProfileMenuItem(outputWriter,customer);
        CheckOutMenuItem<Book> checkOutBookMenuItem=new CheckOutMenuItem<>(inputReader,outputWriter,bookInventory,customer);
        CheckOutMenuItem<Movie> checkOutMovieMenuItem=new CheckOutMenuItem<>(inputReader,outputWriter,movieInventory,customer);
        ReturnBookMenuItem returnBookMenuItem=new ReturnBookMenuItem(inputReader,outputWriter,bookInventory,customer);

        menu.add(viewProfileMenuItem);
        menu.add(listBookMenuItem);
        menu.add(listMovieMenuItem);
        menu.add(checkOutBookMenuItem);
        menu.add(checkOutMovieMenuItem);
        menu.add(returnBookMenuItem);
        menu.add(logOutMenuItem);

        return menu;
    }

    List<MenuItem> provideMenu(Librarian librarian) {
        List<MenuItem> menu=new ArrayList<>();

        CheckedOutDetailsMenuItem<Book> checkedOutBookDetailsMenuItem=new CheckedOutDetailsMenuItem<Book>();
        CheckedOutDetailsMenuItem<Movie> checkedOutMovieDetailsMenuItem=new CheckedOutDetailsMenuItem<Movie>();

        menu.add(checkedOutBookDetailsMenuItem);
        menu.add(checkedOutMovieDetailsMenuItem);
        menu.add(logOutMenuItem);

        return menu;
    }



}
