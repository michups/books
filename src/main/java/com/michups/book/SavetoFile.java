package com.michups.book;

import java.io.*;

/**
 * Created by michups on 02.06.17.
 */
public class SavetoFile {

    public boolean loadFromFile(String path, Library inputLibrary) {

        try (
                FileInputStream fileIn = new FileInputStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fileIn))){
            String firstLine= reader.readLine();
            while (true) {
                if (firstLine == null){
                    return true;
                }
                int indexBookStand = Integer.parseInt(firstLine);

                int indexBookShalve = Integer.parseInt(reader.readLine());

                int indexBook = Integer.parseInt(reader.readLine());

                String title = reader.readLine();
                Cover cover = Cover.valueOf(reader.readLine());

                int numberOfAuthors= Integer.parseInt(reader.readLine());
                Author[] authors = new Author[numberOfAuthors];
                for (int j = 0; j <authors.length ; j++) {

                    String authorName = reader.readLine();

                    String authorSurname = reader.readLine();

                    String authorNickname = reader.readLine();


                    authors[j] = new Author(authorName, authorSurname, authorNickname);
                }
                int year = Integer.parseInt(reader.readLine());
                Book book;
                firstLine= reader.readLine();
                String releaseComicBookDate;
                String publishingSeries;
                String magazineDate;

                if (firstLine.equals("ComicBook")){
                    releaseComicBookDate =  reader.readLine();
                    publishingSeries =  reader.readLine();
                    book = new ComicBook(title, authors, year,releaseComicBookDate, publishingSeries, cover);
                }
                else if(firstLine.equals("Magazine")){
                    magazineDate =  reader.readLine();
                    book = new Magazine(title, authors, year, magazineDate, cover);

                }
                else{
                    book = new Book(title, authors, year, cover);

                }
                BookStand tempBookStand = inputLibrary.getBookStand(indexBookStand);
                BookShelve tempBookShalve = tempBookStand.getBookShelves(indexBookShalve);
                tempBookShalve.addBook(indexBook, book);
                firstLine= reader.readLine();
            }

        } catch (  IOException i)
        {
            i.printStackTrace();
            return false;
        }

    }

    public boolean saveToFile(String path, Library lib) {

        try (FileOutputStream fos = new FileOutputStream(path);
             PrintWriter writer = new PrintWriter(fos)) {
            for (int indexBookStand = 0; indexBookStand <lib.getSize(); indexBookStand++) {

                if(lib.getBookStand(indexBookStand)!=null)
                for (int j = 0; j < lib.getBookStand(indexBookStand).getSize(); j++) {
                    if(lib.getBookStand(indexBookStand).getBookShelves(j)!=null)
                        for (int i = 0; i < lib.getBookStand(indexBookStand).getBookShelves(j).getSize(); i++) {
                        if (lib.getBookStand(indexBookStand)!=null && lib.getBookStand(indexBookStand).getBookShelves(j)!=null &&
                                lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i) != null) {
                            writer.println(indexBookStand);
                            writer.println(j);
                            writer.println(i);
                            writer.println(lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i).getTitle());
                            writer.println(lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i).getCover());

                             writer.println(lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i).getNumberOfAuthors());
                            for (int k = 0; k < lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i).getNumberOfAuthors(); k++) {

                                writer.println(lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i).getAuthor(k).getName());
                                writer.println(lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i).getAuthor(k).getSurname());
                                writer.println(lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i).getAuthor(k).getNickName());
                            }
                            writer.println(lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i).getYearOfPublish());

                            if(lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i)instanceof ComicBook){
                                writer.println("ComicBook");
                                writer.println(((ComicBook) lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i)).getDateOfRelease());
                                writer.println(((ComicBook) lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i)).getPublishingSeries());
                            }

                            if(lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i)instanceof Magazine){
                                writer.println("Magazine");
                                writer.println(( (Magazine)lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i)).getDate());
                            }

                        }
                    }
                }
            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
