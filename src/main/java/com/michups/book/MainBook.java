package com.michups.book;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by michups on 01.06.17.
 */
public class MainBook {
    public static void main(String[] args) {

        int BOOKSHALVE_SIZE = 10;
        int BOOKSTAND_SIZE = 10;

        int LIBRARY_SIZE = 10;


        Library library = new Library(LIBRARY_SIZE);

        for (int j = 0; j < LIBRARY_SIZE; j++) {

            library.addBookStand(j, new BookStand(BOOKSTAND_SIZE));
            for (int i = 0; i < BOOKSHALVE_SIZE; i++) {
                library.getBookStand(j).addBookShalve(i, new BookShelve(BOOKSHALVE_SIZE));
            }
        }

        SavetoFile savetoFile = new SavetoFile();
        savetoFile.loadFromFile("textSave.lib", library);

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

                    BookShelve tempBookShalve =  library.getBookStand(indexBookStand).getBookShelves(indexBookShalve);
                    tempBookShalve.addBook(indexBook, book);

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

                    if (library.getBookStand(indexBookStand)!=null &&library.getBookStand(indexBookStand).getBookShelves(indexBookShalve)!=null &&
                            library.getBookStand(indexBookStand).getBookShelves(indexBookShalve).getBook(indexBook) != null) {
                        library.getBookStand(indexBookStand).getBookShelves(indexBookShalve).getBook(indexBook);
                    }
                    break;
                }
                case "show all": {
//                    System.out.println(Arrays.deepToString(bookShelves));
                    for (int indexBookStand = 0; indexBookStand <library.getBookStandSize(); indexBookStand++) {

                        for (int j = 0; j < library.getBookStand(indexBookStand).getBookStandSize(); j++) {
                            for (int i = 0; i < library.getBookStand(indexBookStand).getBookShelves(j).getBookShelveSize(); i++) {
                                if (library.getBookStand(indexBookStand)!=null && library.getBookStand(indexBookStand).getBookShelves(j)!=null &&
                                        library.getBookStand(indexBookStand).getBookShelves(j).getBook(i) != null) {
                                    library.getBookStand(indexBookStand).getBookShelves(j).getBook(i).print();
                                }
                            }
                        }
                    }
                    break;
                }
                case "quit": {

                    savetoFile.saveToFile("textSave.lib", library);
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
