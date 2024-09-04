package com.PersonalProject.library.service.IMPL;

import com.PersonalProject.library.dto.AuthorSaveDTO;
import com.PersonalProject.library.entity.Author;
import com.PersonalProject.library.repo.AuthorRepo;
import com.PersonalProject.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceIMPL implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    @Override
    public String addAuthor(AuthorSaveDTO authorsaveDTO) {

        Author author=new Author(
                authorsaveDTO.getName()
        );
        authorRepo.save(author);
        return author.getName();



    }
}
