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
        int ARRAY_OF_BOOKSTAND_SIZE = 10;


        BookStand[] bookStands = new BookStand[ARRAY_OF_BOOKSTAND_SIZE];
        for (int j = 0; j < ARRAY_OF_BOOKSTAND_SIZE; j++) {

            bookStands[j] = new BookStand(BOOKSTAND_SIZE);
            for (int i = 0; i < BOOKSHALVE_SIZE; i++) {
                bookStands[j].addBookShalve(i, new BookShelve(BOOKSHALVE_SIZE));
            }
        }


        Scanner inputScanner = new Scanner(System.in);
        boolean run = true;
        while (run) {

            System.out.println();
            System.out.println("Give me command: add, show,show all, quit");
            String command = inputScanner.nextLine();
            switch (command) {
                case "add": {
                     System.out.println("Give me bookstand index");
                      Integer indexBookStand = inputScanner.nextInt();
                      inputScanner.skip("\n");
                    System.out.println("Give me bookshelve index");
                    Integer indexBookShalve = inputScanner.nextInt();
                    inputScanner.skip("\n");
                    System.out.println("Give me book index");
                    Integer indexBook = inputScanner.nextInt();
                    inputScanner.skip("\n");

                    System.out.println("Give me book title");
                    String title = inputScanner.nextLine();
                    System.out.println("Give me book author");
                    String author = inputScanner.nextLine();
                    System.out.println("Give me book year");
                    int year = inputScanner.nextInt();
                    inputScanner.skip("\n");

                    Book book = new Book(title, author, year);

                    BookShelve tempBookShalve = bookStands[indexBookStand].getBookShelves(indexBookShalve);
                    tempBookShalve.addBook(indexBook, book);
                    bookStands[indexBookStand].addBookShalve(indexBookShalve, tempBookShalve);
                    break;
                }
                case "show": {
                     System.out.println("Give me bookstand index");
                      int indexBookStand = inputScanner.nextInt();
                    inputScanner.skip("\n");
                    System.out.println("Give me bookshelve index");
                    int indexBookShalve = inputScanner.nextInt();
                    inputScanner.skip("\n");
                    System.out.println("Give me book index");
                    int indexBook = inputScanner.nextInt();
                    inputScanner.skip("\n");

                    if (bookStands[indexBookStand].getBookShelves(indexBookShalve).getBook(indexBook) != null) {
                        bookStands[indexBookStand].getBookShelves(indexBookShalve).getBook(indexBook);
                    }
                    break;
                }
                case "show all": {
//                    System.out.println(Arrays.deepToString(bookShelves));
                    for (int indexBookStand = 0; indexBookStand < ARRAY_OF_BOOKSTAND_SIZE; indexBookStand++) {

                        for (int j = 0; j < bookStands[indexBookStand].getBookStandSize(); j++) {
                            for (int i = 0; i < bookStands[indexBookStand].getBookShelves(j).getBookShelveSize(); i++) {
                                if (bookStands[indexBookStand].getBookShelves(j).getBook(i) != null) {
                                    bookStands[indexBookStand].getBookShelves(j).getBook(i).print();
                                }
                            }
                        }
                    }
                    break;
                }
                case "quit": {
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
