package com.michups.book;

import java.io.Serializable;

/**
 * Created by michups on 16.06.17.
 */
public class User implements Serializable, Comparable<User>{

    private String login;
    private String email;

    private String password;


    @Override
    public String toString() {
        return "login='" + login + '\'' +
                ", email='" + email + '\''  ;
    }

    public User(String name, String email, String password) {
        this.login = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo( User o2) {
        if(this==o2){
            return 0;
        }
        int loginCompare = this.getLogin().compareTo(this.getLogin());
        int emailCompare = this.getEmail().compareTo(this.getEmail());
        if(loginCompare!=0){
            return loginCompare;
        }
        if (emailCompare!=0){
            return emailCompare;
        }
        return 0;
    }

    private void changePassword(String newPassword){
        this.password = newPassword;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
}