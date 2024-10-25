package com.PersonalProject.library.dto;

import com.PersonalProject.library.entity.Book;
import com.PersonalProject.library.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowSaveDTO {


    private int book_id;
    private String user_id;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
