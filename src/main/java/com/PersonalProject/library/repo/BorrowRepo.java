package com.PersonalProject.library.repo;

import com.PersonalProject.library.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepo extends JpaRepository<Borrow,Integer > {
}