package com.PersonalProject.library.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="publisher")
public class Publisher {
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
@Column(name="Publisher_id")
    private int publisher_id;
@Column(name="Publisher_name")
    private String name;


    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
