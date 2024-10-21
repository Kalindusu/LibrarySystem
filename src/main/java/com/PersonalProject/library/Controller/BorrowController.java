package com.PersonalProject.library.Controller;

import com.PersonalProject.library.dto.BorrowDTO;
import com.PersonalProject.library.dto.BorrowSaveDTO;
import com.PersonalProject.library.dto.BorrowUpdateDTO;
import com.PersonalProject.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping(path = "/save")
    public String saveBorroe(@RequestBody BorrowSaveDTO borrowSaveDTO)
    {
        String borrowBooks = borrowService.addBorrow(borrowSaveDTO);
        return  "Borrowel Successfully";
    }

    @GetMapping(path = "/getAllBorrow")
    public List<BorrowDTO> getAllBorrow()
    {
        List<BorrowDTO> allborrow = borrowService.getAllBorrow();
        return allborrow;
    }

    @PutMapping(path = "/update")
    public String updateBorrow(@RequestBody BorrowUpdateDTO borrowUpdateDTO)
    {
        String borrow = borrowService.updateBorrow(borrowUpdateDTO);
        return  "Update added";
    }

}