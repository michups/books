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
            this.bookStands = new BookStand[1];
        }
    }


    public Library() {
            this.bookStands = new BookStand[1];
    }

    private void resize(int index) {
        BookStand[] tempBookStand = new BookStand[index+1];
        for (int i = 0; i < tempBookStand.length; i++) {
            if(i>bookStands.length-1){
                tempBookStand[i] = new BookStand();
            }else if(bookStands[i] !=null){
                tempBookStand[i] = bookStands[i];
            }

        }
        bookStands=tempBookStand;
    }
    public int getSize() {
        return bookStands.length;
    }


    public void addBookStand(int index, BookStand bookStand) {
        this.bookStands[index] = bookStand;
        if(index<getSize()-1){

            bookStands[index] = bookStand;
        }
        else
        {
            resize(index);
            bookStands[index] = bookStand;

        }
    }

    public BookStand getBookStand(int index) {

        if(index<getSize()-1){

            return bookStands[index];
        }
        else
        {
            resize(index);
            if(bookStands[index] == null) {
                bookStands[index] = new BookStand();
            }
            return bookStands[index];

        }

    }
}