package com.PersonalProject.library.service.IMPL;

import com.PersonalProject.library.dto.AuthorDTO;
import com.PersonalProject.library.dto.PublisherDTO;
import com.PersonalProject.library.dto.PublisherSaveDTO;
import com.PersonalProject.library.dto.PublisherUpdateDTO;
import com.PersonalProject.library.entity.Author;
import com.PersonalProject.library.entity.Publisher;
import com.PersonalProject.library.repo.PublisherRepo;
import com.PersonalProject.library.service.PublisherService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        // Check if publisher exists
        Optional<Publisher> optionalPublisher = publisherRepo.findById(publisherUpdateDTO.getPublisher_id());

        if (optionalPublisher.isPresent()) {
            // Get the existing publisher
            Publisher publisher = optionalPublisher.get();

            // Update the publisher fields
            publisher.setName(publisherUpdateDTO.getName());

            // Save the updated publisher back to the repository
            publisherRepo.save(publisher);

            // Return updated publisher's name
            return publisher.getName();
        } else {
            // Handle case where publisher does not exist
            throw new EntityNotFoundException("Publisher with ID " + publisherUpdateDTO.getPublisher_id() + " does not exist.");
        }
    }

}
