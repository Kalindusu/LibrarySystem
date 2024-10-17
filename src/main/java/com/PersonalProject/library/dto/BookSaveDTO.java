package com.PersonalProject.library.dto;

import com.PersonalProject.library.entity.Author;
import com.PersonalProject.library.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookSaveDTO {

    private String title;
    private int authorId;
    private int publisher_id;
}
