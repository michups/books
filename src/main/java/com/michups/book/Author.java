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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (name != null ? !name.equals(author.name) : author.name != null) return false;
        if (surname != null ? !surname.equals(author.surname) : author.surname != null) return false;
        return nickName != null ? nickName.equals(author.nickName) : author.nickName == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo( Author o2) {
        if(this==o2){
            return 0;
        }
        int nameCompare = this.getName().compareTo(o2.getName());
        int surnameCompare = this.getSurname().compareTo(o2.getSurname());
        int nicknameCompare = this.getNickName().compareTo(o2.getNickName());
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
