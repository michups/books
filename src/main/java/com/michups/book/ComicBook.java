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


    public ComicBook(String title, Author[] authors, int year, int month,String pulishingSeries ) {
        super(title, authors, year);
        String years =  Integer.toString(year%100);
        String months =  (month>=10)?Integer.toString(month%13) :"0"+Integer.toString(month) ;
        this.dateOfRelease =years+"-"+months;
        this.publishingSeries = pulishingSeries;
    }

    public ComicBook(String title, Author[] authors, int year, String dateOfRelease ,String pulishingSeries ) {
        super(title, authors, year);
        this.dateOfRelease =dateOfRelease;
        this.publishingSeries = pulishingSeries;
    }

    public String getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public String getPublishingSeries() {
        return publishingSeries;
    }

    public void setPublishingSeries(String publishingSeries) {
        this.publishingSeries = publishingSeries;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Date of release= '" + dateOfRelease +"'");
        System.out.println("Publishing series= '" + publishingSeries +"'");
    }
}
