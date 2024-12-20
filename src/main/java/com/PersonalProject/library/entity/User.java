package com.PersonalProject.library.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", length = 45)
    private String userid;
    @Column(name = "name", length = 45)
    private  String name;
    @Column(name = "email", length = 45)
    private String email;


    @OneToMany(mappedBy="user")
    private Set<Borrow> borrows;

    public User(String userid, String name, String email) {
        this.userid = userid;
        this.name = name;
        this.email = email;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
