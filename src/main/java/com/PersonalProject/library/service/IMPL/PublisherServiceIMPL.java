package com.PersonalProject.library.service.IMPL;

import com.PersonalProject.library.dto.PublisherSaveDTO;
import com.PersonalProject.library.entity.Publisher;
import com.PersonalProject.library.repo.PublisherRepo;
import com.PersonalProject.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceIMPL implements PublisherService {
    @Autowired
    private PublisherRepo publisherRepo;
    @Override
    public String addPublisher(PublisherSaveDTO publisherSaveDTO) {
            Publisher publisher =new Publisher (
                  publisherSaveDTO.getName()
                );
            publisherRepo.save(publisher);
            return publisher.getName();

    }
}
