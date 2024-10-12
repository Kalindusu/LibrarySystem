package com.PersonalProject.library.service;

import com.PersonalProject.library.dto.AuthorDTO;
import com.PersonalProject.library.dto.PublisherDTO;
import com.PersonalProject.library.dto.PublisherSaveDTO;

import java.util.List;

public interface PublisherService {
    String addPublisher(PublisherSaveDTO publisherSaveDTO);

    List<PublisherDTO> getAllPublisher();
}
