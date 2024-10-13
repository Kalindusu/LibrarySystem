package com.PersonalProject.library.service.IMPL;

import com.PersonalProject.library.dto.AuthorDTO;
import com.PersonalProject.library.dto.PublisherDTO;
import com.PersonalProject.library.dto.PublisherSaveDTO;
import com.PersonalProject.library.dto.PublisherUpdateDTO;
import com.PersonalProject.library.entity.Author;
import com.PersonalProject.library.entity.Publisher;
import com.PersonalProject.library.repo.PublisherRepo;
import com.PersonalProject.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> getPublishers = publisherRepo.findAll();
        List<PublisherDTO> publisherDTOList = new ArrayList<>();

        for (Publisher publisher : getPublishers) {
            PublisherDTO  publisherDTO = new PublisherDTO(
                    publisher.getPublisher_id(),
                    publisher.getName()
            );
            publisherDTOList.add(publisherDTO);
        }
        return publisherDTOList;
    }

    @Override
    public String updatePublisher(PublisherUpdateDTO publisherUpdateDTO) {

        if (publisherRepo.existsById(publisherUpdateDTO.getPublisher_id())) {

            Publisher publisher = publisherRepo.getById(publisherUpdateDTO.getPublisher_id());
           publisher.setName(publisherUpdateDTO.getName());
            publisherRepo.save(publisher);
            return publisher.getName();
        } else {
            System.out.println("publisher not Exist.....");
        }
        return null;

    }
}
