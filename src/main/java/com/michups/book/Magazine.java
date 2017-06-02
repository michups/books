package com.michups.book;

/**
 * Created by michups on 02.06.17.
 */
public class Magazine extends Book {
    /**
     * YY-MM-dd
     */
    private String date;


    public Magazine(String title, Author[] authors, int year, int month, int day) {
        super(title, authors, year);
        String years =  Integer.toString(year%100);
        String days =   (day>=10)?Integer.toString(day%32) :"0"+Integer.toString(day) ;
        String months =  (month>=10)?Integer.toString(month%13) :"0"+Integer.toString(month) ;
        this.date =years+"-"+months+"-"+days;
    }
}
