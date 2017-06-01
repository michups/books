package com.michups.book;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by michups on 01.06.17.
 */
public class MainBook {
    public static void main(String[] args) {

        int BOOKSHALVE_SIZE = 10;
        int BOOKSTAND_SIZE = 10;


        BookStand bookStand = new BookStand(BOOKSTAND_SIZE);
        for (int i = 0; i < BOOKSHALVE_SIZE; i++) {
            bookStand.addBookShalve(i, new BookShelve(BOOKSHALVE_SIZE));
        }



        Scanner inputScanner = new Scanner(System.in);
        boolean run = true;
        while(run) {

            System.out.println();
            System.out.println("Give me command: add, show,show all, quit");
            String command = inputScanner.nextLine();
            switch ( command){
                case "add":{
                   // System.out.println("Give me bookstand index");
                  //  Integer indexBookStand = inputScanner.nextInt();
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

                    BookShelve tempBookShalve = bookStand.getBookShelves(indexBookShalve);
                    tempBookShalve.addBook(indexBook, book);
                    bookStand.addBookShalve(indexBookShalve, tempBookShalve);
                    break;
                }
                case "show":{
                   // System.out.println("Give me bookstand index");
                  //  int indexBookStand = inputScanner.nextInt();
                    System.out.println("Give me bookshelve index");
                    int indexBookShalve = inputScanner.nextInt();
                    System.out.println("Give me book index");
                    int indexBook = inputScanner.nextInt();

                    if (bookStand.getBookShelves(indexBookShalve).getBook(indexBook) != null) {
                        bookStand.getBookShelves(indexBookShalve).getBook(indexBook);
                    }
                    break;
                }
                case "show all":{
//                    System.out.println(Arrays.deepToString(bookShelves));
                    for (int j = 0; j <bookStand.getBookStandSize() ; j++) {
                        for (int i = 0; i < bookStand.getBookShelves(j).getBookShelveSize(); i++) {
                            if ( bookStand.getBookShelves(j).getBook(i)!= null) {
                                bookStand.getBookShelves(j).getBook(i).print();
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
