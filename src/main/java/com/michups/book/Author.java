package com.michups.book;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by michups on 02.06.17.
 */
public class Author implements Serializable, Comparable<Author>{

    private String name;

    private String surname;

    private String nickName;

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nickName='" + nickName + '\''  ;
    }

    public Author(String name, String surname, String nickName) {
        this.name = name;
        this.surname = surname;
        this.nickName = nickName;
    }

    @Override
    public int compareTo( Author o2) {
        if(this==o2){
            return 0;
        }
        int nameCompare = this.getName().compareTo(this.getName());
        int surnameCompare = this.getSurname().compareTo(this.getSurname());
        int nicknameCompare = this.getNickName().compareTo(this.getNickName());
        if(nameCompare!=0){
            return nameCompare;
        }
        if (surnameCompare!=0){
            return surnameCompare;
        }
        if(nicknameCompare!=0){
            return nicknameCompare;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
