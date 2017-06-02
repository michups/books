package com.michups.book;

/**
 * Created by michups on 01.06.17.
 */
public class Book implements java.io.Serializable{

    private String title;

    private Author[] authors;

    private int yearOfPublish;


    public void print() {
        System.out.println("--Book--");
        System.out.println("Title= '" + title +"'");
        for (Author author:authors  ) {
            System.out.println("Author='" + author.toString() +"'");
        }
        System.out.println("Year of publish='" + yearOfPublish+"'");

    }

    public Book(String title, Author[] authors, int yearOfPublish) {

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
        return authors[index];
    }
    public int getNumberOfAuthors() {
        return authors.length;
    }


    public void setAuthor(int index, Author author) {
        this.authors[index] = author;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }


}
