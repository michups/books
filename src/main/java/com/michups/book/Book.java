package com.michups.book;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by michups on 01.06.17.
 */
public class Book implements java.io.Serializable{

    private String title;

    private TreeSet<Author> authors;

    private int yearOfPublish;


    private Cover cover;


    public Cover getCover() {
        return cover;
    }

    public void print() {
        System.out.println("--Book--");
        System.out.println("Title= '" + title +"'");
        for (Author author:authors  ) {
            System.out.println("Author='" + author.toString() +"'");
        }
        System.out.println("Year of publish='" + yearOfPublish+"'");
        System.out.println("Cover = "+cover.name());

    }

    public Book(String title, TreeSet<Author> authors, int yearOfPublish, Cover cover) {

        this.cover = cover;
        this.title = title;
        this.authors =authors;

        this.yearOfPublish = yearOfPublish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor( int index) {
        int i=0;
        for (Author a :  authors) {
            if(i==index){
                return a;
            }
            i++;
        }
        return null;
    }
    public int getNumberOfAuthors() {
        return authors.size();
    }


    public void setAuthor(int index, Author author) {
       Author tempAuthor = getAuthor(index);
       tempAuthor = author;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }


}
