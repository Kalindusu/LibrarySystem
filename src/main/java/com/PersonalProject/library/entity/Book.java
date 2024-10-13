package com.PersonalProject.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Book_Id",length = 11)
    private int bookid;
    @Column(name="Title",length = 45)
    private String title;



}
