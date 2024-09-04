package com.PersonalProject.library.Controller;

import com.PersonalProject.library.dto.AuthorSaveDTO;
import com.PersonalProject.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    public String saveAuthor(@RequestBody AuthorSaveDTO authorsaveDTO)
    {
        String   authorname=authorService.addAuthor(authorsaveDTO);
        return  authorname;
    }



}