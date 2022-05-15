package com.IshanAdeepaRidma.BidCoinBackend.Users;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @Column(name = "email", unique = true, length = 30)
    private String email;
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "isAdmin")
    private boolean isAdmin = false;

    public UserModel() {

    }

    public UserModel(String email, String passwd, boolean isAdmin) {
        this.email = email;
        this.passwd = passwd;
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public boolean isIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
