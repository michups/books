package com.michups.book;

/**
 * Created by michups on 01.06.17.
 */
public class BookShelve implements java.io.Serializable{

    private Book[] books;

    public BookShelve(int size) {
        if (size > 0) {
            this.books = new Book[size];
        } else {
            this.books = new Book[10];
        }
    }


    public int getBookShelveSize() {
        return books.length;
    }



    public void addBook(int index, Book book) {

        books[index] = book;
    }

    public Book getBook(int index) {

        return books[index];
    }
}
