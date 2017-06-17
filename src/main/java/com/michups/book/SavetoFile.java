package com.michups.book;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by michups on 02.06.17.
 */
public class SavetoFile {

    public static boolean loadFromFile(String path, Map<User, Library> libraryData) {

        try (
                FileInputStream fileIn = new FileInputStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fileIn))){
            String firstLine= reader.readLine();
            Library library = new Library() ;
            while (true) {
                if (firstLine == null ){
                    return true;
                }
                User user;
                if (firstLine.equals("User") ){
                    String login = reader.readLine();
                    String email = reader.readLine();
                    String password = reader.readLine();
                    user = new User(login, email, password);
                    library = new Library();
                    libraryData.put(user, library);
                    firstLine= reader.readLine();
                }
                int indexBookStand = Integer.parseInt(firstLine);

                int indexBookShalve = Integer.parseInt(reader.readLine());

                int indexBook = Integer.parseInt(reader.readLine());

                String title = reader.readLine();
                Cover cover = Cover.valueOf(reader.readLine());

                int numberOfAuthors= Integer.parseInt(reader.readLine());
                TreeSet<Author> authors = new TreeSet<>();
                for (int j = 0; j <numberOfAuthors ; j++) {

                    String authorName = reader.readLine();

                    String authorSurname = reader.readLine();

                    String authorNickname = reader.readLine();


                    authors.add(new Author(authorName, authorSurname, authorNickname));
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
                else if(firstLine.equals("Book")){
                    book = new Book(title, authors, year, cover);

                }
                else {
                    book = new Book(title, authors, year, cover);

                }
                BookStand tempBookStand = library.getBookStand(indexBookStand);
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

    public static boolean saveToFile(String path, Map<User, Library> libraryData) {

        try (FileOutputStream fos = new FileOutputStream(path);
             PrintWriter writer = new PrintWriter(fos)) {

            for (Map.Entry<User, Library> pair : libraryData.entrySet()) {
                Library lib = pair.getValue();
                User user = pair.getKey();

                if(user == null){
                    continue;
                }

                writer.println("User");
                writer.println(user.getLogin());
                writer.println(user.getEmail());
                writer.println(user.getPassword());
                if(lib !=null)
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
                                } else if(lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i)instanceof Magazine){
                                    writer.println("Magazine");
                                    writer.println(( (Magazine)lib.getBookStand(indexBookStand).getBookShelves(j).getBook(i)).getDate());
                                }else {
                                    writer.println("Book");
                                }

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
