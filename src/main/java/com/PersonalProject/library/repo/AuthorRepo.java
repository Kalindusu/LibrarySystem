package com.PersonalProject.library.repo;

import com.PersonalProject.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
