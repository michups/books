package com.michups.book;

/**
 * Created by michups on 01.06.17.
 */
public class BookStand implements java.io.Serializable{

    private BookShelve[] bookShelves;

    public BookStand(int size) {
        if (size > 0) {
            this.bookShelves = new BookShelve[size];
        } else {
            this.bookShelves = new BookShelve[10];
        }
    }


    public int getBookStandSize() {
        return bookShelves.length;
    }


    public void addBookShalve(int index, BookShelve bookShelve) {
        bookShelves[index] = bookShelve;
    }

    public BookShelve getBookShelves(int index) {
        return bookShelves[index];
    }
}
