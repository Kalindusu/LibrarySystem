package com.PersonalProject.library.Controller;

import com.PersonalProject.library.dto.AuthorDTO;
import com.PersonalProject.library.dto.AuthorSaveDTO;
import com.PersonalProject.library.dto.AuthorUpdateDTO;
import com.PersonalProject.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
@PostMapping(path="/save")
    public String saveAuthor(@RequestBody AuthorSaveDTO authorsaveDTO)
    {
        String   authorname=authorService.addAuthor(authorsaveDTO);
        return  "Added Successfully";
    }

    @GetMapping(path="/getAllAuthor")
    public List<AuthorDTO> getAllAuthor()
    {
        List<AuthorDTO> allAuthors=authorService.getAllAuthor();
        return allAuthors;
    }

    @PutMapping(path="/update")

    public String getAllAuthor(@RequestBody AuthorUpdateDTO authorUpdateDTO)

    {
        String authorname=authorService.updateAuthor(authorUpdateDTO);
        return  authorname;
    }

    @DeleteMapping (path="/delete/{id}")

    public String deleteAuthor(@PathVariable (value = "id")int id)

    {
        String authorname=authorService.deleteAuthor(id);
        return  "deleteAuthor";
    }



}