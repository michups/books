package com.michups.book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michups on 01.06.17.
 */
public class BookShelve implements java.io.Serializable{

    private List<Book> books;

    public BookShelve(int size) {
        if (size > 0) {
            this.books = new ArrayList<>(size);
        } else {
            this.books =new ArrayList<>();
        }
    }
    public BookShelve() {
        this.books =new ArrayList<>();
    }


    private void resize(int index) {
        for (int i = books.size(); i <= index; i++) {
            books.add(null);
            }
    }

    public void addBook(int index, Book book) {
        if(index<getSize()-1){

            books.set(index, book);
        }
        else
        {
            resize(index);
            books.set(index, book);

        }
    }

    public Book getBook(int index) {

        if(index>getSize()-1){
            return null;
        }else{
            return books.get(index);
        }
    }
    public int getSize() {

        return books.size();
    }
}
