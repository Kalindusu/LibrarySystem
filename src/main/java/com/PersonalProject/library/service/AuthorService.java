package com.PersonalProject.library.service;

import com.PersonalProject.library.dto.AuthorDTO;
import com.PersonalProject.library.dto.AuthorSaveDTO;
import com.PersonalProject.library.dto.AuthorUpdateDTO;

import java.util.List;

public interface AuthorService {


    String addAuthor(AuthorSaveDTO authorsaveDTO);

    List<AuthorDTO> getAllAuthor();

    String updateAuthor(AuthorUpdateDTO authorUpdateDTO);

    String deleteAuthor(int id);
}
