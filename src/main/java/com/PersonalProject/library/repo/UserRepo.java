package com.PersonalProject.library.repo;

import com.PersonalProject.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
