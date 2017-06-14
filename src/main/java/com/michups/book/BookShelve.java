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
            this.books = new Book[1];
        }
    }
    public BookShelve() {
            this.books = new Book[1];
    }


    private void resize(int index) {
        Book[] tempBooks = new Book[index+1];
        for (int i = 0; i < tempBooks.length; i++) {
            if(i>books.length-1){
                //tempBooks[i] = new Book();
            }else if(books[i] !=null){
                tempBooks[i] = books[i];
            }

        }
        books=tempBooks;
    }

    public void addBook(int index, Book book) {
        if(index<getSize()-1){

            books[index] = book;
        }
        else
        {
            resize(index);
            books[index] = book;

        }
    }

    public Book getBook(int index) {

        if(index<getSize()-1){

            return books[index];
        }
        else
        {
            resize(index);
            return books[index];

        }
    }
    public int getSize() {

        return books.length;
    }
}
