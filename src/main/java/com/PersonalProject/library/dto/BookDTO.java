package com.PersonalProject.library.dto;

import com.PersonalProject.library.entity.Author;
import com.PersonalProject.library.entity.Publisher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {


    private int bookid;
    private String title;
    private Author author;
    private Publisher publisher;
}
