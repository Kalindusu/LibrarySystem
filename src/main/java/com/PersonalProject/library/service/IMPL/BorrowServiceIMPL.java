package com.PersonalProject.library.service.IMPL;

import com.PersonalProject.library.dto.BorrowDTO;
import com.PersonalProject.library.dto.BorrowSaveDTO;
import com.PersonalProject.library.dto.BorrowUpdateDTO;
import com.PersonalProject.library.entity.Book;
import com.PersonalProject.library.entity.Borrow;
import com.PersonalProject.library.entity.User;
import com.PersonalProject.library.repo.BookRepo;
import com.PersonalProject.library.repo.BorrowRepo;
import com.PersonalProject.library.repo.UserRepo;
import com.PersonalProject.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceIMPL implements BorrowService {


    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BorrowRepo borrowRepo;


    @Override
    public String addBorrow(BorrowSaveDTO borrowSaveDTO) {

        Borrow borrow = new Borrow(

                bookRepo.getById(borrowSaveDTO.getBook_id()),
                userRepo.getById(borrowSaveDTO.getUser_id()),
                borrowSaveDTO.getBorrowDate(),
                borrowSaveDTO.getReturnDate()

        );
        borrowRepo.save(borrow);

        return null;
    }

    @Override
    public List<BorrowDTO> getAllBorrow() {

        List<Borrow> getBorrow = borrowRepo.findAll();
        List<BorrowDTO> borrowDTOList = new ArrayList<>();

        for (Borrow borrow : getBorrow) {
            BorrowDTO borrowDTO = new BorrowDTO(
                    borrow.getId(),
                    borrow.getBook(),
                    borrow.getUser(),
                    borrow.getBorrowDate(),
                    borrow.getReturnDate()

            );
            borrowDTOList.add(borrowDTO);

        }
        return borrowDTOList;


    }

    @Override
    public String updateBorrow(BorrowUpdateDTO borrowUpdateDTO) {
        try {
            if (borrowRepo.existsById(borrowUpdateDTO.getId())) {
                Borrow borrow = borrowRepo.getById(borrowUpdateDTO.getId());

                // Check if book exists in bookRepo
                Book book = bookRepo.findById(borrowUpdateDTO.getBook_id())
                        .orElse(null);
                if (book == null) {
                    return "Book ID Not Found.";
                }

                // Check if user exists in userRepo
                User user = userRepo.findById(borrowUpdateDTO.getUser_id())
                        .orElse(null);
                if (user == null) {
                    return "User ID Not Found.";
                }

                borrow.setBook(book);
                borrow.setUser(user);
                borrow.setBorrowDate(borrowUpdateDTO.getBorrowDate());
                borrow.setReturnDate(borrowUpdateDTO.getReturnDate());

                borrowRepo.save(borrow);

                return "Borrow updated successfully.";
            } else {
                return "Borrow ID Not Found.";
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // Consider logging the error
            return "An error occurred while updating borrow: " + ex.getMessage();
        }
    }

    @Override
    public String deleteBorrow(int id) {
        try {
            if (borrowRepo.existsById(id)) {
                borrowRepo.deleteById(id);
                return "Borrow record deleted successfully.";
            } else {
                return "Borrow ID Not Found.";
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // Consider logging the error
            return "An error occurred while deleting borrow: " + ex.getMessage();
        }
    }

}