package com.michups.book;

/**
 * Created by michups on 02.06.17.
 */
public class ComicBook extends Book{
    /**
     * YY-MM
     */
    private String dateOfRelease;

    private String publishingSeries;



    public ComicBook(String title, Author[] authors, int year, int month,String pulishiingSeries ) {
        super(title, authors, year);
        String years =  Integer.toString(year%100);
        String months =  (month>=10)?Integer.toString(month%13) :"0"+Integer.toString(month) ;
        this.dateOfRelease =years+"-"+months;
        this.publishingSeries = pulishiingSeries;
    }
}
