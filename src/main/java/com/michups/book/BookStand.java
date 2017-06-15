package com.michups.book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michups on 01.06.17.
 */
public class BookStand implements java.io.Serializable{

    private List<BookShelve> bookShelves;

    public BookStand(int size) {
        if (size > 0) {
            this.bookShelves = new ArrayList<>(size);
        } else {
            this.bookShelves = new ArrayList<>();
        }
    }
    public BookStand() {
            this.bookShelves = new ArrayList<>();
    }


    private void resize(int index) {
        for (int i = bookShelves.size(); i <= index; i++) {
            bookShelves.add(null);
        }
    }

    public int getSize(){
        return bookShelves.size();
    }

    public void addBookShalve(int index, BookShelve bookShelve) {
        if(index<getSize()-1){

            bookShelves.set(index,bookShelve);
        }
        else
        {
            resize(index);
            bookShelves.set(index,bookShelve);

        }

    }

    public BookShelve getBookShelves(int index) {



        if(index>getSize()-1){
            resize(index);
            addBookShalve(index, new BookShelve());
        }else if( bookShelves.get(index)==null){

            addBookShalve(index, new BookShelve());
        }

            return bookShelves.get(index);
    }
}
