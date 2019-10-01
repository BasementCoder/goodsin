package com.garagonic.goodsin.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "giuser")
public class User {

    @Id
    @Column(length=20)
    private String username;
    private String gipassword;
    private Boolean superuser;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGipassword() {
        return gipassword;
    }

    public void setGipassword(String gipassword) {
        this.gipassword = gipassword;
    }

    public Boolean getSuperuser() {
        return superuser;
    }

    public void setSuperuser(Boolean superuser) {
        this.superuser = superuser;
    }
}
