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
            this.bookShelves = new BookShelve[1];
        }
    }
    public BookStand() {
            this.bookShelves = new BookShelve[1];
    }


    private void resize(int index) {
        BookShelve[] tempBookshelves = new BookShelve[index+1];
        for (int i = 0; i < tempBookshelves.length; i++) {
                if(i>bookShelves.length-1){
                    tempBookshelves[i] = new BookShelve();
                }else if(bookShelves[i] !=null){
                    tempBookshelves[i] = bookShelves[i];
                }
            }

        bookShelves=tempBookshelves;
    }

    public int getSize(){
        return bookShelves.length;
    }

    public void addBookShalve(int index, BookShelve bookShelve) {
        if(index<getSize()-1){

            bookShelves[index] = bookShelve;
        }
        else
        {
            resize(index);
            bookShelves[index] = bookShelve;

        }

    }

    public BookShelve getBookShelves(int index) {


        if(index<getSize()-1){

            return bookShelves[index];
        }
        else
        {
            resize(index);
            if(bookShelves[index] == null) {
                bookShelves[index] = new BookShelve();
            }
            return bookShelves[index];

        }
    }
}
