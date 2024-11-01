package com.PersonalProject.library.service;

import com.PersonalProject.library.dto.UserDTO;
import com.PersonalProject.library.dto.UserSaveDTO;
import com.PersonalProject.library.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    String addUser(UserSaveDTO userSaveDTO);

    List<UserDTO> getAllUser();

    String updateUser(UserUpdateDTO userUpdateDTO);

//    String deleteUser(int id);

    String deleteUser(String id);
}
