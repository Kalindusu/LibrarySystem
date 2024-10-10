package com.PersonalProject.library.Controller;

import com.PersonalProject.library.dto.AuthorSaveDTO;
import com.PersonalProject.library.dto.PublisherSaveDTO;
import com.PersonalProject.library.service.AuthorService;
import com.PersonalProject.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;
    @PostMapping(path="/save")
    public String savePublisher(@RequestBody PublisherSaveDTO publisherSaveDTO)
    {
        String   publishername=publisherService.addPublisher(publisherSaveDTO);
        return  "Added Successfully";
    }
}
