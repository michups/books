package com.michups.book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michups on 02.06.17.
 */
public class Library implements java.io.Serializable {

    private List<BookStand> bookStands;

    public Library(int size) {
        if (size > 0) {
            this.bookStands =new ArrayList<>(size);
        } else {
            this.bookStands =new ArrayList<>();
        }
    }


    public Library() {
            this.bookStands = new ArrayList<>();
    }

    private void resize(int index) {
        for (int i = bookStands.size(); i <= index; i++) {
            bookStands.add(null);
        }
    }
    public int getSize() {
        return bookStands.size();
    }


    public void addBookStand(int index, BookStand bookStand) {

        if(index<getSize()-1){

            bookStands.set(index,bookStand);
        }
        else
        {
            resize(index);
            bookStands.set(index,bookStand);

        }
    }

    public BookStand getBookStand(int index) {

        if(index>getSize()-1){
            resize(index);
            addBookStand(index, new BookStand());
        }else if( bookStands.get(index)==null){

            addBookStand(index, new BookStand());
        }

        return bookStands.get(index);
    }


}