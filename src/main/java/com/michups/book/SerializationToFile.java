package com.michups.book;

import java.io.*;
import java.util.Map;

/**
 * Created by michups on 02.06.17.
 */
public class SerializationToFile {

    public static  Map<User, Library>  loadFromFile(String path) {
        try (
                FileInputStream fileIn = new FileInputStream(path);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            System.out.println("Succesfull loaded last session");
            return (Map) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
            System.out.println("Not found previous session save");
            return null;
        } catch (ClassNotFoundException c) {
            //c.printStackTrace();
            System.out.println("Loading error");
            return null;
        }
        catch (ClassCastException c) {
           // c.printStackTrace();
            System.out.println("Save of last session is broken");
            return null;
        }

    }

    public static boolean saveToFile(String path, Map<User, Library> inputLibraryData) {

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(inputLibraryData);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
