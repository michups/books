package com.michups.book;

/**
 * Created by michups on 01.06.17.
 */
public class BookStand {

    private int BookStandSize;
    private BookShelve[] bookShelves;

    public BookStand(int size) {
        if (size > 0) {
            this.bookShelves = new BookShelve[size];
            this.setBookStandSize(size);
        } else {
            this.bookShelves = new BookShelve[10];
            this.setBookStandSize(10);
        }
    }


    public int getBookStandSize() {
        return BookStandSize;
    }

    public void setBookStandSize(int bookStandSize) {
        BookStandSize = bookStandSize;
    }

    public void addBookShalve(int index, BookShelve bookShelve) {

        bookShelves[index] = bookShelve;
    }

    public BookShelve getBookShelves(int index) {

        return bookShelves[index];
    }
}
