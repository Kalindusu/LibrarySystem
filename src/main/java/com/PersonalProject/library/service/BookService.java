package com.PersonalProject.library.service;

import com.PersonalProject.library.dto.BookDTO;
import com.PersonalProject.library.dto.BookSaveDTO;
import com.PersonalProject.library.dto.BookUpdateDTO;

import java.util.List;

public interface BookService {
    String addBook(BookSaveDTO bookSaveDTO);

    List<BookDTO> getAllBook();

    String updateBook(BookUpdateDTO bookUpdateDTO);

    String deleteBook(int id);
}
