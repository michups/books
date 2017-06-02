package com.michups.book;

import java.io.*;

/**
 * Created by michups on 02.06.17.
 */
public class SerializationToFile {

    public boolean loadFromFile(String path, Library outLibrary) {
        try (
                FileInputStream fileIn = new FileInputStream("library_save.lib");
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            outLibrary = (Library) in.readObject();
            return true;
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return false;
        }

    }

    public boolean saveToFile(String path, Library inputLibrary) {

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(inputLibrary);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
