package com.michups.book;

/**
 * Created by michups on 01.06.17.
 */
public class BookShelve {

    private int bookShelveSize;
    private Book[] books;

    public BookShelve(int size) {
        if (size > 0) {
            this.books = new Book[size];
            this.setBookShelveSize(size);
        } else {
            this.books = new Book[10];
            this.setBookShelveSize(10);
        }
    }


    public int getBookShelveSize() {
        return bookShelveSize;
    }

    public void setBookShelveSize(int bookShelveSize) {
        this.bookShelveSize = bookShelveSize;
    }


    public void addBook(int index, Book book) {

        books[index] = book;
    }

    public Book getBook(int index) {

        return books[index];
    }
}
