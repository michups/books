package com.michups.book;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.*;

/**
 * Created by michups on 01.06.17.
 */
public class MainBook {
    public static void main(String[] args) {

//        int BOOKSHALVE_SIZE = 10;
//        int BOOKSTAND_SIZE = 10;
//
        //int LIBRARY_SIZE = 10;


        Map<User, Library> libData = new HashMap<>();

        Library userLibrary;

//        SavetoFile.loadFromFile("textSave.lib", libData);
        libData = SerializationToFile.loadFromFile("serializationSave.lib");
        Scanner inputScanner = new Scanner(System.in);
        boolean run = true;

        System.out.println();
        System.out.println("Login:");
        String login = inputScanner.nextLine();
        System.out.println("password:");
        String password = inputScanner.nextLine();

        User user = new User(login, "", password);

        userLibrary= findLibraryForUser(user, libData);

        while (run) {

            System.out.println();
            System.out.println("Give me command: add, show, show all, change user, quit");
            String command = inputScanner.nextLine();
            switch (command) {
                case "change user": {

                    System.out.println();
                    System.out.println("Login:");
                    login = inputScanner.nextLine();
                    System.out.println("password:");
                    password = inputScanner.nextLine();

                    user = new User(login, "", password);

                    userLibrary= findLibraryForUser(user, libData);
                    break;
                }
                case "add": {

                     System.out.println("Give me bookstand index");
                      Integer indexBookStand = inputScanner.nextInt();
                      inputScanner.skip("\n");

                    System.out.println("Give me bookshelve index");
                    Integer indexBookShalve = inputScanner.nextInt();
                    inputScanner.skip("\n");

                    System.out.println("Give me book index");
                    Integer indexBook = inputScanner.nextInt();
                    inputScanner.skip("\n");

                    System.out.println("Give me book type: b-book, c-comic book, m-magazine");
                    String booktype = inputScanner.nextLine();

                    Cover bookCover = GetBookCoverFromUser(inputScanner);

                    System.out.println("Give me book title");
                    String title = inputScanner.nextLine();

                    System.out.println("Give me number of authors");
                    int authorNumber = inputScanner.nextInt();
                    inputScanner.skip("\n");
                    TreeSet<Author>authors = new TreeSet<>();

                    for (int i = 0; i < authorNumber; i++) {

                        System.out.println("Give me book author name");
                        String authorName = inputScanner.nextLine();
                        System.out.println("Give me book author surname");
                        String authorSurname = inputScanner.nextLine();
                        System.out.println("Give me book author nickname");
                        String authorNickname = inputScanner.nextLine();

                        Author author = new Author(authorName,authorSurname,authorNickname);
                        System.out.println(authors.add(author));

                    }
                    System.out.println("Give me book year");
                    int year = inputScanner.nextInt();
                    inputScanner.skip("\n");

                    int month;
                    int magazineday;
                    String publishingSeries;
                    Book book;
                    switch (booktype){
                        case "c":{
                            System.out.println("Give me comic book month");
                            month = inputScanner.nextInt();
                            inputScanner.skip("\n");
                            System.out.println("Give name of publishing series");
                            publishingSeries = inputScanner.nextLine();

                            book = new ComicBook(title, authors, year, month, publishingSeries, bookCover);
                            break;
                        }
                        case "m":{
                            System.out.println("Give me magazine month");
                            month = inputScanner.nextInt();
                            inputScanner.skip("\n");
                            System.out.println("Give me magazine day");
                            magazineday = inputScanner.nextInt();
                            inputScanner.skip("\n");
                            book = new Magazine(title, authors, year, month, magazineday, bookCover);
                            break;
                        }
                        default:{
                            book = new Book(title, authors, year, bookCover);

                            break;
                        }

                    }


                    BookShelve tempBookShalve =  userLibrary.getBookStand(indexBookStand).getBookShelves(indexBookShalve);
                    tempBookShalve.addBook(indexBook, book);

                    break;
                }
                case "show": {
                     System.out.println("Give me bookstand index");
                      int indexBookStand = inputScanner.nextInt();
                    inputScanner.skip("\n");
                    System.out.println("Give me bookshelve index");
                    int indexBookShalve = inputScanner.nextInt();
                    inputScanner.skip("\n");
                    System.out.println("Give me book index");
                    int indexBook = inputScanner.nextInt();
                    inputScanner.skip("\n");

                    if (userLibrary.getBookStand(indexBookStand)!=null &&userLibrary.getBookStand(indexBookStand).getBookShelves(indexBookShalve)!=null &&
                            userLibrary.getBookStand(indexBookStand).getBookShelves(indexBookShalve).getBook(indexBook) != null) {
                        userLibrary.getBookStand(indexBookStand).getBookShelves(indexBookShalve).getBook(indexBook).print();
                    }
                    else
                    {
                        System.out.println("This place is empty");
                    }
                    break;
                }
                case "show all": {
//                    System.out.println(Arrays.deepToString(bookShelves));
//                    System.out.println("AAAAAAAAAAAA");
                    for (int indexBookStand = 0; indexBookStand <userLibrary.getSize(); indexBookStand++) {

                        if(userLibrary.getBookStand(indexBookStand)!=null)
                        for (int j = 0; j < userLibrary.getBookStand(indexBookStand).getSize(); j++) {
                            if(userLibrary.getBookStand(indexBookStand).getBookShelves(j)!=null)
                            for (int i = 0; i < userLibrary.getBookStand(indexBookStand).getBookShelves(j).getSize(); i++) {
                                if (userLibrary.getBookStand(indexBookStand)!=null && userLibrary.getBookStand(indexBookStand).getBookShelves(j)!=null &&
                                        userLibrary.getBookStand(indexBookStand).getBookShelves(j).getBook(i) != null) {
                                    System.out.println("-"+indexBookStand+"-"+j+"-"+i+"-");
                                    userLibrary.getBookStand(indexBookStand).getBookShelves(j).getBook(i).print();
                                }
                            }
                        }
                    }
                    break;
                }
                case "quit": {

                    SavetoFile.saveToFile("textSave.lib", libData);
                    SerializationToFile.saveToFile("serializationSave.lib", libData);
                    run = false;
                    break;

                }
                default: {
                    System.out.println("Wrong command");
                }
            }
        }


    }

    public static Cover GetBookCoverFromUser(Scanner inputScanner){
        while(true) {
            System.out.println("Give me book cover type: s-soft, h-hard, i-integrated");

            String bookCoverStr = inputScanner.nextLine();
            switch (bookCoverStr) {
                case "h":
                    return Cover.HARD;
                case "s":
                    return Cover.SOFT;
                case "i":
                    return Cover.INTEGRADED;
                default:
                    System.out.println("WRONG COMMAND type of cover");
                    System.out.println("Give me book cover type: s-soft, h-hard, i-integrated");

            }
        }
    }
    public static Library  findLibraryForUser(User user, Map<User, Library> libData ){
        for (User key : libData.keySet()) {
            if (key.equals(user)) {
                return libData.get(user);
            }
        }
            libData.put(user, new Library());
            return libData.get(user);

    }


}
