package com.michups.book;

/**
 * Created by michups on 01.06.17.
 */
public class Book {
    private String title;
    private String author;
    private Integer yearOfPublish;


    public void print() {
        System.out.println("--Book--");
        System.out.println("Title= '" + title +"'");
        System.out.println("Author='" + author +"'");
        System.out.println("Year of publish='" + yearOfPublish+"'");

    }

    public Book(String title, String author, Integer yearOfPublish) {
        this.title = title;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(Integer yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }


}
