package com.michups.book;

import java.util.Scanner;

/**
 * Created by michups on 01.06.17.
 */
public class MainBook {
    public static void main(String[] args) {

        Book[] books = new Book[10];
        Scanner inputScanner = new Scanner(System.in);
        boolean run = true;
        while(run) {

            System.out.println();
            System.out.println("Give me command: add, show, quit");
            String command = inputScanner.next();
            switch ( command){
                case "add":{
                    System.out.println("Give me book index");
                    Integer index = inputScanner.nextInt();

                    System.out.println("Give me book title");
                    String title = inputScanner.next();
                    System.out.println("Give me book author");
                    String author = inputScanner.next();
                    System.out.println("Give me book year");
                    Integer year = inputScanner.nextInt();

                    Book book = new Book(title, author, year);
                    books[index] = book;
                    break;
                }
                case "show":{

                    break;
                }
                case "quit":{
                    run = false;
                    break;
                }

            }

        }



    }



}
