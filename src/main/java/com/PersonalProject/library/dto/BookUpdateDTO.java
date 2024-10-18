package com.PersonalProject.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookUpdateDTO {
    private int bookid;
    private String title;
    private int authorId;
    private int publisher_id;
}
