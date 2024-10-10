package com.PersonalProject.library.Controller;

import com.PersonalProject.library.dto.AuthorSaveDTO;
import com.PersonalProject.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/publisher")
public class PublisherController {

    @Autowired
    private AuthorService authorService;
    @PostMapping(path="/save")
    public String saveAuthor(@RequestBody AuthorSaveDTO authorsaveDTO)
    {
        String   authorname=authorService.addAuthor(authorsaveDTO);
        return  "Added Successfully";
    }
}
