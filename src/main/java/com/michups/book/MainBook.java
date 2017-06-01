package com.michups.book;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by michups on 01.06.17.
 */
public class MainBook {
    public static void main(String[] args) {

        int BOOKSHALVE_SIZE = 10;
        int NUMBER_OF_BOOKSHALVE = 10;

        BookShelve[] bookShelves = new BookShelve[NUMBER_OF_BOOKSHALVE];
        for (int i = 0; i <BOOKSHALVE_SIZE  ; i++) {
            bookShelves[i]= new BookShelve(BOOKSHALVE_SIZE);
        }
        //

        Scanner inputScanner = new Scanner(System.in);
        boolean run = true;
        while(run) {

            System.out.println();
            System.out.println("Give me command: add, show,show all, quit");
            String command = inputScanner.nextLine();
            switch ( command){
                case "add":{
                    System.out.println("Give me bookshelve index");
                    Integer indexBookShalve = inputScanner.nextInt();
                    System.out.println("Give me book index");
                    Integer indexBook = inputScanner.nextInt();

                    System.out.println("Give me book title");
                    String title = inputScanner.nextLine();
                    System.out.println("Give me book author");
                    String author = inputScanner.nextLine();
                    System.out.println("Give me book year");
                    int year = inputScanner.nextInt();

                    Book book = new Book(title, author, year);

                    bookShelves[indexBookShalve].addBook(indexBook, book);
                    break;
                }
                case "show":{
                    System.out.println("Give me bookshelve index");
                    int indexBookShalve = inputScanner.nextInt();
                    System.out.println("Give me book index");
                    int indexBook = inputScanner.nextInt();
                    if ( bookShelves[indexBookShalve].getBook(indexBook) != null) {
                        bookShelves[indexBookShalve].getBook(indexBook).print();
                    }
                    break;
                }
                case "show all":{
//                    System.out.println(Arrays.deepToString(bookShelves));
                    for (int j = 0; j <bookShelves.length ; j++) {
                        for (int i = 0; i < bookShelves[j].getBookShelveSize(); i++) {
                            if ( bookShelves[j].getBook(i) != null) {
                                bookShelves[j].getBook(i).print();
                            }
                        }
                    }
                    break;
                }
                case "quit":{
                    run = false;
                    break;

                }
                default: {
                    System.out.println("Wrong command");
                }
            }

        }



    }



}
