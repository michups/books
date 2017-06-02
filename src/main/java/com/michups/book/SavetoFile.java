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

            while (true) {
                String firstLine = reader.readLine();
                if (firstLine == null){
                    return true;
                }
                int indexBookStand = Integer.parseInt(firstLine);

                int indexBookShalve = Integer.parseInt(reader.readLine());

                int indexBook = Integer.parseInt(reader.readLine());

                String title = reader.readLine();

                String author = reader.readLine();

                int year = Integer.parseInt(reader.readLine());

                Book book = new Book(title, author, year);

                BookShelve tempBookShalve = inputLibrary.getBookStand(indexBookStand).getBookShelves(indexBookShalve);
                tempBookShalve.addBook(indexBook, book);
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
            for (int indexBookStand = 0; indexBookStand <lib.getBookStandSize(); indexBookStand++) {

                for (int j = 0; j < lib.getBookStand(indexBookStand).getBookStandSize(); j++) {
                    for (int i = 0; i < lib.getBookStand(indexBookStand).getBookShelves(j).getBookShelveSize(); i++) {
                        if (lib.getBookStand(indexBookStand)!=null && lib.getBookStand(indexBookStand).getBookShelves(j)!=null &&
                                lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i) != null) {
                            writer.println(indexBookStand);
                            writer.println(j);
                            writer.println(i);
                            writer.println(lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i).getTitle());
                            writer.println(lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i).getAuthor());
                            writer.println(lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i).getYearOfPublish());
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
