package com.PersonalProject.library.service.IMPL;

import com.PersonalProject.library.dto.UserDTO;
import com.PersonalProject.library.dto.UserSaveDTO;
import com.PersonalProject.library.dto.UserUpdateDTO;
import com.PersonalProject.library.entity.User;
import com.PersonalProject.library.repo.UserRepo;
import com.PersonalProject.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public String addUser(UserSaveDTO userSaveDTO) {
        User user = new User(
                userSaveDTO.getUserid(),
                userSaveDTO.getName(),
                userSaveDTO.getEmail()
        );
        userRepo.save(user);
        return user.getName();
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> getUsers = userRepo.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : getUsers) {
            UserDTO userDTO = new UserDTO(
                    user.getUserid(),
                    user.getName(),
                    user.getEmail()
            );
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public String updateUser(UserUpdateDTO userUpdateDTO) {
        if (userRepo.existsById(String.valueOf(userUpdateDTO.getUserid()))) {

            User user = userRepo.getById(String.valueOf(userUpdateDTO.getUserid()));
            user.setName(userUpdateDTO.getName());
            user.setEmail(userUpdateDTO.getEmail());
            userRepo.save(user);
            return user.getName();
        } else {
            System.out.println("User not Exist.....");
        }
        return null;
    }

    @Override
    public String deleteUser(String id) {
        if(userRepo.existsById(id))
        {
            userRepo.deleteById(id);
        }else{
            System.out.println("User not Found");
        }
        return null;
    }
}
