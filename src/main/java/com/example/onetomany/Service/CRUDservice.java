package com.example.onetomany.Service;

import com.example.onetomany.BaseResponse.BaseResponse;
import com.example.onetomany.DTO.*;
import com.example.onetomany.EntityORModel.Book;
import com.example.onetomany.EntityORModel.Student;
import com.example.onetomany.Repository.BookRepo;
import com.example.onetomany.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CRUDservice {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    StudentRepo studentRepo;

    public  BaseResponse post(StudentDTO studentDTO) {

        Student student = new Student();
        List<Book> booklist = new LinkedList<>();
        BaseResponse baseResponse= new BaseResponse();

        student.setStudentname(studentDTO.getStudentname());
        student.setCity(studentDTO.getCity());
        studentRepo.save(student);

        studentDTO.getBookDTO().stream().forEachOrdered(bookDTO -> {
            Book book2 = new Book();
            book2.setBookname(bookDTO.getBookname());
            book2.setAuthorName(bookDTO.getAuthorname());
            book2.setPages(bookDTO.getPages());
            book2.setStudent(student);
            booklist.add(book2);
            bookRepo.save(book2);
        });

        baseResponse.setStatuscode("200");
        baseResponse.setStatusmessage("successfully data inserted");
      //  baseResponse.setData(student);
        baseResponse.setData(booklist);
        return  baseResponse;
    }

    public BaseResponse getbyid(int studentid) {

        BaseResponse baseResponse=new BaseResponse();
        List<ListDTO> listDTOS = new LinkedList<>();
        List<Book> sabari = bookRepo.findAll();

            List<Book> book2=bookRepo.findByStudentStudentid(studentid);
            book2.stream().forEachOrdered(book3 -> {
                List<BookDTO> bookDTO1=new LinkedList<>();
                BookDTO bookDTO =new BookDTO();
                bookDTO.setBookname(book3.getBookname());
                bookDTO.setAuthorname(book3.getAuthorName());
                bookDTO.setPages(book3.getPages());
                bookDTO1.add(bookDTO);
                ListDTO listDTO=new ListDTO();
                listDTO.setStudentid(book3.getStudent().getStudentid());
                listDTO.setCity(book3.getStudent().getCity());
                listDTO.setStudentname(book3.getStudent().getStudentname());
                listDTO.setBookDTO(bookDTO1);
                listDTOS.add(listDTO);
            });
            baseResponse.setStatuscode("200");
            baseResponse.setStatusmessage("success");
            baseResponse.setData(listDTOS);
            return baseResponse;
        }

    public BaseResponse putupdate(BookDTO bookDTO) {

        BaseResponse baseResponse=new BaseResponse();
        Student student=new Student();
        Book book123 = new Book();


       // List<Book> overallupdatedlist = new LinkedList<>();

       /* Optional<Student> sabari = studentRepo.findById(summaDTO.getStudendid());
        sabari.get().setStudentname(summaDTO.getStudentname());
        sabari.get().setCity(summaDTO.getCity());
        studentRepo.save(student);*/

        Optional<Book> bookupdate = bookRepo.findById(bookDTO.getBookid());
        bookupdate.get().setBookname(bookDTO.getBookname());
        bookupdate.get().setAuthorName(bookDTO.getAuthorname());
        bookupdate.get().setPages(bookDTO.getPages());
        bookupdate.get().setStudent(bookupdate.get().getStudent());
        bookRepo.save(book123);

       /* List<Book> fullbooklist = bookRepo.findAll();
        Optional<Book> fkbooks = bookRepo.findByStudentStudentid(studentid);
        //fkbooks.stream().forEachOrdered(book -> {
            Book newbook = new Book();
            newbook.setBookname(book.getBookname());
            newbook.setAuthorName(book.getAuthorName());
            newbook.setPages(book.getPages());
            bookRepo.save(newbook);
        });*/


       /* studentDTO.getBookDTO().stream().forEachOrdered(bookDTO -> {
            Book book2 = new Book();
            book2.setBookname(bookDTO.getBookname());
            book2.setAuthorName(bookDTO.getAuthorname());
            book2.setPages(bookDTO.getPages());
            book2.setStudent(student);
            booklist.add(book2);
            bookRepo.save(book2);
        });*/

        baseResponse.setStatuscode("200");
        baseResponse.setStatusmessage("successfully data inserted");
        return baseResponse;
    }



}
