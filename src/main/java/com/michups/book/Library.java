package com.michups.book;

/**
 * Created by michups on 02.06.17.
 */
public class Library implements java.io.Serializable {

    private BookStand[] bookStands;

    public Library(int size) {
        if (size > 0) {
            this.bookStands = new BookStand[size];
        } else {
            this.bookStands = new BookStand[10];
        }
    }


    public int getBookStandSize() {
        return bookStands.length;
    }


    public void addBookStand(int index, BookStand bookStand) {
        this.bookStands[index] = bookStand;
    }

    public BookStand getBookStand(int index) {
        return bookStands[index];
    }
}