package com.michups.book;

import java.util.Scanner;

/**
 * Created by michups on 01.06.17.
 */
public class MainBook {
    public static void main(String[] args) {

        int bookShelveSize = 10;
        BookShelve bookShelve = new BookShelve(bookShelveSize);
        Scanner inputScanner = new Scanner(System.in);
        boolean run = true;
        while(run) {

            System.out.println();
            System.out.println("Give me command: add, show,show all, quit");
            String command = inputScanner.nextLine();
            switch ( command){
                case "add":{
                    System.out.println("Give me book index");
                    Integer index = inputScanner.nextInt();

                    System.out.println("Give me book title");
                    String title = inputScanner.nextLine();
                    System.out.println("Give me book author");
                    String author = inputScanner.nextLine();
                    System.out.println("Give me book year");
                    int year = inputScanner.nextInt();

                    Book book = new Book(title, author, year);
                    bookShelve.addBook(index, book);
                    break;
                }
                case "show":{
                    System.out.println("Give me book index");
                    int index = inputScanner.nextInt();
                    bookShelve.getBook(index).print();
                    break;
                }
                case "show all":{
                    for (int i=0; i<bookShelve.getBookShelveSize(); i++) {
                        if (bookShelve.getBook(i)!=null)
                        {
                            bookShelve.getBook(i).print();
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
