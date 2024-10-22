package com.PersonalProject.library.service;

import com.PersonalProject.library.dto.BorrowDTO;
import com.PersonalProject.library.dto.BorrowSaveDTO;
import com.PersonalProject.library.dto.BorrowUpdateDTO;

import java.util.List;

public interface BorrowService {
    String addBorrow(BorrowSaveDTO borrowSaveDTO);

    List<BorrowDTO> getAllBorrow();

    String updateBorrow(BorrowUpdateDTO borrowUpdateDTO);
}