package com.example.onetomany.Controller;

import com.example.onetomany.BaseResponse.BaseResponse;
import com.example.onetomany.DTO.*;
import com.example.onetomany.EntityORModel.Book;
import com.example.onetomany.EntityORModel.Student;
import com.example.onetomany.Repository.BookRepo;
import com.example.onetomany.Repository.StudentRepo;
import com.example.onetomany.Service.CRUDservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/onetomany")
public class CRUDcontroller {
    @Autowired
    CRUDservice crudservice;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    BookRepo bookRepo;
    private BookRepo bookRepo1;


    @PostMapping("/post")
    public BaseResponse post(@RequestBody StudentDTO studentDTO) {
        return crudservice.post(studentDTO);
    }

    @GetMapping("/getall")
    public List<Book> getall() {
        return bookRepo.findAll();
    }

    @GetMapping("/getbyid")
    public BaseResponse summa(@RequestParam int studentid) {
        BaseResponse baseResponse = new BaseResponse();
        return crudservice.getbyid(studentid);
    }

    @PutMapping("/putupdate")
    public BaseResponse put(@RequestBody BookDTO bookDTO) {
        return crudservice.putupdate(bookDTO);
    }

}





