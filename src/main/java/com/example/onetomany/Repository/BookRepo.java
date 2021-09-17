package com.example.onetomany.Repository;

import com.example.onetomany.EntityORModel.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
    //List<Book> findByStu_Id(int studentid);

    //List<Book> findByStudent(int studentid);

    //List<Book> findByStudentId(int studentid);

    List<Book> findByStudentStudentid(int studentid);


    // List<Book> findbystudent(int id);
}
