package com.PersonalProject.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment
    @Column(name = "author_id") // Length not needed for integers
    private int authorId;

    @Column(name = "name", length = 45)
    private String name;

    // Constructors
    public Author(int authorId, String name) {
        this.authorId = authorId;
        this.name = name;
    }

    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    // Getters and Setters
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                '}';
    }
}
