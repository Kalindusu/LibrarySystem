package com.PersonalProject.library.service.IMPL;

import com.PersonalProject.library.dto.AuthorDTO;
import com.PersonalProject.library.dto.AuthorSaveDTO;
import com.PersonalProject.library.dto.AuthorUpdateDTO;
import com.PersonalProject.library.entity.Author;
import com.PersonalProject.library.repo.AuthorRepo;
import com.PersonalProject.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AuthorServiceIMPL implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public String addAuthor(AuthorSaveDTO authorsaveDTO) {
        Author author = new Author(
                authorsaveDTO.getName()
        );
        authorRepo.save(author);
        return author.getName();


    }

    @Override
    public List<AuthorDTO> getAllAuthor() {
        List<Author> getAuthors = authorRepo.findAll();
        List<AuthorDTO> authorDTOList = new ArrayList<>();

        for (Author author : getAuthors) {
            AuthorDTO authorDTO = new AuthorDTO(
                    author.getAuthorId(),
                    author.getName()
            );
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }

    @Override
    public String updateAuthor(AuthorUpdateDTO authorUpdateDTO) {

        if (authorRepo.existsById(authorUpdateDTO.getAuthorId())) {

            Author author = authorRepo.getById(authorUpdateDTO.getAuthorId());
            author.setName(authorUpdateDTO.getName());
            authorRepo.save(author);
            return author.getName();
        } else {
            System.out.println("Author not Exist.....");
        }
        return null;
    }

    @Override
    public String deleteAuthor(int id) {
        if(authorRepo.existsById(id))
        {
            authorRepo.deleteById(id);
        }else{
            System.out.println("Author not found");
        }
        return null;
    }
}
