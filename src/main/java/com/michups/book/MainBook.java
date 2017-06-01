package com.michups.book;

import java.util.Scanner;

/**
 * Created by michups on 01.06.17.
 */
public class MainBook {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Give me book title");
        String title = inputScanner.next();
        System.out.println("Give me book author");
        String author = inputScanner.next();
        System.out.println("Give me book year");
        Integer year = inputScanner.nextInt();

        Book book = new Book(title, author, year);

        book.print();
    }
}
